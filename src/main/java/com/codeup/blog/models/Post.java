package com.codeup.blog.models;

import javax.persistence.*;




// JPA annotations:

@Entity
@Table(name="posts")
public class Post {
    @Column(nullable = false)
    private String title;
    @Column
    private String body;


    //  default constructor


    // C in CRUD
    public Post(){
    }


    // U in CRUD
    public Post(String title, String body, User writer) {
        this.title = title;
        this.body = body;
        this.writer = writer;
    }


    // R in CRUD
    public Post(String title, String body, String image, User writer) {
        this.title = title;
        this.body = body;
        this.image = image;
        this.writer = writer;
    }


    // D in CRUD
    public Post(long id) {
        this.id = id;
    }



    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;


    @Id
    @GeneratedValue
    private long id;


    public long getId() {
        return id;
    }

    public void setId(long ad) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public User getAuthor() {
        return writer;
    }

    public void setAuthor(User author) {
        this.writer = author;
    }


}  // Post class