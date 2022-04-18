package com.project.springchatapi2.api.service;

import com.project.springchatapi2.api.mapper.UserMapper;
import com.project.springchatapi2.domain.tUsr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    private int addUser(tUsr tUsr){
        return userMapper.addUser(tUsr);
    }

    public List<tUsr> getUsers(){
        return userMapper.getUsers();
    }

    public tUsr getUserByUseKey(int usrKey){
        return userMapper.getUserByUsrKey(usrKey);
    }

    public int deleteUserByUsrKey(int usrKey){
        return userMapper.deleteUserByUsrKey(usrKey);
    }

    public int setUserByUsrKey(tUsr tUsr){
        return userMapper.setUserBy(tUsr);
    }
}
