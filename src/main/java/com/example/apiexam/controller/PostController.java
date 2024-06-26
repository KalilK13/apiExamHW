package com.example.apiexam.controller;

import com.example.apiexam.ResourceNotFoundException;
import com.example.apiexam.Service.PostService;
import com.example.apiexam.domain.Post;
import com.example.apiexam.domain.User;
import com.example.apiexam.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostController {
    @Autowired
    private PostService postService;
    @Autowired
    private PostRepository postRepository;
    @PostMapping(value = "/users/{userId}/posts")
    public ResponseEntity<?> createPost(@RequestBody Post post){
        postService.createPost(post);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping(value = "/posts/{postId}")
    public ResponseEntity<?> getPostById(@PathVariable Long postId){
        verifyPost(postId);
        postService.getPost(postId);
        return  new ResponseEntity<>(postService.getPost(postId), HttpStatus.OK);
    }
    @GetMapping(value = "/posts")
    public ResponseEntity<?> getAllPosts(){
        postService.getAllPosts();
        return new ResponseEntity<>(postService.getAllPosts(), HttpStatus.OK);
    }
    @DeleteMapping(value = "/posts/{postId}")
    public ResponseEntity<?> deleteAPost(@PathVariable Long postId){
        verifyPost(postId);
        postService.deletePost(postId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping(value = "/posts/{postId}")
    public ResponseEntity<?> updatePost(@RequestBody Post post, @PathVariable Long postId){
        verifyPost(postId);
        postRepository.save(post);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping(value = "/users/{userId}/posts")
    public ResponseEntity<?> getPostByUserId(){
        postService.getAllPosts();
        return new ResponseEntity<>(postService.getAllPosts(),HttpStatus.OK);
    }
    protected void verifyPost(Long postId) throws ResourceNotFoundException {
        Post post = postService.getPost(postId);
        if(post == null) {
            throw new ResourceNotFoundException("Post with id " + postId + " not found");
        }
    }
}
