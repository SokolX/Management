package pl.sokolx.models;

public class Boots extends Product {

    private int bootsSize;
    private boolean bootsIsNaturalSkin;
    private ProductType productType;


    public Boots(Long productId, String productName, double productPrice, float productWeight, String productColor, int productCount, ProductType productType, int bootsSize, boolean bootsIsNaturalSkin) {
        super(productId, productName, productPrice, productWeight, productColor, productCount, productType = ProductType.BOOTS);
        
        this.bootsSize = bootsSize;
        this.bootsIsNaturalSkin = bootsIsNaturalSkin;

    }

    public int getBootsSize() {
        return bootsSize;
    }

    public boolean getBootsIsNaturalSkin() {
        return bootsIsNaturalSkin;
    }

    @Override
    public String toString() {
        return super.toString() + "," + productType + "," + bootsSize + "," + bootsIsNaturalSkin;
    }
}
