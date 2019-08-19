package com.gym.model;

public class Product {
    private int id;
    private String name, category, price, productDate;

    public Product() {
    }

    public Product(int id, String name, String category, String price, String productDate) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.productDate = productDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getProductDate() {
        return productDate;
    }

    public void setProductDate(String productDate) {
        this.productDate = productDate;
    }
}
