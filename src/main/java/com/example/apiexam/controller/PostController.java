package com.example.apiexam.controller;

import com.example.apiexam.Service.PostService;
import com.example.apiexam.domain.Post;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostController {
    private PostService postService;
    @PostMapping(value = "/users/{userId}/posts")
    public ResponseEntity<?> createPost(@RequestBody Post post){
        postService.createPost(post);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping(value = "/posts/{postId}")
    public ResponseEntity<?> getPostById(){

        return  new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping(value = "/posts")
    public ResponseEntity<?> getAllPosts(){
        postService.getAllPosts();
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping(value = "/posts/{postId}")
    public ResponseEntity<?> deleteAPost(@PathVariable Long postId){
        postService.deletePost(postId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping(value = "/posts/{postId}")
    public ResponseEntity<?> updatePost(@RequestBody Post post){
        postService.createPost(post);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping(value = "/users/{userId}/posts")
    public ResponseEntity<?> getPostByUserId(){
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
