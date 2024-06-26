package com.example.apiexam.Service;

import com.example.apiexam.domain.Post;
import com.example.apiexam.domain.User;
import com.example.apiexam.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;
    public void createPost(Post post){
        postRepository.save(post);
    }
    public void deletePost(Long postId){
        postRepository.deleteById(postId);
    }
    public Iterable<Post> getAllPosts(){
        return postRepository.findAll();
    }
    public Post getPost(Long postId){
        while(getAllPosts().iterator().hasNext()){
            Post post = getAllPosts().iterator().next();
            if (post.getId() == postId){
                return post;
            }
        }
        return null;
    }
}

