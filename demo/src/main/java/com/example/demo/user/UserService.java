package com.example.demo.user;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.user.User;
import com.example.demo.models.user.UserRepository;

@Service
public class UserService {
  private final UserRepository userRepository;

  @Autowired
  public UserService(UserRepository userRepository){
    this.userRepository = userRepository;
  }

  public User createUser(User user){
    return userRepository.create(user);
  }

  public Optional<User> getUserById(Long id){
    return userRepository.findById(id);
  }

  
}
