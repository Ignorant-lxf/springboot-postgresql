package com.example.demo.entity;

//每个账户内部应该有id标识，用于开发人员操作
public class Account {
  private String username;
  private String password;


  public Account() {
  }

  public Account(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public String toString() {
    return "Account{" +
            "username='" + username + '\'' +
            ", password='" + password + '\'' +
            '}';
  }

}
