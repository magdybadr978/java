package com.example.demo.models;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;



public abstract class AbstractRepository<T , Id>{
  protected final JpaRepository<T , Id> repository;

  protected AbstractRepository(JpaRepository<T , Id> repository){
    this.repository = repository;
  }

  public T save(T entity){
    return repository.save(entity);
  }

  public Optional<T> findById(Id id){
    return repository.findById(id);
  }

  public List<T> findAll(){
    return repository.findAll();
  }

  public void deleteById(Id id){
    repository.deleteById(id);
  }
}