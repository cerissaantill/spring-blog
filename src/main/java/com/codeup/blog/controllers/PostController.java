package com.codeup.blog.controllers;

import com.codeup.blog.models.Post;
import com.codeup.blog.repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.lang.String;




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
    public String createPost(@RequestParam String title, @RequestParam String body){
        Post newPost = new Post();
        newPost.setTitle(title);
        newPost.setBody(body);
        postRepo.save(newPost);
        return "new post created";
    }



    @PostMapping("/post/{id}/edit")
    public String editForm(@PathVariable long id, Model model) {
        Post post = postRepo.findOne(id);
        model.addAttribute("post", post);
        return "posts/edit";
    }



    @GetMapping("/post/{id}/edit")
    @ResponseBody
    public String editPost(@RequestParam String title, @RequestParam String body, @RequestParam String id) {
        Post post = postRepo.findOne(Long.valueOf(id));
        post.setTitle(title);
        post.setBody(body);
        postRepo.save(post);
        return "successfully modified post";
    }


    private void init() {
        Post post = new Post();
        post.setTitle("Here is our first title post");
        post.setBody("This is not going to be a very long post");
        post.setId(4L);
        post.Repo.save(post);
        Post post2 = new Post();
        post2.setTitle("Here is our second title post");
        post2.setBody("This is where the blog posts will go");
        post2.setId(44L;
        postRepo.save(post2);)

        }


} // PostController class
    


