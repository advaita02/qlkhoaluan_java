/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lbn.controllers;

import com.lbn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author DELL
 */
@Controller
public class HomeController {
    @Autowired
    private UserService userService;
    
    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("users", this.userService.getUsers());
        
        return "index";
    }
}
