package com.example.demo.models.user;
import java.util.List;

import com.example.demo.models.post.Post;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name ="users")
public class User {
  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private Long id;

  @Column
  private String name;

  @Column(nullable= false , unique= true)
  private String email;

  @Column(nullable= false)
  private String password;

  @OneToMany(mappedBy= "user" , cascade = CascadeType.ALL , orphanRemoval= true)
  private List<Post> posts;


  public User() {}
  public User(String name , String email , String password){
    this.name = name;
    this.email = email;
    this.password = password;
  }

  public Long getId(){
    return id;
  }

  public void setId(Long id){
    this.id = id;
  }

  public String getName(){
    return name;
  }

  public void setName(String name){
    this.name = name;
  }

  public String getEmail(){
    return email;
  }

  public void setEmail(String email){
    this.email = email;
  }

  public String getPassword(){
    return password;
  }

  public void setPassword(String password){
    this.password = password;
  }

  public List<Post> gePosts(){
    return  posts;
  }

  public void setPosts(List<Post> posts){
    this.posts = posts;
  }

}
