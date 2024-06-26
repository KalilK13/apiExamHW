package com.example.apiexam.controller;

import com.example.apiexam.Service.CommentService;
import com.example.apiexam.domain.Comment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CommentController {
    private CommentService commentService;
    @PostMapping(value = "/posts/{postId}/comments")
    public ResponseEntity<?> createComment(@RequestBody Comment comment){
        commentService.createComment(comment);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping(value ="/comments/commentId" )
    public ResponseEntity<?> getCommentById(){
        return  new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping(value ="/comments" )
    public ResponseEntity<?> getAllComments(){
        commentService.getAllComments();
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping(value = "/comments/{commentId}")
    public ResponseEntity<?> deleteAComment(@PathVariable Long commentId){
        commentService.deleteComment(commentId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping(value = "/posts/{postId}/comments")
    public ResponseEntity<?> getAllCommentsByPost(){
        commentService.getAllComments();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
