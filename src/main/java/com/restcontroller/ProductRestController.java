package com.restcontroller;

import com.model.kream.order.before.Purchase;
import com.model.kream.order.before.Sell;
import com.model.kream.product.ProductMain;
import com.model.kream.product.ProductShop;
import com.model.kream.product.interactions.PRODUCT_TRANSACTION_TYPE;
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
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping(value = "/api/kream/product")
public class ProductRestController {
    private final ProductService productService;

    @RequestMapping(value = "/detail/{no}", method = RequestMethod.GET)
    public ResponseEntity getProductDetail(@PathVariable int no) {
        Message message = new Message();
        message.put("product", productService.getProductDetail(no));
        productService.updateProductViews(no);
        return new ResponseEntity(DefaultRes.res(HttpStatus.OK, message, true), HttpStatus.OK);
    }

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public ResponseEntity getProductMain(HttpServletRequest request) {
        Message message = new Message();
        // TODO Type 별 products => Main Controller 로 빠질 예정
        List<ProductMain> products = productService.getMainProducts(0);
        message.put("products", products);
        message.put("last_idx", products.size() > 0 ? products.get(products.size() - 1).getNo() : 0);
        return new ResponseEntity(DefaultRes.res(HttpStatus.OK, message, true), HttpStatus.OK);
    }

    @RequestMapping(value = "/shop", method = RequestMethod.GET)
    public ResponseEntity getProductShop(HttpServletRequest request,
                                         @RequestParam(value = "brands", required = false) List<Integer> brands,
                                         @RequestParam(value = "gender", required = false) List<Integer> genders,
                                         @RequestParam(value = "categories", required = false) List<Integer> categories,
                                         @RequestParam(value = "keyword", required = false) String keyword,
                                         @RequestParam(value = "size_list", required = false) List<String> sizes,
                                         @RequestParam(value = "cursor", required = false) Integer cursor) {
        Message message = new Message();
        int user_no = 1;
        // TODO CHECK PARAM LIST ACCEPTABLE
        List<ProductShop> n_products = productService.searchProductWithFilters(brands, genders, categories, keyword, sizes, user_no, cursor);
        message.put("products", n_products);
        message.put("count", productService.getProductCountViaSearch(brands, genders, categories, keyword, sizes));
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

}
