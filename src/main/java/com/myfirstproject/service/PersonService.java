package com.myfirstproject.service;

import com.myfirstproject.Person;
import com.myfirstproject.dao.PersonDao;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class PersonService {

    @Autowired
    private PersonDao personDao;

   @Transactional
    public void add(Person p) {
        personDao.persist(p);
    }

    @Transactional
    public void addAll(Collection<Person> persons) {
        for (Person p : persons) {
            personDao.persist(p);
        }
    }

    @Transactional(readOnly = true)
    public List<Person> listAll() {
        return personDao.findAll();
    }
}
