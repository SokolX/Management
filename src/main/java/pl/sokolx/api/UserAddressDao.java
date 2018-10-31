package pl.sokolx.api;

import pl.sokolx.models.UserAddress;

import java.util.List;

public interface UserAddressDao {

    List<UserAddress> getAllAddress();

    void addAddress(UserAddress userAddress);

}
