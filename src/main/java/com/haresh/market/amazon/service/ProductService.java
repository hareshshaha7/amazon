package com.haresh.market.amazon.service;

import com.haresh.market.amazon.dao.ProductDao;
import com.haresh.market.amazon.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductDao productDao;

    public List<Product> getProducts() {
        return productDao.getProducts();
    }
}
