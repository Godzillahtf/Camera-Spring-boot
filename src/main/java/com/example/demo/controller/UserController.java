package com.example.demo.controller;

import com.example.demo.model.Auth;
import com.example.demo.model.User;
import com.example.demo.service.EmailService;
import com.example.demo.service.UserService;
import com.sun.corba.se.spi.ior.ObjectKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@Controller
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    EmailService emailService;

    @RequestMapping(path = {"/register"})
    @ResponseBody
    public Map<String, Object> register(@RequestBody Map m) {
        Map<String, Object> ret = new HashMap<>();
        String userName = m.get("userName").toString();
        String password = m.get("password").toString();
        String passwordAgain = m.get("passwordAgain").toString();
        String authCode = m.get("authCode").toString();
        String accessToken = m.get("accessToken").toString();

        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        user.setAuthCode(authCode);
        user.setAccessToken(accessToken);
        user.setParentUserId(0);

        if(!password.equals(passwordAgain)) {
            ret.put("code", 1);
            return ret;
        }
        if(userService.checkIfUserNameExists(userName)) {
            ret.put("code", 2);
            return ret;
        }
        userService.addUser(user);

        int userId = userService.getUserByName(userName).getUserId();

        Auth auth = new Auth(1, userId, 1,1,1,1,1,1,1);
        userService.updateAuth(auth);

        ret.put("code", 0);
        return ret;
    }

    @RequestMapping(path = {"/login"})
    @ResponseBody
    public Map<String, Object> login(@RequestBody Map m) {
        Map<String, Object> ret = new HashMap<>();
        String userName = m.get("userName").toString();
        String password = m.get("password").toString();

        if(!userService.checkIfUserNameExists(userName)) {
            ret.put("code", 1);
            return ret;
        }

        User user = userService.getUserByName(userName);
        if(user.getPassword().equals(password)) {
            ret.put("code", 0);
            ret.put("accessToken", user.getAccessToken());
            ret.put("userId", user.getUserId());
            ret.put("parentId", user.getParentUserId());
            ret.put("mailAddress", user.getMailAddress());
            return ret;
        } else {
            ret.put("code", 1);
            return ret;
        }
    }

    @RequestMapping(path = {"/forgetpswd"})
    @ResponseBody
    public Map<String, Object> forgetpswd(@RequestBody Map m) {
        Map<String, Object> ret = new HashMap<>();
        String userName = m.get("userName").toString();
        String password = m.get("password").toString();
        String passwordAgain = m.get("passwordAgain").toString();
        String authCode = m.get("authCode").toString();

        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        user.setAuthCode(authCode);

        if (!password.equals(passwordAgain)) {
            ret.put("code", 1);
            return ret;
        }
        if (!userService.checkIfUserNameExists(userName)) {
            ret.put("code", 1);
            return ret;
        }
        if (!userService.getUserByName(userName).getAuthCode().equals(authCode)) {
            ret.put("code", 1);
            return ret;
        }

        userService.updatePassword(user);
        ret.put("code", 0);
        return ret;
    }

    @RequestMapping(path = {"/updateAuth"})
    @ResponseBody
    public Map<String, Object> updateAuth(@RequestBody Map m) {
        Map<String, Object> ret = new HashMap<>();

        int userId = Integer.parseInt(m.get("userId").toString());
        int localConfig = Integer.parseInt(m.get("localConfig").toString());
        int systemConfig = Integer.parseInt(m.get("systemConfig").toString());
        int defenceConfig = Integer.parseInt(m.get("defenceConfig").toString());
        int deviceConfig = Integer.parseInt(m.get("deviceConfig").toString());
        int groupConfig = Integer.parseInt(m.get("groupConfig").toString());
        int mapConfig = Integer.parseInt(m.get("mapConfig").toString());

        Auth auth = new Auth(1, userId, localConfig, systemConfig, defenceConfig, deviceConfig, groupConfig, mapConfig, 0);
        userService.updateAuth(auth);

        ret.put("code", 0);
        return ret;
    }


    @RequestMapping(path = {"/registerSon"})
    @ResponseBody
    public Map<String, Object> registerSon(@RequestBody Map m) {
        Map<String, Object> ret = new HashMap<>();
        int user_id = Integer.parseInt(m.get("userId").toString());
        String userName = m.get("userName").toString();
        String password = m.get("password").toString();
        String authCode = m.get("authCode").toString();
        String accessToken = m.get("accessToken").toString();

        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        user.setAuthCode(authCode);
        user.setAccessToken(accessToken);
        user.setParentUserId(user_id);

        if(userService.checkIfUserNameExists(userName)) {
            ret.put("code", 1);
            return ret;
        }
        userService.addUser(user);
        int id = userService.getUserByName(userName).getUserId();
        ret.put("userId", id);
        ret.put("code", 0);
        return ret;
    }

    @RequestMapping(path = {"/getAuth"})
    @ResponseBody
    public Map<String, Object> getAuth(@RequestBody Map m) {
        Map<String, Object> ret = new HashMap<>();
        int user_id = Integer.parseInt(m.get("userId").toString());

        Auth auth = userService.getAuthByUserId(user_id);
        ret.put("auth", auth);
        return ret;
    }

    @RequestMapping(path = {"/getSons"})
    @ResponseBody
    public Map<String, Object> getSons(@RequestBody Map m) {
        Map<String, Object> ret = new HashMap<>();
        int user_id = Integer.parseInt(m.get("userId").toString());

        ret.put("sons", userService.getSonsByParentId(user_id));
        return ret;
    }

    @RequestMapping(path = {"/deleteSon"})
    @ResponseBody
    public Map<String, Object> deleteSon(@RequestBody Map m) {
        Map<String, Object> ret = new HashMap<>();
        int userId = Integer.parseInt(m.get("userId").toString());

        userService.deleteSon(userId);
        ret.put("code", 0);
        return ret;
    }

    @RequestMapping(path = {"/postEmail"})
    @ResponseBody
    public Map<String, Object> postEmail(@RequestBody Map m) {
        Map<String, Object> ret = new HashMap<>();
        String mailAddress = m.get("mailAddress").toString();
        String content = m.get("content").toString();

        EmailService.send(mailAddress, content);
        ret.put("code",0);
        return ret;
    }

    @RequestMapping(path={"/postAuthCode"})
    @ResponseBody
    public Map<String, Object> postAuthCode(@RequestBody Map m) {
        Map<String, Object> ret = new HashMap<>();
        String userName = m.get("userName").toString();
        String mailAddress = m.get("mailAddress").toString();

        String authCode = userService.getUserByName(userName).getAuthCode();
        EmailService.send(mailAddress, "您的验证码是："+ authCode);

        ret.put("code", 0);
        return ret;
    }

    @RequestMapping(path = {"/changeMailAndName"})
    @ResponseBody
    public Map<String, Object> changeMailAndName(@RequestBody Map m) {
        Map<String, Object> ret = new HashMap<>();
        int userId = Integer.parseInt(m.get("userId").toString());
        String userName = m.get("userName").toString();
        String mailAddress = m.get("mailAddress").toString();

        User user = userService.getUserByName(userName);
        if(user != null) {
            ret.put("code", 1);
            ret.put("message", "用户名重复");
            return ret;
        }

        user = new User();
        user.setUserId(userId);
        user.setUserName(userName);
        user.setMailAddress(mailAddress);

        userService.changeMailAndName(user);

        ret.put("code", 0);
        ret.put("message", "OK");
        return ret;
    }



}