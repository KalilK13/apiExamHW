package com.example.apiexam.controller;

import com.example.apiexam.ResourceNotFoundException;
import com.example.apiexam.Service.CommentService;
import com.example.apiexam.Service.PostService;
import com.example.apiexam.domain.Comment;
import com.example.apiexam.domain.Post;
import com.example.apiexam.domain.User;
import com.example.apiexam.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CommentController {
    @Autowired
    private CommentService commentService;
    @Autowired
    private CommentRepository commentRepository;
    @PostMapping(value = "/posts/{postId}/comments")
    public ResponseEntity<?> createComment(@RequestBody Comment comment){
        commentService.createComment(comment);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping(value ="/comments/{commentId}" )
    public ResponseEntity<?> getCommentById(@PathVariable Long commentId){
        verifyComment(commentId);
        commentService.getComment(commentId);
        return  new ResponseEntity<>(commentService.getComment(commentId),HttpStatus.OK);
    }
    @GetMapping(value ="/comments" )
    public ResponseEntity<?> getAllComments(){
        commentService.getAllComments();
        return new ResponseEntity<>(commentService.getAllComments(),HttpStatus.OK);
    }
    @DeleteMapping(value = "/comments/{commentId}")
    public ResponseEntity<?> deleteAComment(@PathVariable Long commentId){
        verifyComment(commentId);
        commentService.deleteComment(commentId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping(value = "/posts/{postId}/comments")
    public ResponseEntity<?> getAllCommentsByPost(){
        commentService.getAllComments();
        return new ResponseEntity<>(commentService.getAllComments(),HttpStatus.OK);
    }
    @PutMapping(value = "/comments/{commentId}")
    public ResponseEntity<?> updateComment(@RequestBody Comment comment, @PathVariable Long commentId){
        verifyComment(commentId);
        commentRepository.save(comment);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    protected void verifyComment(Long commentId) throws ResourceNotFoundException {
        Comment comment = commentService.getComment(commentId);
        if(comment == null) {
            throw new ResourceNotFoundException("Comment with id " + commentId + " not found");
        }
    }
}
