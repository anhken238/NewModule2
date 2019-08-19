package com.gym.service;

import com.gym.model.Product;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductImpl implements ProductService {
    private static Map<Integer,Product> productMap;
    static {
        productMap = new HashMap<>();
        productMap.put(1,new Product(1,"Chuoi","trai ","10000","20/3/2013"));
        productMap.put(2,new Product(2,"Tao","qua","10000","20/3/2013"));
        productMap.put(3,new Product(3,"Dau","trai","10000","20/3/2013"));
        productMap.put(4,new Product(4,"Ot cay","trai","10000","20/3/2013"));
        productMap.put(5,new Product(5,"Tieu","qua","10000","20/3/2013"));
        productMap.put(6,new Product(6,"CaPhe","qua","10000","20/3/2013"));
    }
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public Product findById(int id) {

        return productMap.get(id);
    }

    @Override
    public void update(int id, Product product) {
        productMap.put(product.getId(),product);
    }

    @Override
    public void save(Product product) {
        productMap.put(product.getId(),product);
    }

    @Override
    public void remove(int id) {
        productMap.remove(id);
    }
}
