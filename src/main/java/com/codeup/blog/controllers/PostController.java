package com.codeup.blog.controllers;

import com.codeup.blog.models.Post;
import com.codeup.blog.repositories.PostRepository;
import com.codeup.blog.repositories.UserRepository;
import com.codeup.blog.services.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
public class PostController {

    private final PostRepository postRepo;
    private final UserRepository userRepo;
    private EmailService emailService;

    public PostController(PostRepository posts, UserRepository users, EmailService emailService) {
        this.postRepo = posts;
        this.userRepo = users;
        this.emailService = emailService;
    }

    @GetMapping("/posts")
    public String showPost(Model model){
//        init();

        model.addAttribute("posts", postRepo.findAll());
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String showPost(@PathVariable long id, Model model) {
        Post post = postRepo.findOne(id);
        model.addAttribute("post", post);
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String showCreateForm(Model vModel){
        vModel.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute Post postToSaved){
        postToSaved.setAuthor(userRepo.findOne(1L));
        Post savedPost = postRepo.save(postToSaved);
        emailService.prepareAndSend(savedPost, "Post has been created", "The post has been created successfully and you can find it with the ID of " +savedPost.getId());
        return "redirect:/posts/" + savedPost.getId();
    }

    @GetMapping("/posts/{id}/edit")
    public String editForm(@PathVariable long id, Model model) {
        Post post = postRepo.findOne(id);
        model.addAttribute("post", post);
        return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String editPost(@ModelAttribute Post postTobeEdited) {
        postTobeEdited.setAuthor(userRepo.findOne(1L));
        postRepo.save(postTobeEdited);
        return "redirect:/posts/" + postTobeEdited.getId();
    }

    private void init() {
//        List<Post> posts = new ArrayList<>();
        Post post = new Post();
        post.setTitle("Here is our first new post");
        post.setBody("This is not going to be a very long blog post");
        post.setId(4L);
        postRepo.save(post);
        Post post2 = new Post();
        post2.setTitle("Here is our second new post");
        post2.setBody("This is not going to be a very long blog post");
        post2.setId(44L);
        postRepo.save(post2);
    }

}  // PostController class