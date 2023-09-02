/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lbn.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.lbn.pojo.Users;

/**
 *
 * @author DELL
 */
public interface UserService extends UserDetailsService {
    List<Users> getUsers();

    boolean addUser(Users user);

    // User getUserByUserName(String username);
    List<Users> getUsers(String name);

    Users getUserByUsername(String username);
}
