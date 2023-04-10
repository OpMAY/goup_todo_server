package com.service.kream.shop;

import com.dao.WishDao;
import com.model.kream.product.interactions.Wish;
import com.model.kream.product.interactions.WishList;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class WishService {

    private final WishDao wishDao;

    public List<WishList> getMywishList(int user_no) {
        return wishDao.getMywishList(user_no);
    }
}
