package com.na.model;

import javax.persistence.*;
import java.util.Set;
@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nameCategory;

    public Category() {
    }

    @OneToMany(mappedBy = "category")
    private Set <com.na.model.Post> posts;


    public Category(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }



    public Set<com.na.model.Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<com.na.model.Post> posts) {
        this.posts = posts;
    }
}
