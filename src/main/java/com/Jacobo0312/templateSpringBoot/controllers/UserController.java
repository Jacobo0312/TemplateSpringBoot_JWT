package com.Jacobo0312.templateSpringBoot.controllers;


import com.Jacobo0312.templateSpringBoot.dao.UserDao;
import com.Jacobo0312.templateSpringBoot.models.UserModel;
import com.Jacobo0312.templateSpringBoot.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private JWTUtil jwtUtil;

    public boolean validateToken(String token) {
        String userID=jwtUtil.getKey(token);
        return userID!=null;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/users/{id}")
    public UserModel getUser(@PathVariable Long id) {
        UserModel user = userDao.getUser(id);
        return user;
    }


    @RequestMapping(method = RequestMethod.GET, value = "/users")
    public List<UserModel> getUsers(@RequestHeader (value="Authorization") String token) {
        if (!validateToken(token)) {
            return null;
        }
        return userDao.getUsers();

    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/users/{id}")
    public void deleteUser(@PathVariable Long id) {
        userDao.deleteUser(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/users")
    public UserModel saveUser(@RequestBody UserModel user) {
        return userDao.saveUser(user);
    }





}


