package pl.sokolx.models;

public class Main {

    public static void main(String[] args) {

        User user = new User(1l, "user", "userPassword");
        System.out.println(user.toString());

        Product product = new Product(1L, "Testowy", 14.99, 1.5f, "Red", 15);
        System.out.println(product.toString());

        Boots boots = new Boots(2L, "Obuwie testowe", 99.99, 1.00f, "Black", 5, 43, false);
        System.out.println(boots.toString());

        Cloth cloth = new Cloth(3L, "Jacket", 199.99, 1.5f, "Blue", 10, "S", "Jeans");
        System.out.println(cloth.toString());

    }
}
