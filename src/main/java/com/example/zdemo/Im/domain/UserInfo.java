package com.example.zdemo.Im.domain;

import java.util.List;

public class UserInfo {

    private Long userId;
    private String username;
    private String password;
    private String avatarUrl;

    public UserInfo() {
        super();
    }
    
    public UserInfo(Long userId, String username, String password, String avatarUrl) {
        super();
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.avatarUrl = avatarUrl;
    }
    
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
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
    public String getAvatarUrl() {
        return avatarUrl;
    }
    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

}
