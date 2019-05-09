package com.codeup.blog.controllers;

import com.codeup.blog.models.Ad;
import com.codeup.blog.models.User;
import com.codeup.blog.repositories.AdRepository;
import com.codeup.blog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class AdController {
    private final AdRepository adsRepo;
    private final UserRepository userRepo;

    public AdController(AdRepository ads, UserRepository users) {
        this.adsRepo = ads;
        this.userRepo = users;
    }

    @GetMapping("/ads")
    public String showPosts(Model model) {
//        init();

        model.addAttribute("ads", adsRepo.findAll());
        return "ads/index";
    }

    @GetMapping("/ads/{id}")
    public String showAd(@PathVariable long id, Model model) {
        Ad ad = adsRepo.findOne(id);
        model.addAttribute("ad", ad);
        return "ads/show";
    }

    @GetMapping("/ads/create")
    public String showCreateForm(Model model) {
        model.addAttribute("ad", new Ad());
        return "ads/create";
    }

    @PostMapping("/ads/create")
    @ResponseBody
    public String createPost(@ModelAttribute Ad ad) {
        User sessionUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User userDB = userRepo.findOne(sessionUser.getId());
        ad.setOwner(userDB);
        adsRepo.save(ad);
        return "new ad created";
    }
//
//    @GetMapping("/posts/{id}/edit")
//    public String editForm(@PathVariable long id, Model model) {
//        Post post = postRepo.findOne(id);
//        model.addAttribute("post", post);
//        return "posts/edit";
//    }
//
//    @PostMapping("/posts/{id}/edit")
//    @ResponseBody
//    public String editPost(@RequestParam String title, @RequestParam String body, @RequestParam String id) {
//        Post post = postRepo.findOne(Long.valueOf(id));
//        post.setTitle(title);
//        post.setBody(body);
//        postRepo.save(post);
//        return "successfully modified post";
//    }


//
//    private void init() {
////        List<Post> posts = new ArrayList<>();
//        Post post = new Post();
//        post.setTitle("Here is our first new post");
//        post.setBody("This is not going to be a very long blog post");
//        post.setId(4L);
//        postRepo.save(post);
//        Post post2 = new Post();
//        post2.setTitle("Here is our second new post");
//        post2.setBody("This is not going to be a very long blog post");
//        post2.setId(44L);
//        postRepo.save(post2);
//
//    }


}  // AdController class

