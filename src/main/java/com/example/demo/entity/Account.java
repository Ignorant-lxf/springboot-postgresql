package com.example.demo.entity;

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
<<<<<<< HEAD

  @Override
  public String toString() {
    return "Account{" +
            "username='" + username + '\'' +
            ", password='" + password + '\'' +
            '}';
  }
=======
>>>>>>> c39af85c9d65020d1b43572a36683098bf16c283
}
