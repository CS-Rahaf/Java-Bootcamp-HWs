package com.example.homework27.Controller;


import com.example.homework27.Model.Blog;
import com.example.homework27.Model.MyUser;
import com.example.homework27.Service.BlogService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/blogs")
@AllArgsConstructor
public class BlogController {

    private final BlogService blogService;



    @GetMapping()
    public ResponseEntity getBlogs(@AuthenticationPrincipal MyUser myUser){
        List<Blog> blogs = blogService.getBlogs(myUser);
        return ResponseEntity.status(200).body(blogs);
    }

    @GetMapping("{BlogId}")
    public ResponseEntity getBlog(@AuthenticationPrincipal MyUser myUser , @PathVariable Integer BlogId){
         Blog blog = blogService.getBlog(myUser, BlogId);
        return ResponseEntity.status(200).body(blog);
    }

    @PostMapping("")
    public ResponseEntity  addBlogs(@AuthenticationPrincipal MyUser myUser,@Valid @RequestBody Blog Blog){
        blogService.addBlog(myUser,Blog);
        return ResponseEntity.status(201).body("New Blog added !");
    }


    @PutMapping("/{BlogId}")
    public ResponseEntity updateBlogs(@AuthenticationPrincipal MyUser myUser, @PathVariable Integer BlogId, @Valid @RequestBody Blog Blog){
        blogService.UpdateBlog(myUser, BlogId, Blog);
        return ResponseEntity.status(200).body("Blog updated !");
    }

    @DeleteMapping("/{BlogId}")
    public ResponseEntity addBlogs(@AuthenticationPrincipal MyUser myUser, @PathVariable Integer BlogId){
        blogService.removeBlog(myUser,BlogId);
        return ResponseEntity.status(200).body("Blog deleted !");
    }


    @GetMapping("/title/{title}")
    public ResponseEntity findBlogByTitle(@AuthenticationPrincipal MyUser myUser, @PathVariable String title){

        return ResponseEntity.status(HttpStatus.OK).body(blogService.findBlogByTitle(myUser,title));
    }



}
