package com.example.demo.user;

import java.util.List;
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

  public List<User> getAllUsers(){
    return  userRepository.getAll();
  }

  public User updateUser(User user){
    return userRepository.update(user);
  }

  public void deleteUser(Long id){
    userRepository.deleteById(id);
  }


}
