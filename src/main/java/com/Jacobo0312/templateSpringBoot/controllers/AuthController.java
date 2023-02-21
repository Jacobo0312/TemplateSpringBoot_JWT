package com.Jacobo0312.templateSpringBoot.controllers;

import com.Jacobo0312.templateSpringBoot.dao.UserDao;
import com.Jacobo0312.templateSpringBoot.models.UserModel;
import com.Jacobo0312.templateSpringBoot.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private JWTUtil jwtUtil;

@RequestMapping(value="/login", method= RequestMethod.POST)
    public String login(@RequestBody UserModel user) {
    UserModel loggedUser = userDao.verifyCredentials(user);

    if (loggedUser !=null) {
            String tokenJwt = jwtUtil.create(String.valueOf(loggedUser.getId()), loggedUser.getEmail());
            return tokenJwt;
        } else {
            return "Incorrect login";
        }
    }

}
