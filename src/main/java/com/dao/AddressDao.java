package com.dao;

import com.mapper.AddressMapper;
import com.model.kream.user.address.Address;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class AddressDao {
    private AddressMapper mapper;

    private AddressDao(SqlSession sqlSession){
        this.mapper = sqlSession.getMapper(AddressMapper.class);
    }

    public Address getMyAddresses(int no){
        return mapper.getMyAddresses(no);
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
}
