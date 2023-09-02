/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lbn.repository;

import java.util.List;

import com.lbn.pojo.Users;

/**
 *
 * @author DELL
 */
public interface UserRepository {
    List<Users> getUsers();

    boolean addUser(Users user);

    // User getUserByUserName(String username);
    List<Users> getUsers(String username);

    Users getUserByUsername(String username);
}
