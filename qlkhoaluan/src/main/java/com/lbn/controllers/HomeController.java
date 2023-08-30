/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lbn.controllers;

import javax.persistence.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author DELL
 */
@Controller
public class HomeController {
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @RequestMapping("/")
    @Transactional
    public String index(Model model) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        Query query = s.createQuery("FROM Users");
        
        model.addAttribute("users", query.getResultList());
        
        return "index";
    }
}
