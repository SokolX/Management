package pl.sokolx.dao;

import pl.sokolx.api.ProductDao;
import pl.sokolx.models.Boots;
import pl.sokolx.models.Cloth;
import pl.sokolx.models.Product;
import pl.sokolx.models.ProductType;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {

    @Override
    public void saveProduct(Product product) throws FileNotFoundException {
        String fileName = "/home/sokolx/IdeaProjects/Management/target/products.txt";
        FileOutputStream fileOutputStream = new FileOutputStream(fileName, true);
        PrintWriter printWriter = new PrintWriter(fileOutputStream);

        printWriter.write(product.toString() + "\n");

        printWriter.close();
    }

    @Override
    public void saveProducts(List<Product> products) throws FileNotFoundException {
        String fileName = "/home/sokolx/IdeaProjects/Management/target/products.txt";
        FileOutputStream fileOutputStream = new FileOutputStream(fileName, true);
        PrintWriter printWriter = new PrintWriter(fileOutputStream);

        for (Product product : products) {
            printWriter.write(product.toString() + "\n");
        }

        printWriter.close();
    }

    @Override
    public void removeProductById(Long productId) {

    }

    @Override
    public void removeProductByName(String productName) {

    }

    @Override
    public List<Product> getAllProducts() throws IOException {
        String fileNameProducts = "/home/sokolx/IdeaProjects/Management/target/products.txt";
        List<Product> products = new ArrayList<Product>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileNameProducts));

        String readLine = bufferedReader.readLine();
        while(readLine != null) {

            String [] productToList = readLine.split(",");

            Long productId = Long.parseLong(productToList[0]);
            String productName = productToList[1];
            Float productPrice = Float.parseFloat(productToList[2]);
            Float productWeight = Float.parseFloat(productToList[3]);
            String productColor = productToList[4];
            Integer productCount = Integer.parseInt(productToList[5]);
            String productType = productToList[6];

            if(productType.equals("PRODUCTS")) {
                Product nowy = new Product(productId, productName, productPrice, productWeight, productColor, productCount, ProductType.PRODUCT);
                products.add(nowy);

            } else if(productType.equals("BOOTS")) {

                Integer bootSize = Integer.parseInt(productToList[7]);
                Boolean bootsIsNaturalSkin = Boolean.valueOf(productToList[8]);
                Boots nowy = new Boots(productId, productName, productPrice, productWeight, productColor, productCount, ProductType.BOOTS,
                        bootSize, bootsIsNaturalSkin);
                products.add(nowy);

            } else if(productType.equals("CLOTH")) {
                String clothSize = productToList[7];
                String clothMaterial = productToList[8];
                Cloth nowy = new Cloth(productId, productName, productPrice, productWeight, productColor, productCount, ProductType.CLOTH,
                        clothSize, clothMaterial);
                products.add(nowy);
            }

            readLine = bufferedReader.readLine();
        }

        bufferedReader.close();


        for (Product product1 : products) {
            System.out.println("id = " + product1.getProductId() + ", productName: " + product1.getProductName());
        }

        return products;

    }

    @Override
    public Product getProductById(Long productId) {
        return null;
    }

    @Override
    public Product getProductByProductName(String productName) {
        return null;
    }
}
