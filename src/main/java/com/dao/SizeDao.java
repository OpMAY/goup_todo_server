package com.dao;

import com.mapper.SizeMapper;
import com.model.kream.product.size.Size;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SizeDao {

   private SizeMapper mapper;
   private SizeDao(SqlSession sqlSession){
       this.mapper = sqlSession.getMapper(SizeMapper.class);
   }

    public List<Size> getProductSize(int product_no) {
       return mapper.getProductSize(product_no);
    }

    public boolean isProductOneSize(int product_no) {
       return mapper.isProductOneSize(product_no);
    }

    public void insertProductSize(Size size) {
       mapper.insertProductSize(size);
    }

    public void deleteSizeByNo(int no) {
       mapper.deleteSizeByNo(no);
    }

    public void deleteSizeByProductNoAndSize(int product_no, String size) {
       mapper.deleteSizeByProductNoAndSize(product_no, size);
    }

    public void updateSize(int no, String size) {
       mapper.updateSize(no, size);
    }

    public Size getSizeInfo(int size_no) {
       return mapper.getSizeInfo(size_no);
    }
}
