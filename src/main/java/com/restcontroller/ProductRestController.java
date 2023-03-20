package com.restcontroller;

import com.model.kream.order.before.Purchase;
import com.model.kream.order.before.Sell;
import com.model.kream.product.ProductMain;
import com.model.kream.product.ProductShop;
import com.model.kream.product.interactions.PRODUCT_TRANSACTION_TYPE;
import com.model.kream.product.interactions.Wish;
import com.model.kream.product.price.ProductPriceWithSize;
import com.response.DefaultRes;
import com.response.Message;
import com.service.kream.product.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping(value = "/api/kream/product")
public class ProductRestController {
    private final ProductService productService;

    @RequestMapping(value = "/{no}", method = RequestMethod.GET)
    public ResponseEntity getProductDetail(@PathVariable int no) {
        Message message = new Message();
        message.put("product", productService.getProductDetail(no));
        productService.updateProductViews(no);
        return new ResponseEntity(DefaultRes.res(HttpStatus.OK, message, true), HttpStatus.OK);
    }

    @RequestMapping(value = "/shop", method = RequestMethod.GET)
    public ResponseEntity getProductShop(HttpServletRequest request,
                                         @RequestParam(value = "brands", required = false) List<Integer> brands,
                                         @RequestParam(value = "gender", required = false) List<Integer> genders,
                                         @RequestParam(value = "categories", required = false) List<Integer> categories,
                                         @RequestParam(value = "keyword", required = false) String keyword,
                                         @RequestParam(value = "size_list", required = false) List<String> sizes,
                                         @RequestParam(value = "cursor", required = false) Integer cursor,
                                         @RequestParam(value = "price", required = false) String price) {
        Message message = new Message();
        int user_no = 1;
        // TODO CHECK PARAM LIST ACCEPTABLE
        if (price == null || priceFilters.contains(price)) {
            List<ProductShop> n_products = productService.searchProductWithFilters(brands, genders, categories, keyword, sizes, user_no, cursor, price);
            message.put("products", n_products);
            message.put("count", productService.getProductCountViaSearch(brands, genders, categories, keyword, sizes));

            // QUERY RETURN
            Map<String, Object> queryMap = new HashMap<>();
            queryMap.put("brand", brands);
            queryMap.put("gender", genders);
            queryMap.put("category", categories);
            queryMap.put("keyword", keyword);
            queryMap.put("size", sizes);
            queryMap.put("cursor", cursor);
            queryMap.put("price", price);
            message.put("queries", queryMap);
            message.put("status", true);
        } else {
            message.put("status", false);
            message.put("error_msg", "가격 필터 설정 오류");
        }

        return new ResponseEntity(DefaultRes.res(HttpStatus.OK, message, true), HttpStatus.OK);
    }

    @RequestMapping(value = "/order/sell", method = RequestMethod.POST)
    public ResponseEntity RegisterProductSell(@RequestBody Sell sell) {
        Message message = productService.registerProductSell(sell);
        return new ResponseEntity(DefaultRes.res(HttpStatus.OK, message, true), HttpStatus.OK);
    }

    @RequestMapping(value = "/order/purchase", method = RequestMethod.POST)
    public ResponseEntity RegisterProductPurchase(@RequestBody Purchase purchase) {
        Message message = productService.registerProductPurchase(purchase);
        return new ResponseEntity(DefaultRes.res(HttpStatus.OK, message, true), HttpStatus.OK);
    }

    @RequestMapping(value = "/size/{no}", method = RequestMethod.GET)
    public ResponseEntity GetProductSizes(@PathVariable Integer no,
                                          @RequestParam(value = "is_price", required = false) String is_price,
                                          @RequestParam(value = "type", required = false) String type) {
        Message message = new Message();
        boolean price_bool = is_price != null && is_price.equalsIgnoreCase("Y");
        PRODUCT_TRANSACTION_TYPE sort_type = null;
        if (type != null) {
            for (PRODUCT_TRANSACTION_TYPE enumType : PRODUCT_TRANSACTION_TYPE.values()) {
                if (type.equals(enumType.name())) {
                    sort_type = enumType;
                    break;
                }
            }
        }
        if (price_bool && sort_type == null) {
            return new ResponseEntity(DefaultRes.res(HttpStatus.BAD_REQUEST), HttpStatus.OK);
        } else {
            List<ProductPriceWithSize> sizes = productService.getProductSizes(no, price_bool, sort_type);
            message.put("sizes", sizes);
        }
        return new ResponseEntity(DefaultRes.res(HttpStatus.OK, message, true), HttpStatus.OK);
    }

    @RequestMapping(value = "/wish", method = RequestMethod.POST)
    public ResponseEntity AddWish(@RequestBody Wish wish) {
        Message message = new Message();
        message.put("status", productService.addWish(wish));
        return new ResponseEntity(DefaultRes.res(HttpStatus.OK, message, true), HttpStatus.OK);
    }

    @RequestMapping(value = "/wish/{no}", method = RequestMethod.DELETE)
    public ResponseEntity deleteWishByNo(@PathVariable int no) {
        Message message = new Message();
        productService.deleteUserWish(no);
        message.put("status", true);
        return new ResponseEntity(DefaultRes.res(HttpStatus.OK, message, true), HttpStatus.OK);
    }

    @RequestMapping(value = "/wish/sep", method = RequestMethod.DELETE)
    public ResponseEntity deleteUserWishByUserNoAndSizeNo(@RequestBody Wish wish) {
        Message message = new Message();
        productService.deleteUserWishByUserNoAndSizeNo(wish.getUser_no(), wish.getSize_no());
        message.put("status", true);
        return new ResponseEntity(DefaultRes.res(HttpStatus.OK, message, true), HttpStatus.OK);
    }

    /**
     * TODO NOT Done
     * 1. 스타일 관련
     * 2.
     **/

    private final List<String> priceFilters = new ArrayList<>(Arrays.asList("-100000", "100000-300000", "300000-500000", "500000-1000000", "1000000-3000000", "3000000-"));
}
