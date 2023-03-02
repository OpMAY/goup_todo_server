package com.mapper;

import com.model.kream.user.address.Address;

public interface AddressMapper {
    public Address getMyAddresses(int no);

    public void registAddress(Address address);

    public void updateAddress(Address address);

    public void deleteAddress(int no);
}
