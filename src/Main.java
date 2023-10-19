import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static List<Category> categories;
    private static List<Menu>[] menus;
    private static Cart cart;
    private static int index;
    private static final int CATEGORY_SIZE = 4;
    private static final String MAIN_COMMENT = "SHAKESHAKE BURGER 에 오신걸 환영합니다.";
    private static Scanner sc;
    public static void main(String[] args) {
        init();

        while (true) {
            int category = printCategory();
            if (category < 1 || 6 < category) {
                System.out.println("잘못된 입력입니다.\n");
                continue;
            }

            if (1 <= category && category <= CATEGORY_SIZE) {
                int menu = printMenu(category);
                if (menu < 1 || menus[category].size() < menu) {
                    System.out.println("잘못된 입력입니다.");
                    return;
                }

                int choice = printToCart(menus[category].get(menu - 1));

                if (choice == 1) {
                    cart.addMenu(menus[category].get(menu - 1));
                    System.out.println(menus[category].get(menu - 1).name + " 가 장바구니에 추가되었습니다.\n");
                } else if (choice == 2) {
                    System.out.println("취소되었습니다.\n");
                } else {
                    System.out.println("잘못된 입력입니다.");
                    return;
                }
            } else if (category == 5) {
                int choice = printOrder();

                if (choice == 1) {
                    System.out.println("주문이 완료되었습니다!\n");
                    System.out.println("대기 번호는 [ " + index++ + " ] 번 입니다.");
                    System.out.println("(3초 후 메뉴판으로 이동합니다.)\n");
                    cart.clear();
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else if (choice != 2) {
                    System.out.println("잘못된 입력입니다.");
                    return;
                }
            } else cancelOrder();

        }
    }

    private static void cancelOrder() {
        System.out.println("진행하던 주문을 취소하시겠습니까?");
        System.out.println("1. 확인\t\t\t2. 취소");

        int choice = sc.nextInt();
        if (choice == 1) {
            System.out.println("진행하던 주문이 취소되었습니다.\n");
            index -= 1;
            cart.clear();
        } else if (choice == 2) {
            System.out.println("주문을 취소하지 않습니다.\n");
        } else {
            System.out.println("잘못된 입력입니다.\n");
        }
    }

    private static int printOrder() {
        System.out.println("아래와 같이 주문하시겠습니까?");

        System.out.println("\n[ Orders ]");
        cart.printMenus();

        System.out.println("\n[ Total ]");
        cart.getTotalPrice();

        System.out.println("1. 주문\t\t\t2. 메뉴판");

        return sc.nextInt();
    }

    private static int printToCart(Menu menu) {
        menu.printToCart();

        System.out.println("위 메뉴를 장바구에 추가하시겠습니까?");
        System.out.println("1. 확인\t\t\t2.취소");

        return sc.nextInt();
    }

    private static int printMenu(int category) {
        System.out.println(MAIN_COMMENT);
        System.out.println("아래 상품 메뉴판을 보시고 메뉴를 골라 입력해주세요\n");

        System.out.printf("[ %s MENU ]\n", categories.get(category - 1).name);
        for (Menu menu : menus[category]) {
            menu.print();
        }
        return sc.nextInt();
    }

    private static int printCategory() {
        System.out.println(MAIN_COMMENT);
        System.out.println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.\n");

        System.out.println("[ SHAKESHAKE MENU ]");
        for (Category category : categories) {
            category.print();
        }

        System.out.println("\n[ ORDER MENU ]");
        System.out.printf("%d. %-15s | 장바구니를 확인 후 주문합니다.\n", 5, "Order");
        System.out.printf("%d. %-15s | 진행중인 주문을 취소합니다.\n", 6, "Cancel");

        return sc.nextInt();
    }

    private static void init() {
        sc = new Scanner(System.in);

        categories = new ArrayList<>();
        menus = new List[CATEGORY_SIZE + 1];
        cart = new Cart();

        for (int i = 1; i <= CATEGORY_SIZE; i++) {
            menus[i] = new ArrayList<>();
        }

        categories.add(new Category(1, "Burgers", "앵거스 비프 통살을 다져 만든 버거"));
        categories.add(new Category(2, "Frozen Custard", "매장에서 신선하게 만드는 아이스크림"));
        categories.add(new Category(3, "Drinks", "매장에서 직접 만드는 음료"));
        categories.add(new Category(4, "Beer", "뉴욕 브루클린 브루어리에서 양조한 맥주"));

        menus[1] = Arrays.asList(
                new Menu(1, "ShackBurger", "토마토, 양상추, 쉑소스가 토핑된 치즈버거", 6900),
                new Menu(2, "SmokeShack", "애플 무드 칩으로 훈연한 베이컨, 매콤한 체리 페퍼에 쉑소스가 토핑된 치즈버거", 8900),
                new Menu(3, "Shroom Burger", "몬스터 치즈와 체다 치즈로 속을 채우고 바삭하게 튀겨낸 포토벨로 버섯 패티에 양상추, 토마토, 쉑소스를 올린 베지테리안 버거", 9400),
                new Menu(4, "Shack Shack", "슈룸 버거와 쉑버거의 맛을 한번에 즐길 수 있는 메뉴", 12400),
                new Menu(5, "Cheeseburger", "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거", 6900),
                new Menu(6, "Hamburger", "포테이토 번과 비프패티를 기본으로 신선한 양상추, 토마토 피클, 양파 토핑을 취향에 따라 선택할 수 있는 버거", 5400)
        );

        menus[2] = Arrays.asList(
                new Menu(1, "Shaker", "바닐라, 초콜렛, 솔티드 카라멜, 블랙&화이트, 스트로베리, 피넛버터, 커피", 5900),
                new Menu(2, "Shake of the Week", "특별한 커스터드 플레이버", 6500),
                new Menu(3, "Red Bean Shake", "신선한 커스터드와 함께 우유와 레드빈이 블렌딩 된 시즈널 쉐이크", 6500),
                new Menu(4, "Floats", "루트 비어, 퍼플 카우, 크림시클", 5900),
                new Menu(5, "Cup&Cone", "바닐라, 초콜릿, Flavor of the Week", 4900)
        );

        menus[3] = Arrays.asList(
                new Menu(1, "Shack-made Lemonade", "매장에서 직접 만드는 상큼한 레몬에이드", 3900),
                new Menu(2, "Fresh Brewed Iced Tea", "직접 유기농 홍차를 우려낸 아이스티", 3400),
                new Menu(3, "Fifty/Fifty", "레몬에이드와 아이스티의 만남", 3500),
                new Menu(4, "Fountain Soda", "코카콜라, 코카콜라 제로, 스프라이트 환타 오렌지, 환타 그레이프", 2700),
                new Menu(5, "Abita Root Beer", "청량감있는 독특한 미국식 무알콜 탄산음료", 4400),
                new Menu(6, "Bottled Water", "지리산 암반대수층으로 만든 프리미엄 생수", 1000)
        );

        menus[4] = Arrays.asList(
                new Menu(1, "ShackMeister Ale", "쉐이크쉑 버거를 위해 뉴욕 브루클린 브루어리에서 특별히 양조한 에일 맥주", 9800),
                new Menu(2, "Magpie Brewing Co.", "", 6800),
                new Menu(3, "The Hand and Malt", "", 6800)
        );
    }
}