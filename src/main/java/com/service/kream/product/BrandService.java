package com.service.kream.product;

import com.dao.BrandDao;
import com.dao.ProductDao;
import com.model.kream.product.brand.Brand;
import com.model.kream.product.brand.BrandMain;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class BrandService {
    private final BrandDao brandDao;
    private final ProductDao productDao;

    @Transactional
    public boolean updateBrand(Brand brand) {
        if (!brandDao.isNameDuplicated(brand.getNo(), brand.getName())) {
            brandDao.updateBrand(brand);
            return true;
        } else {
            return false;
        }
    }

    @Transactional
    public Brand makeBrand(Brand brand) {
        if(!brandDao.isNameDuplicated(0, brand.getName())) {
            brandDao.makeBrand(brand);
            return brand;
        } else {
            return null;
        }
    }

    @Transactional
    public boolean deleteBrand(int no) {
        if(productDao.getBrandProducts(no).size() > 0) {
            return false;
        } else {
            brandDao.deleteBrand(no);
            return true;
        }
    }

    public List<BrandMain> getMainBrands() {
        return brandDao.getMainBrands();
    }
}
