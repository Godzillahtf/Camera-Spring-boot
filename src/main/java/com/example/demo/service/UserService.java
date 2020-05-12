package com.example.demo.service;

import com.example.demo.dao.AuthDao;
import com.example.demo.dao.UserDao;
import com.example.demo.model.Auth;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    @Autowired
    UserDao userDao;
    @Autowired
    AuthDao authDao;

    // 1. check if username cunzai 2. username password authcode accesstoken
    public boolean checkIfUserNameExists(String username) {
        User user = userDao.selectUserByName(username);
        if (user != null) {
            return true;
        } else {
            return false;
        }
    }

    public void addUser(User user) {
        userDao.insertUser(user);
    }

    public User getUserByName(String username) {
        return userDao.selectUserByName(username);
    }

    public void updatePassword(User user) {
        userDao.updateUserByUserName(user);
    }

    public List<User> getSonsByParentId(int parentId) {
        return userDao.getUserByParentId(parentId);
    }

    public void updateAuth(Auth auth) {
        if(authDao.getAuth(auth.getUserId()) == null) {
            authDao.insertAuth(auth);
            return;
        }
        authDao.updateAuthByUserId(auth);
    }

    public Auth getAuthByUserId(int userId) {
        return authDao.getAuth(userId);
    }

    public void insertAuth(Auth auth) {
        authDao.insertAuth(auth);
    }

    public void deleteSon(int userId) { userDao.deleteSonByUserId(userId);}

    public void changeMailAndName(User user) {userDao.updateUserByUserId(user);}

    public User getUserById(int id) {
        return userDao.selectUserById(id);
    }
}