/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lbn.controllers;

import com.lbn.configs.SpringSecurityConfig;
import com.lbn.service.UserService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author IdeaPad S540
 */
@Controller
public class UserController  {
    @Autowired
    private UserService userDetailsService;
    
    @GetMapping("/")
    private String login(Model model){
        return "login";
    }
    
    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("users", this.userDetailsService.getUsers());
        
        return "index";
    }
}
