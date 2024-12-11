package ma.emsi.serviceClient_com.services;

import ma.emsi.serviceClient_com.entities.Address;


import java.util.List;

public interface AddressServiceI {
    List<Address> showClientAddress(Long clientId);
    Address addAddressToClient(Address address,Long clientId);
    Address updateAddress(Address updatedAddress);
    void deleteAddress(Long clientId);
}