package com.example.demo.models.post;

import com.example.demo.models.user.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "/posts")
public class Post {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable= false)
  private String title;

  @Column(nullable= false)
  private String content;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;


  public Post() {}

  public Post(String title , String content , User user){
    this.title = title;
    this.content = content;
    this.user = user;
  }

  public Long getId(){
    return id;
  }

  public void setId(Long id){
    this.id = id;
  }

  public String getTitle(){
    return title;
  }

  public void setTitle(String title){
    this.title = title;
  }

  public String getContent(){
    return content;
  }

  public void setContent(String content){
    this.content = content;
  }

  public User getUser(){
    return user;
  }

  public void setUser(User user){
    this.user = user;
  }
}
