package com.project.springchatapi2.api.mapper;

import com.project.springchatapi2.domain.tUsr;

import java.util.List;

public interface UserMapper {

    public int addUser(tUsr tUsr);

    public List<tUsr> getUsers();

    public tUsr getUserByUsrKey(int usrKey);

    public int deleteUserByUsrKey(int usrKey);

    public int setUserBy(tUsr tUsr);
}
