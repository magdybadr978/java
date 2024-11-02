package com.example.demo.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.models.user.User;
import com.example.demo.models.user.UserRepository;

@Service
public class UserService {
  private final UserRepository userRepository;

  @Autowired
  public UserService(UserRepository userRepository){
    this.userRepository = userRepository;
  }
  // create user
  public User createUser(User user){
    // check if user exist
    Optional<User> userExist = userRepository.findByEmail(user.getEmail());
    //failed
    if(userExist.isPresent()){
      throw new  ResponseStatusException(HttpStatus.CONFLICT,"email already exist");
    }
    // send response
    return userRepository.create(user);
  }


  // Get Specific User 
  public Optional<User> getUserById(Long id){
    // check if user exist
    boolean userExist = userRepository.existsById(id);
    //failed
    if(!userExist) throw new ResponseStatusException(HttpStatus.NOT_FOUND,"User not exist");
    // Use method findById from AbstractRepository
    return userRepository.findById(id);
  }

  public List<User> getAllUsers(){
    // get all users
    List<User> users =  userRepository.getAll();
    // if list empty
    if(users.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND , "there is no users");
    //send response
    return  users;
  }

  public User updateUser(User user){
    return userRepository.update(user);
  }


  // Delete User
  public void deleteUser(Long id){
    // check if user exist
    boolean userExist = userRepository.existsById(id);
    // failed
    if(!userExist) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "user not found");
    }
    // Use method deleteById from AbstractRepository
    userRepository.deleteById(id);
  }


}
