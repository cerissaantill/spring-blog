package com.codeup.blog.models;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "users")      // table for all users:
public class User {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "writer")
    private List<Post> posts;



// default Constructor:

    // C on the CRUD
    public User() {
    }

    // R, U on the CRUD
    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public User(User copy) {
        id = copy.id;   // This is SUPER important! Many things won't work if it's absent.
        email = copy.email;
        username = copy.username;
        password = copy.password;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}