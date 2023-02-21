package com.Jacobo0312.templateSpringBoot.dao;

import com.Jacobo0312.templateSpringBoot.models.UserModel;

import java.util.List;

public interface UserDao {

    List<UserModel> getUsers();
    UserModel getUser(Long id);
    void deleteUser(Long id);
    UserModel saveUser(UserModel user);
    UserModel updateUser(UserModel user);
    UserModel verifyCredentials(UserModel user);






}
