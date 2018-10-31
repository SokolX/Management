package pl.sokolx.service;

public class ProductServiceTest {
/*
    @Test
    public void testGetAllProducts() {
        List<Product> products = new ArrayList<Product>();
        products.add(new Product(1L, "Testowy", 14.99, 1.5f,
                "Red", 15));
        products.add(new Boots(2L, "Obuwie testowe", 99.99, 1.00f,
                "Black", 5, 43, false));
        products.add(new Cloth(3L, "Jacket", 199.99, 1.5f,
                "Blue", 10, "S", "Jeans"));

        ProductServiceImpl productServiceImpl = new ProductServiceImpl(products);
        List<Product> productsFromTestClass = productServiceImpl.getAllProducts();

        Assert.assertEquals(products, productsFromTestClass);
    }

    @Test
    public void testGetAllProductsNotEquals() {

        List<Product> products = new ArrayList<Product>();
        products.add(new Product(1L, "Testowy", 14.99, 1.5f,
                "Red", 15));
        products.add(new Boots(2L, "Obuwie testowe", 99.99, 1.00f,
                "Black", 5, 43, false));
        products.add(new Cloth(3L, "Jacket", 199.99, 1.5f,
                "Blue", 10, "S", "Jeans"));

        ProductServiceImpl productServiceImpl = new ProductServiceImpl(products);
        List<Product> productsFromTestClass = productServiceImpl.getAllProducts();



        List<Product> products2 = new ArrayList<Product>();
        products2.add(new Product(1L, "Testowy", 14.99, 1.5f,
                "Red", 15));


        Assert.assertNotEquals(products2, productsFromTestClass);
    }

    @Test
    public void testGetCounterProduct() {

        List<Product> products = new ArrayList<Product>();
        products.add(new Product(1L, "Testowy", 14.99, 1.5f,
                "Red", 15));
        products.add(new Boots(2L, "Obuwie testowe", 99.99, 1.00f,
                "Black", 5, 43, false));
        products.add(new Cloth(3L, "Jacket", 199.99, 1.5f,
                "Blue", 10, "S", "Jeans"));

        ProductServiceImpl productServiceImpl = new ProductServiceImpl(products);
        int couterProducts = productServiceImpl.getCounterProducts();

        Assert.assertEquals(products.size(), couterProducts);
    }

    @Test
    public void testGetCounterProductNoEquals() {

        List<Product> products = new ArrayList<Product>();
        products.add(new Product(1L, "Testowy", 14.99, 1.5f,
                "Red", 15));
        products.add(new Boots(2L, "Obuwie testowe", 99.99, 1.00f,
                "Black", 5, 43, false));
        products.add(new Cloth(3L, "Jacket", 199.99, 1.5f,
                "Blue", 10, "S", "Jeans"));

        ProductServiceImpl productServiceImpl = new ProductServiceImpl(products);
        int couterProducts = productServiceImpl.getCounterProducts();

        Assert.assertNotEquals(couterProducts, 11);
    }

    @Test
    public void testGetProductByProductName() {

        List<Product> products = new ArrayList<Product>();
        products.add(new Product(1L, "Testowy", 14.99, 1.5f,
                "Red", 15));
        products.add(new Boots(2L, "Obuwie testowe", 99.99, 1.00f,
                "Black", 5, 43, false));
        products.add(new Cloth(3L, "Jacket", 199.99, 1.5f,
                "Blue", 10, "S", "Jeans"));

        ProductServiceImpl productServiceImpl = new ProductServiceImpl(products);
        Product productFromTestClass = productServiceImpl.getProductByProductName("Jacket");

        Assert.assertEquals(products.get(2), productFromTestClass);
    }

    @Test
    public void testGetProductByProductNameReturnNull() {

        List<Product> products = new ArrayList<Product>();
        products.add(new Product(1L, "Testowy", 14.99, 1.5f,
                "Red", 15));
        products.add(new Boots(2L, "Obuwie testowe", 99.99, 1.00f,
                "Black", 5, 43, false));
        products.add(new Cloth(3L, "Jacket", 199.99, 1.5f,
                "Blue", 10, "S", "Jeans"));

        ProductServiceImpl productServiceImpl = new ProductServiceImpl(products);
        Product productFromTestClass = productServiceImpl.getProductByProductName("Wiesław");

        Assert.assertEquals(null, productFromTestClass);
    }

    @Test
    public void testGetProductByProductNameNoEquals() {

        List<Product> products = new ArrayList<Product>();
        products.add(new Product(1L, "Testowy", 14.99, 1.5f,
                "Red", 15));
        products.add(new Boots(2L, "Obuwie testowe", 99.99, 1.00f,
                "Black", 5, 43, false));
        products.add(new Cloth(3L, "Jacket", 199.99, 1.5f,
                "Blue", 10, "S", "Jeans"));

        ProductServiceImpl productServiceImpl = new ProductServiceImpl(products);
        Product productFromTestClass = productServiceImpl.getProductByProductName("waldek");

        Assert.assertNotEquals(products.get(2), productFromTestClass);
    }

    @Test
    public void testGetProductByProductNameNoEqualsReturnNull() {

        List<Product> products = new ArrayList<Product>();
        products.add(new Product(1L, "Testowy", 14.99, 1.5f,
                "Red", 15));
        products.add(new Boots(2L, "Obuwie testowe", 99.99, 1.00f,
                "Black", 5, 43, false));
        products.add(new Cloth(3L, "Jacket", 199.99, 1.5f,
                "Blue", 10, "S", "Jeans"));

        ProductServiceImpl productServiceImpl = new ProductServiceImpl(products);
        Product productFromTestClass = productServiceImpl.getProductByProductName("waldek");

        Assert.assertNotEquals(products.get(2), productFromTestClass);
    }

    @Test
    public void testCounterProductIsBiggerThanZero() {

        List<Product> products = new ArrayList<Product>();
        products.add(new Product(1L, "Testowy", 14.99, 1.5f,
                "Red", 15));
        products.add(new Boots(2L, "Obuwie testowe", 99.99, 1.00f,
                "Black", 5, 43, false));
        products.add(new Cloth(3L, "Jacket", 199.99, 1.5f,
                "Blue", 10, "S", "Jeans"));

        ProductServiceImpl productServiceImpl = new ProductServiceImpl(products);
        boolean biggerThanZero = productServiceImpl.counterProductIsBiggerThanZero("Jacket");

        Assert.assertEquals(true, biggerThanZero);
    }

    @Test
    public void testCounterProductIsBiggerThanZeroNoEquals() {

        List<Product> products = new ArrayList<Product>();
        products.add(new Product(1L, "Testowy", 14.99, 1.5f,
                "Red", 15));
        products.add(new Boots(2L, "Obuwie testowe", 99.99, 1.00f,
                "Black", 5, 43, false));
        products.add(new Cloth(3L, "Jacket", 199.99, 1.5f,
                "Blue", 10, "S", "Jeans"));

        ProductServiceImpl productServiceImpl = new ProductServiceImpl(products);
        boolean biggerThanZero = productServiceImpl.counterProductIsBiggerThanZero("Jacket");

        Assert.assertNotEquals(false, biggerThanZero);
    }

    @Test
    public void testProductNameDoesExist() {

        List<Product> products = new ArrayList<Product>();
        products.add(new Product(1L, "Testowy", 14.99, 1.5f,
                "Red", 15));
        products.add(new Boots(2L, "Obuwie testowe", 99.99, 1.00f,
                "Black", 5, 43, false));
        products.add(new Cloth(3L, "Jacket", 199.99, 1.5f,
                "Blue", 10, "S", "Jeans"));

        ProductServiceImpl productServiceImpl = new ProductServiceImpl(products);
        boolean productIsExist = productServiceImpl.productNameDoesExist("Jacket");

        Assert.assertEquals(true, productIsExist);
    }

    @Test
    public void testProductNameDoesExistNoEquals() {

        List<Product> products = new ArrayList<Product>();
        products.add(new Product(1l, "Testowy", 14.99, 1.5f,
                "Red", 15));
        products.add(new Boots(2l, "Obuwie testowe", 99.99, 1.00f,
                "Black", 5, 43, false));
        products.add(new Cloth(3l, "Jacket", 199.99, 1.5f,
                "Blue", 10, "S", "Jeans"));

        ProductServiceImpl productServiceImpl = new ProductServiceImpl(products);
        boolean productIsExist = productServiceImpl.productNameDoesExist("Jacket2");

        Assert.assertNotEquals(null, productIsExist);
    }

    @Test
    public void testProductByIdDoesExist() {

        List<Product> products = new ArrayList<Product>();
        products.add(new Product(1L, "Testowy", 14.99, 1.5f,
                "Red", 15));
        products.add(new Boots(2L, "Obuwie testowe", 99.99, 1.00f,
                "Black", 5, 43, false));
        products.add(new Cloth(3L, "Jacket", 199.99, 1.5f,
                "Blue", 10, "S", "Jeans"));

        ProductServiceImpl productServiceImpl = new ProductServiceImpl(products);
        boolean productIsExist = productServiceImpl.productByIdDoesExist(1l);

        Assert.assertEquals(true, productIsExist);
    }

    @Test
    public void testProductByIdDoesExistNoEquals() {

        List<Product> products = new ArrayList<Product>();
        products.add(new Product(1l, "Testowy", 14.99, 1.5f,
                "Red", 15));
        products.add(new Boots(2l, "Obuwie testowe", 99.99, 1.00f,
                "Black", 5, 43, false));
        products.add(new Cloth(3l, "Jacket", 199.99, 1.5f,
                "Blue", 10, "S", "Jeans"));

        ProductServiceImpl productServiceImpl = new ProductServiceImpl(products);
        boolean productIsExist = productServiceImpl.productByIdDoesExist(45l);

        Assert.assertNotEquals(null, productIsExist);
    }*/
}
