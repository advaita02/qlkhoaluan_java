/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lbn.repository.impl;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lbn.pojo.Users;
import com.lbn.repository.UserRepository;

/**
 *
 * @author DELL
 */
@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    @Transactional
    public List<Users> getUsers() {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("FROM Users");

        return q.getResultList();
    }

    @Override
    public boolean addUser(Users user) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        try {
            s.save(user);
            return true;
        } catch (HibernateException ex) {
            System.err.print(ex);
        }
        return false;
    }

    @Override
    public List<Users> getUsers(String username) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<User> q = b.createQuery(User.class);
        Root root = q.from(User.class);
        q.select(root);

        if (username.isEmpty()) {
            Predicate p = b.equal(root.get("username").as(String.class), username.trim());
            q = q.where(p);
        }
        Query query = s.createQuery(q);
        return query.getResultList();
    }

    @Override
    public Users getUserByUsername(String username) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("From Users Where username=:un");
        q.setParameter("un", username);

        try {
            Users singleResult = (Users) q.getSingleResult();
            return singleResult;
        } catch (Exception e) {
            return null;
        }
    }

}
