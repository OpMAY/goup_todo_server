package com.service.kream.user;


import com.dao.AddressDao;
import com.model.kream.user.address.Address;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class AddressService {
    private final AddressDao addressDao;

    public Address getAddressInfo(int no){
        return addressDao.getMyAddresses(no);
    }

    public void registAddress(Address address){
        addressDao.registAddress(address);
    }

    public void updateAddress(Address address){
        addressDao.updateAddress(address);
    }

    public void  deleteAddress(int no){
        addressDao.deleteAddress(no);
    }




}

