package pl.sokolx.models;

public class UserAddress {

    private Integer addressId;
    private final String cityName;
    private final String zipCode;
    private final String streetName;
    private final String houseNumber;

    public UserAddress(Integer addressId, String cityName, String zipCode, String streetName, String houseNumber) {
        this.addressId = addressId;
        this.cityName = cityName;
        this.zipCode = zipCode;
        this.streetName = streetName;
        this.houseNumber = houseNumber;
    }

    public UserAddress(String cityName, String zipCode, String streetName, String houseNumber) {
        this.cityName = cityName;
        this.zipCode = zipCode;
        this.streetName = streetName;
        this.houseNumber = houseNumber;
    }

    @Override
    public String toString() {
        return "UserAddress{" +
                "addressId=" + addressId +
                ", cityName='" + cityName + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", streetName='" + streetName + '\'' +
                ", houseNumber='" + houseNumber + '\'' +
                '}';
    }
}
