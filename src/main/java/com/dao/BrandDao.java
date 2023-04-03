package com.dao;

import com.mapper.BrandMapper;
import com.model.kream.product.brand.Brand;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BrandDao {
    private BrandMapper mapper;

    private BrandDao(SqlSession sqlSession){
        this.mapper = sqlSession.getMapper(BrandMapper.class);
    }

    public Brand getBrandByNo(int brand_no) {
        return mapper.getBrandByNo(brand_no);
    }

    public Brand getBrandByProductNo(int no) {
        return mapper.getBrandByProductNo(no);
    }

    public List<Brand> getAllBrands() {
        return mapper.getAllBrands();
    }
}
