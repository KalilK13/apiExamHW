package com.example.apiexam.Service;

import com.example.apiexam.domain.Comment;
import com.example.apiexam.domain.User;
import com.example.apiexam.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;
    public void createComment(Comment comment){
        commentRepository.save(comment);
    }
    public void deleteComment(Long commentId){
        commentRepository.deleteById(commentId);
    }
    public Iterable<Comment> getAllComments(){
        return commentRepository.findAll();
    }
}
