package pl.sokolx.models;

public class UserAddress {

    private Integer addressId;
    private String cityName, zipCode, streetName, houseNumber;

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

    public Integer getAddressId() {
        return addressId;
    }

    public String getCityName() {
        return cityName;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getHouseNumber() {
        return houseNumber;
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
