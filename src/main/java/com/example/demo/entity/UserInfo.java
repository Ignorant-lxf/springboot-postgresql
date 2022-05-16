package com.example.demo.entity;


public class UserInfo {
  private int id;
  private String name;
  private int age;
  private String addr;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getAddr() {
    return addr;
  }

  public void setAddr(String addr) {
    this.addr = addr;
  }

  public UserInfo() {
  }

  public UserInfo(int id, String name, int age, String addr) {
    this.id = id;
    this.name = name;
    this.age = age;
    this.addr = addr;
  }
<<<<<<< HEAD

  @Override
  public String toString() {
    return "UserInfo{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", age=" + age +
            ", addr='" + addr + '\'' +
            '}';
  }
=======
>>>>>>> c39af85c9d65020d1b43572a36683098bf16c283
}
