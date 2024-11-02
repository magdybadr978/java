package com.example.demo.post;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.post.Post;



@RestController
@RequestMapping("post")
public class PostCotroller {
  private final PostService postService;

  @Autowired
  public PostCotroller(PostService postService){
    this.postService = postService;
  
  }

  @PostMapping
  public Post createPost(@RequestBody Post post){
    return postService.createPost(post);
  }

  @GetMapping("{id}")
  public Optional<Post> getPostById(@PathVariable Long id){
    return postService.getPostById(id);
  }

  @GetMapping
  public List<Post> getAllPosts(){
    return postService.getAllPosts();
  }

  @PutMapping
  public Post updatePost(@PathVariable Long id , @RequestBody Post post){
    return postService.updatePost(post);
  }

  @DeleteMapping("{id}")
  public void deletePost(@PathVariable Long id){
    postService.deletePost(id);
  }
}
