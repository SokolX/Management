package pl.sokolx.dao;

import pl.sokolx.api.ProductDao;
import pl.sokolx.models.Product;
import pl.sokolx.models.parser.ProductParser;
import pl.sokolx.utils.FileUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static pl.sokolx.utils.FileUtils.createNewFile;

public class ProductDaoImpl implements ProductDao {

    private static final String FILE_NAME = "./target/products.txt";
    private static ProductDao instance = null;

    private ProductDaoImpl() {
        try {
            createNewFile(FILE_NAME);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ProductDao getInstance() {
        if (instance == null) {
            instance = new ProductDaoImpl();
        }

        return instance;
    }

    @Override
    public void saveProduct(Product product) throws IOException {
        List<Product> products = getAllProducts();
        products.add(product);
        saveProducts(products);
    }

    @Override
    public void saveProducts(List<Product> products) throws FileNotFoundException {
        FileUtils.clearFile(FILE_NAME);
        PrintWriter printWriter = new PrintWriter(new FileOutputStream(FILE_NAME, true));
        for(Product product : products) {
            printWriter.write(product.toString() + "\n");
        }
        printWriter.close();
    }

    @Override
    public void removeProductById(Long productId) throws IOException {
        List<Product> products = getAllProducts();

        for(int i=0;i<products.size(); i++) {
            boolean isFoundProduct = products.get(i).getProductId().equals(productId);
            if (isFoundProduct) {
                products.remove(i);
            }
        }

        saveProducts(products);
    }

    @Override
    public void removeProductByName(String productName) throws IOException {
        List<Product> products = getAllProducts();

        for(int i=0;i<products.size(); i++) {
            boolean isFoundProduct = products.get(i).getProductName().equals(productName);
            if (isFoundProduct) {
                products.remove(i);
            }
        }

        saveProducts(products);
    }

    @Override
    public List<Product> getAllProducts() throws IOException {
        List<Product> products = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_NAME));

        String readLine = bufferedReader.readLine();
        while(readLine != null) {
            Product product = ProductParser.stringToProduct(readLine);
            if (product != null) {
                products.add(product);
            }
            readLine = bufferedReader.readLine();
        }
        bufferedReader.close();

        return products;
    }
}
