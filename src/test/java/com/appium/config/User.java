package com.appium.config;

/**
 * 
 * @author john
 * @data 2016年9月27日
 * 用户实体类
 */
public class User {

    String userName;
    String passWord;

    public User(String username, String password) {
        this.userName = username;
        this.passWord = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassWord() {
        return passWord;
    }


}
