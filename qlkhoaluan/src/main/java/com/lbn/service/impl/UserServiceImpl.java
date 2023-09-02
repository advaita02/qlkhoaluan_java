/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lbn.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.lbn.pojo.Users;
import com.lbn.repository.UserRepository;
import com.lbn.service.UserService;

/**
 *
 * @author DELL
 */
@Service("userDetailsService")
public class UserServiceImpl implements UserService {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Users> getUsers() {
        return this.userRepository.getUsers();
    }

    @Override
    public Users getUserByUsername(String username) {
        return this.userRepository.getUserByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = this.userRepository.getUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User doesn't exsist");
        }
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole()));
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                authorities);
    }

    @Override
    public boolean addUser(Users user) {
        String password = user.getPassword();
        user.setPassword(this.bCryptPasswordEncoder.encode(password));
        user.setRole("student");
        return this.userRepository.addUser(user);
    }

    @Override
    public List<Users> getUsers(String name) {
        return this.userRepository.getUsers(name);
    }

}
