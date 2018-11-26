package com.example.zdemo.Im.dao;


import com.example.zdemo.Im.domain.UserInfo;

public interface UserInfoDao {

    void loadUserInfo();
    
    UserInfo getByUserId(Long userId);
    
    UserInfo getByUsername(String userName);
}
