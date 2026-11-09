package com.haresh.market.amazon.dao;

import com.haresh.market.amazon.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductDao {
    private final List<Product> products;

    public ProductDao () {
        this.products = new ArrayList<>();
        products.add(new Product(1, "Haresh", 9000));
        products.add(new Product(2, "Shaha", 13000));
        products.add(new Product(3, "New1", 19000));
    }

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Product> getProducts() {
        String query = "select * from product";
        RowMapper<Product> rowMapper = (rs, rowNum) -> {
            Product product = new Product();
            product.setId(rs.getInt(1));
            product.setName(rs.getString(2));
            product.setPrice(rs.getInt(3));
            return product;
        };

//        return this.products;
        return jdbcTemplate.query(query, rowMapper);
    }
}
