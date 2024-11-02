package com.example.demo.post;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.post.Post;
import com.example.demo.models.post.PostRepository;


@Service
public class PostService {
  private final PostRepository postRepository;

  @Autowired
  public PostService(PostRepository postRepository){
    this.postRepository = postRepository;
  }

  // create post 
  public Post createPost(Post post){
    return postRepository.create(post);
  }

  // get specific post
  public Optional<Post> getPostById(Long id){
    return postRepository.findById(id);
  }

  // get all posts
  public List<Post> getAllPosts(){
    return postRepository.findAll();
  }

  // update post
  public Post updatePost(Post post){
    return postRepository.update(post);
  }

  // delete post
  public void deletePost(Long id){
    postRepository.deleteById(id);
  }

}
