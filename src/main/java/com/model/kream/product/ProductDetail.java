package com.model.kream.product;

import com.model.kream.DATE_RANGE_TYPE;
import com.model.kream.product.brand.Brand;
import com.model.kream.product.price.ProductPriceHistories;
import com.model.kream.product.price.ProductPriceHistory;
import com.model.kream.product.price.ProductPriceWithSize;
import com.model.kream.product.price.ProductPriceWithSizeAndCount;
import com.model.kream.product.size.Size;
import com.model.kream.style.Style;
import lombok.Data;

import java.util.List;

@Data
public class ProductDetail {
    // TODO ADD SIZE 별 판매 재고 (FOR 구매)
    private Product product; // 상품 기본 정보
    private Integer direct_sell_price; // 즉시 판매가
    private Integer direct_purchase_price; // 즉시 구매가
    private Integer recent_order_price; // 최근 거래가
    private Integer recent_2nd_order_price; // 최근 거래가 직전의 거래가
    private Brand brand; // 브랜드 정보
    private int wishes; // 관심 상품 Count
    private ProductPriceHistories price_history; // 시세 정보
    private List<ProductPriceWithSize> order_history; // 체결 거래 기록
    private List<ProductPriceWithSizeAndCount> sell_history; // 판매 입찰 기록
    private List<ProductPriceWithSizeAndCount> purchase_history; // 구매 입찰 기록

    // STYLES
    private List<Style> styles; // 스타일
    private int style_count; // 스타일 갯수
}
