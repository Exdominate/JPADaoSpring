/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myfirstproject.dao;

import com.myfirstproject.Person;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class PersonDaoImpl implements PersonDao {

    @PersistenceContext
    private EntityManager em;
    private SessionFactory sessionFactory;

    public PersonDaoImpl() {
    }

    @Override
    public void persist(Person p) {
        em.persist(p);
    }

    @Override
    public List<Person> findAll() {
        //Name of the class!!!! Person
        return em.createQuery("SELECT p FROM Person p").getResultList();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Person p) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(p);
        tx.commit();
        session.close();
    }

    @Override
    public List<Person> list() {
        Session session = this.sessionFactory.openSession();
        List<Person> personList = session.createQuery("from Person").list();
        session.close();
        return personList;
    }

}
