package com.mapper;

import com.model.kream.user.address.Address;

import java.util.List;

public interface AddressMapper {
    public List<Address> getMyAddresses(int no);

    public void registAddress(Address address);

    public void updateAddress(Address address);

    public void deleteAddress(int no);

    public Address getDefaultAddress(int no, int is_default_address);

    void resetDefaultAddress(Address address);
}
