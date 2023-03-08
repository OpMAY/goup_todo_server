package com.service.kream.user;


import com.dao.AddressDao;
import com.dao.UserDao;
import com.model.User;
import com.model.kream.user.address.Address;
import com.response.Message;
import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class AddressService {
    private final AddressDao addressDao;

    private final UserDao userDao;

    public Address getAddress(int no){
        return addressDao.getAddress(no);
    }
    public List<Address> getAddressInfo(int user_no) {
        return addressDao.getMyAddresses(user_no);
    }



    @Transactional
    /*   1. 해당 유저의 기본배송지가 true인 address 가져오기
         2. 위의 address 가 null 이 아닐경우 is_default_address -> false 로 변경
         3. 새로 등록하는 address insert

    * */
    public void registAddress(Address address) {
        if (address.getIs_default_address() == 1) {
            addressDao.resetDefaultAddress(address);
        }
        addressDao.registAddress(address);

    }


    @Transactional
    public void updateAddress(Address address) {
        if(address.getIs_default_address()==1){
            addressDao.resetDefaultAddress(address);
        }
        addressDao.updateAddress(address);

    }


    @Transactional
    public Message deleteAddress(int no ) {
        Message message = new Message();
        Address address = this.getAddress(no);

        if(address.getIs_default_address() == 0){
            addressDao.deleteAddress(no);
            message.put("status", true);
        } else {
            message.put("status",false);
        }

        return message;

    }


}

