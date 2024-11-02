package com.example.demo.post;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.models.post.Post;
import com.example.demo.models.post.PostRepository;
import com.example.demo.models.user.UserRepository;


@Service
public class PostService {
  private final PostRepository postRepository;
  private final UserRepository userRepository;

  @Autowired
  public PostService(PostRepository postRepository , UserRepository userRepository){
    this.postRepository = postRepository;
    this.userRepository = userRepository;
  }

  // create post 
  public Post createPost(Post post){
    // check if user exist
    boolean userExist = userRepository.existsById(post.getUser().getId());
    // faild
    if(!userExist) throw new ResponseStatusException(HttpStatus.NOT_FOUND ,"user not found");
    // return response
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
