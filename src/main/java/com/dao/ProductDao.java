package com.dao;

import com.mapper.ProductMapper;
import com.model.kream.DATE_RANGE_TYPE;
import com.model.kream.product.Product;
import com.model.kream.product.ProductMain;
import com.model.kream.product.ProductShop;
import com.model.kream.product.price.ProductPriceHistory;
import com.model.kream.product.price.ProductPriceWithSize;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDao {
    private ProductMapper mapper;

    private ProductDao(SqlSession sqlSession) {
        this.mapper = sqlSession.getMapper(ProductMapper.class);
    }

    public Product getProductByNo(int no) {
        return mapper.getProductByNo(no);
    }

    public List<Product> getProductByCategories(List<Integer> categories) {
        return mapper.getProductByCategories(categories);
    }

    @Deprecated
    public List<ProductPriceWithSize> getProductPurchasePrices(int product_no) {
        return mapper.getProductPurchasePrices(product_no);
    }

    @Deprecated
    public List<ProductPriceWithSize> getProductSellPrices(int product_no) {
        return mapper.getProductSellPrices(product_no);
    }

    public ProductPriceWithSize getProductLowestSellPrice(int product_no) {
        return mapper.getProductLowestSellPrice(product_no);
    }

    public ProductPriceWithSize getProductHighestPurchasePrice(int product_no) {
        return mapper.getProductHighestPurchasePrice(product_no);
    }

    public List<ProductPriceWithSize> getProductOrderHistory(int product_no) {
        return mapper.getProductOrderHistory(product_no);
    }

    public List<ProductPriceHistory> getProductPriceHistory(int product_no, DATE_RANGE_TYPE type) {
        return mapper.getProductPriceHistory(product_no, type);
    }

    public void updateProductViews(int no) {
        mapper.updateProductViews(no);
    }

    public List<ProductMain> getMainProducts() {
        return mapper.getMainProducts();
    }

    public List<ProductShop> getShopProducts() {
        return mapper.getShopProducts();
    }

    public Product getProductBySizeNo(int size_no) {
        return mapper.getProductBySizeNo(size_no);
    }

    public List<ProductShop> searchProductWithFilters(boolean filtered, List<Integer> brand_list, List<Integer> gender_list, List<Integer> category_list, String keyword, List<String> size_list) {
        return mapper.searchProductWithFilters(filtered, brand_list, gender_list, category_list, keyword, size_list);
    }
}
