package com.codeup.blog.blog;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;


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

}