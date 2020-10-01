package com.project.techaract.amclub.Models;

public class SimpleForm {

    private String name;
    private String email;
    private String phNum;
    private String gender;
    private String society;
    private String createdAt;
    private String age;

    public SimpleForm(){}

    public SimpleForm(String name, String email, String phNum, String gender, String society, String createdAt, String age) {
        this.name = name;
        this.email = email;
        this.phNum = phNum;
        this.gender = gender;
        this.society = society;
        this.createdAt = createdAt;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhNum() {
        return phNum;
    }

    public String getGender() {
        return gender;
    }

    public String getSociety() {
        return society;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhNum(String phNum) {
        this.phNum = phNum;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setSociety(String society) {
        this.society = society;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
