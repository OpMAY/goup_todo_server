package com.dao;

import com.mapper.AddressMapper;
import com.model.kream.user.address.Address;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AddressDao {
    private AddressMapper mapper;

    private AddressDao(SqlSession sqlSession){
        this.mapper = sqlSession.getMapper(AddressMapper.class);
    }

    public List<Address> getMyAddresses(int no){
        return mapper.getMyAddresses(no);
    }

    public Address getDefaultAddress(int no, int is_default_address){
        return mapper.getDefaultAddress(no,is_default_address);
    }

    public void registAddress(Address address){
        mapper.registAddress(address);
    }

    public void updateAddress(Address address){
        mapper.updateAddress(address);
    }

    public void deleteAddress(int no){
        mapper.deleteAddress(no);

    }

    public void resetDefaultAddress(Address address) {
        mapper.resetDefaultAddress(address);
    }
}
