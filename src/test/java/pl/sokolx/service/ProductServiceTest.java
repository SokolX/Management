package pl.sokolx.service;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pl.sokolx.models.Boots;
import pl.sokolx.models.Cloth;
import pl.sokolx.models.Product;
import pl.sokolx.models.enums.Color;
import pl.sokolx.models.enums.Material;
import pl.sokolx.models.enums.SkinType;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ProductServiceTest {

    ProductServiceImpl sut = new ProductServiceImpl();

    @Test
    public void testGetAllProducts() throws IOException {
        //given
        List<Product> expectedProducts = prepareProductList();

        //when
        List<Product> resultProducts = sut.getAllProducts();

        //then
        for (int i = 0; i < expectedProducts.size(); i++) {
            assertEquals(expectedProducts.get(i), resultProducts.get(i), "Mismatch at index " + i);
        }
        assertEquals(expectedProducts, resultProducts);
    }

    @Test
    public void testGetAllProductsNotEquals() throws IOException {
        //given
        List<Product> products = new ArrayList<>();
        products.add(new Product(1L, "Testowy", BigDecimal.valueOf(14.99), 1.5f,
                Color.RED, 15));
        products.add(new Boots(2L, "Obuwie testowe", BigDecimal.valueOf(99.99), 1.00f,
                Color.BLACK, 5, 43, SkinType.ARTIFICIAL));
        products.add(new Cloth(3L, "Jacket", BigDecimal.valueOf(199.99), 1.5f,
                Color.BLACK, 10, "S", Material.JEANS));

        //when
        List<Product> productsFromTestClass = sut.getAllProducts();

        List<Product> products2 = new ArrayList<>();
        products2.add(new Product(1L, "Testowy", BigDecimal.valueOf(14.99), 1.5f,
                Color.RED, 15));

        //then
        assertNotEquals(products2, productsFromTestClass);
    }

    @Test
    public void testGetCounterProduct() throws IOException {
        //given
        List<Product> products = prepareProductList();

        //when
        int couterProducts = sut.getCountProducts();

        //then
        assertEquals(products.size(), couterProducts);
    }

    @Test
    public void testGetCounterProductNoEquals() throws IOException {
        //given
        prepareProductList();

        int couterProducts = sut.getCountProducts();

        //then
        assertNotEquals(11, couterProducts);
    }

    @Test
    public void testGetProductByProductName() throws IOException {
        //given
        List<Product> products = prepareProductList();

        //when
        Product productFromTestClass = sut.getProductByProductName("Jacket");

        //then
        assertEquals(products.get(2), productFromTestClass);
    }

    @Test
    public void testGetProductByProductNameReturnNull() throws IOException {
        //given
        prepareProductList();

        //when
        Product productFromTestClass = sut.getProductByProductName("Wiesław");

        //then
        assertNull(productFromTestClass);
    }

    @Test
    public void testGetProductByProductNameNoEquals() throws IOException {
        //given
        List<Product> products = prepareProductList();

        //when
        Product productFromTestClass = sut.getProductByProductName("waldek");

        //then
        assertNotEquals(products.get(2), productFromTestClass);
    }

    @Test
    public void testGetProductByProductNameNoEqualsReturnNull() throws IOException {
        //given
        List<Product> products = prepareProductList();

        //when
        Product productFromTestClass = sut.getProductByProductName("waldek");

        //then
        assertNotEquals(products.get(2), productFromTestClass);
    }

    @Test
    @Disabled
    public void testCounterProductIsBiggerThanZero() {
        //given
        prepareProductList();

        //when
        //boolean biggerThanZero = sut.counterProductIsBiggerThanZero("Jacket");

        //then
        //assertTrue(biggerThanZero);
    }

    @Test
    @Disabled
    public void testCounterProductIsBiggerThanZeroNoEquals() {
        //given
        prepareProductList();

        //when
        //boolean biggerThanZero = sut.counterProductIsBiggerThanZero("Jacket");

        //then
        //assertNotEquals(SkinType.ARTIFICIAL, biggerThanZero);
    }

    @Test
    @Disabled
    public void testProductNameDoesExist() {
        //given
        prepareProductList();

        //when
        //boolean productIsExist = sut.productNameDoesExist("Jacket");

        //then
        //Assert.assertEquals(true, productIsExist);
    }

    @Test
    @Disabled
    public void testProductNameDoesExistNoEquals() {
        //given
        List<Product> products = prepareProductList();

        //when
        //boolean productIsExist = sut.productNameDoesExist("Jacket2");

        //then
        //Assert.assertNotEquals(null, productIsExist);
    }

    @Test
    @Disabled
    public void testProductByIdDoesExist() {
        //given
        prepareProductList();

        //when
        //boolean productIsExist = sut.productByIdDoesExist(1l);

        //then
        //Assert.assertEquals(true, productIsExist);
    }

    @Test
    @Disabled
    public void testProductByIdDoesExistNoEquals() {
        //given
        List<Product> products = prepareProductList();

        //when
        //boolean productIsExist = sut.productByIdDoesExist(45l);

        //then
        //Assert.assertNotEquals(null, productIsExist);
    }

    private static List<Product> prepareProductList() {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1L,
                                 "Testowy",
                                 BigDecimal.valueOf(14.99),
                                 1.5f,
                                 Color.RED,
                                 15));
        products.add(new Boots(2L,
                                 "Obuwie testowe",
                                 BigDecimal.valueOf(99.99),
                                 1.00f,
                                 Color.BLACK,
                                 5,
                                 43,
                                 SkinType.ARTIFICIAL));
        products.add(new Cloth(3L,
                               "Jacket",
                               BigDecimal.valueOf(199.99),
                               1.5f,
                               Color.BLUE,
                               10,
                               "S",
                               Material.JEANS));
        return products;
    }
}
