package com.mapper;

import com.model.kream.user.address.Address;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AddressMapper {
    public List<Address> getMyAddresses(int user_no);

    public Address getAddress(int no);
    public void registAddress(Address address);

    public void updateAddress(Address address);

    public void deleteAddress(int no);

    public Address getDefaultAddress(@Param("no") int no, @Param("is_default_address") int is_default_address);

    void resetDefaultAddress(Address address);



}
