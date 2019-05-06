package com.codeup.blog.controllers;

import com.codeup.blog.blog.PostRepository;
import com.codeup.blog.blog.Post;
import org.springframework.web.bind.annotation.*;

import java.lang.String;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;


@Controller
public class PostController {
    private final PostRepository postRepo;

    public PostController(PostRepository posts) {
        this.postRepo = posts;
    }

    @GetMapping("/posts")
    @ResponseBody
    public String showPosts(Model model){

        model.addAttribute("posts", postRepo.findAll());
        return "posts index page";
    }



    @GetMapping("/posts/{id}")
    @ResponseBody
    public String showPost(@PathVariable long id, Model model){
        return "view an individual post id: " + id;
    }



    @GetMapping("/posts/create")
    @ResponseBody
    public String showCreateForm(){
        return "view the form for creating a post";
    }



    @PostMapping("/posts/create")
    @ResponseBody
    public String createPost(@RequestParam String title, @RequestParam String body){
        Post newPost = new Post();
        newPost.setTitle(title);
        newPost.setBody(body);
        postRepo.save(newPost);
        return "New post created";
    }



    @GetMapping("/post/{id}/edit")
    public String editPost@RequestParam String title, @RequestParam String body, @RequestParam String id) {
        Post post = postRepo.findOne(id);
        model.addAttribute("post", post);
        return "posts/edit";

    }


    private void init() {
        Post post = new Post();
        post.setTitle("Here is our first new post");
        post.setBody("This is not going to be a very long post");
        post.setId(4L);

        }


} // PostController class
    


