package pl.sokolx.service;

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

    ProductServiceImpl sut = new ProductServiceImpl(prepareProductList());

    @Test
    public void shouldReturnAllProducts() throws IOException {
        //given
        List<Product> expectedProducts = prepareProductList();

        //when
        List<Product> resultProducts = sut.getAllProducts();

        //then
        assertEquals(expectedProducts, resultProducts);
    }

    @Test
    public void shouldReturnIncorrectProductListWhenGetAllProducts() throws IOException {
        //given
        List<Product> expectedProducts = new ArrayList<>();
        expectedProducts.add(new Product(1L, "Testowy", BigDecimal.valueOf(14.99), 1.5f,
                Color.RED, 15));
        expectedProducts.add(new Boots(2L, "Obuwie testowe", BigDecimal.valueOf(99.99), 1.00f,
                Color.BLACK, 5, 43, SkinType.ARTIFICIAL));
        expectedProducts.add(new Cloth(3L, "Jacket", BigDecimal.valueOf(199.99), 1.5f,
                Color.BLACK, 10, "S", Material.JEANS));

        //when
        List<Product> result = sut.getAllProducts();

        //then
        assertNotEquals(expectedProducts, result);
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
    public void shouldReturnTrueWhenCounterProductIsBiggerThanZero() {
        //given when then
        assertTrue(sut.counterProductIsBiggerThanZero("Jacket"));
    }

    @Test
    public void shouldReturnFalseWhenCounterProductIsNotBiggerThanZero() {
        //given when then
        assertFalse(sut.counterProductIsBiggerThanZero("Jacket00000"));
    }

    @Test
    public void shouldReturnTrueWhenProductDoesExistByName() {
        //given when then
        assertTrue(sut.isProductExistByName("Jacket"));
    }

    @Test
    public void shouldReturnFalseWhenProductNameDoesNotExist() {
        //given when then
        assertFalse(sut.isProductExistByName("DoesNotExist"));
    }

    @Test
    public void returnTrueWhenProductByIdDoesExist() {
        //given when then
        assertTrue(sut.isProductExistById(1L));
    }

    @Test
    public void returnFalseWhenProductByIdDoesNotExist() {
        //given when then
        assertTrue(sut.isProductExistById(1L));
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
