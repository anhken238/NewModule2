package com.codegym.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty
    @Size(min = 10,message = "Min is 10 character")
    private String title;

    private boolean status = true;

    @Size(min=20,message = "Min is 10 character")
    private String content;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    @CreationTimestamp
    private Date dateCreate;

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Date dateLastModified;


    private String contact;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    public Post() {
    }

    public Post(@NotEmpty @Size(min = 10, message = "Min is 10 character") String title, boolean status, @Size(min = 20, message = "Min is 10 character") String content, Date dateCreate, Date dateLastModified, String contact) {
        this.title = title;
        this.status = status;
        this.content = content;
        this.dateCreate = dateCreate;
        this.dateLastModified = dateLastModified;
        this.contact = contact;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public Date getDateLastModified() {
        return dateLastModified;
    }

    public void setDateLastModified(Date dateLastModified) {
        this.dateLastModified = dateLastModified;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
