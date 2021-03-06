package com.codegym.service;

import com.codegym.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService implements IProductService{
    private static final Map<Integer,Product> products;
    static {

        products = new HashMap<>();
        products.put(1, new Product(1, "IpX", 10,"90%"));
        products.put(2, new Product(2, "Ip11", 11, "90%"));
        products.put(3, new Product(3, "Ip12", 13, "90%"));
        products.put(4, new Product(4, "Ip12Pro",15 , "100%"));
        products.put(5, new Product(5, "Ip13", 21, "100%"));
        products.put(6, new Product(6, "Ip13Promax", 33, "100%"));
    }
    @Override
    public List<Product> findAll() {
       return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
products.put(product.getId(),product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
products.put(id,product);
    }

    @Override
    public void remove(int id) {
products.remove(id);
    }
}
