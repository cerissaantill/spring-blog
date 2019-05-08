package com.codeup.blog.models;

import javax.persistence.*;

import org.apache.catalina.User;
import java.util.Locale.Category;
import java.util.List;



/* GET FROM GITHUB   */



// JPA annotations:

@Entity
@Table(name="posts")
public class Post {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false, length = 150)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String body;


    @Column
    private String image;


    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName=)
    private User user;


    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "post")
    @JoinTable(
            name = "posts_categories",
            joinColumns = {@JoinColumn(name = "post_id")},
            inverseJoinColumns = {@JoinColumn(name = "category_id")}
    )


    private List<Category> categories;





    //  default constructor


    // C in CRUD
    public Post(){}

    // U in CRUD
    public Post(String title, String body, User writer) {
        this.title = title;
        this.body = body;
    }


    // R in CRUD
    public Post(String title, String body, String image, User writer) {
        this.title = title;
        this.body = body;
        this.image = image;
        this.writer = writer;
    }

    public Post(String title, String body, String image, User user, List<Category> categories) {
        this.title = title;
        this.body = body;
        this.image = image;
        this.writer = user;
        this.categories = categories;
    }

    public Post(String title, String body, long id) {
        this.title = title;
        this.body = body;
        this.id = id;
    }

    public Post(String title, String body, long id, User user) {
        this.title = title;
        this.body = body;
        this.id = id;
        this.user= user;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImage() { return image; }

    public void setImage(String image) {
        this.image = image;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<Category> getCategories() {
        return categories;
    }


}  // Post class