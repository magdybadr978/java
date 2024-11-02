package com.example.demo.models.post;

import java.util.Optional;

import com.example.demo.models.AbstractRepository;

public interface  PostRepository extends AbstractRepository<Post, Long>{
  Optional<Post> findByName(String name); 
}
