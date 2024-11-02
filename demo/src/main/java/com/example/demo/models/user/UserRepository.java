package com.example.demo.models.user;
import java.util.Optional;
import com.example.demo.models.AbstractRepository;



public interface  UserRepository extends AbstractRepository<User , Long>{
  Optional<User> findByEmail(String email);

}
