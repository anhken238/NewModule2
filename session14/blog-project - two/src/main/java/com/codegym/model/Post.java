package com.codegym.model;

import javax.persistence.*;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String post, introduce, content;

    public Post() {
    }

    public Post(String title, String post, String introduce, String content) {
        this.title = title;
        this.post = post;
        this.introduce = introduce;
        this.content = content;
    }

    @Override
    public String toString() {
        return String.format("Post [id=%d, title='%s', post='%s',introduce='%s'content='%s']", id, title, post, introduce, content);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
