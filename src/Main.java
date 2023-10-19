import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    private static List<Category> categories;
    private static List<Menu>[] menus;
    private static final int CATEGORY_SIZE = 4;

    public static void main(String[] args) {
        initCategories();
        initMenus();
    }

    private static void initMenus() {
        menus = new List[CATEGORY_SIZE + 1];
        for (int i = 1; i <= CATEGORY_SIZE; i++) {
            menus[i] = new ArrayList<>();
        }

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

    private static void initCategories() {
        categories = new ArrayList<>();

        categories.add(new Category(1, "Burgers", "앵거스 비프 통살을 다져 만든 버거"));
        categories.add(new Category(2, "Frozen Custard", "매장에서 신선하게 만드는 아이스크림"));
        categories.add(new Category(3, "Drinks", "매장에서 직접 만드는 음료"));
        categories.add(new Category(4, "Beer", "뉴욕 브루클린 브루어리에서 양조한 맥주"));
    }
}