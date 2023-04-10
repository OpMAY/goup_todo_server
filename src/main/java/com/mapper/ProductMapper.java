package com.mapper;

import com.model.kream.DATE_RANGE_TYPE;
import com.model.kream.product.Product;
import com.model.kream.product.ProductMain;
import com.model.kream.product.ProductShop;
import com.model.kream.product.price.ProductPriceHistory;
import com.model.kream.product.price.ProductPriceWithSize;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductMapper {
    Product getProductByNo(int no);

    List<Product> getProductByCategories(List<Integer> categories);

    List<ProductPriceWithSize> getProductPurchasePrices(int product_no);

    List<ProductPriceWithSize> getProductSellPrices(int product_no);

    ProductPriceWithSize getProductLowestSellPrice(int product_no);

    ProductPriceWithSize getProductHighestPurchasePrice(int product_no);

    List<ProductPriceWithSize> getProductOrderHistory(int product_no);

    List<ProductPriceHistory> getProductPriceHistory(@Param("product_no") int product_no, @Param("type") DATE_RANGE_TYPE type);

    void updateProductViews(int no);

    List<ProductMain> getMainProducts();

    Product getProductBySizeNo(int size_no);

    List<ProductShop> searchProductWithFilters(@Param("filtered") boolean filtered,
                                               @Param("brand_list") List<Integer> brand_list,
                                               @Param("gender_list") List<Integer> gender_list,
                                               @Param("category_list") List<Integer> category_list,
                                               @Param("keyword") String keyword,
                                               @Param("size_list") List<String> size_list);

    List<ProductShop> searchProductWithFiltersReload(@Param("filtered") boolean filtered,
                                                     @Param("brand_list") List<Integer> brand_list,
                                                     @Param("gender_list") List<Integer> gender_list,
                                                     @Param("category_list") List<Integer> category_list,
                                                     @Param("keyword") String keyword,
                                                     @Param("size_list") List<String> size_list,
                                                     @Param("cursor") Integer cursor);

    List<ProductShop> getProductCountViaSearch(@Param("filtered") boolean filtered,
                                 @Param("brand_list") List<Integer> brand_list,
                                 @Param("gender_list") List<Integer> gender_list,
                                 @Param("category_list") List<Integer> category_list,
                                 @Param("keyword") String keyword,
                                 @Param("size_list") List<String> size_list);

    List<ProductMain> getMainPopularProducts();

    List<ProductMain> getMainRecentProducts();

    void registerProduct(Product product);

    void updateProductFlag(int no);

    void updateProduct(Product product);

    void deleteProduct(int no);

    boolean checkProductHasTransaction(int no);

    boolean checkProductNameDuplicate(String en_name, String kor_name);

    List<Product> getAllProducts();

    List<Product> getBrandProducts(int brand_no);

    int getCategoryProductCount(int category_no);
}
