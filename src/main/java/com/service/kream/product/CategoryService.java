package com.service.kream.product;

import com.dao.CategoryDao;
import com.model.kream.product.category.Category;
import com.model.kream.product.category.CategoryAdmin;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryDao categoryDao;

    public List<CategoryAdmin> getCategoryChildren(int no) {
        return categoryDao.getCategoryChildrenAdmin(no);
    }
}
