package com.adil.cruddemo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.adil.cruddemo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository // supports component scanning and translate JDBC exceptions
public class StudentDAOImpl implements StudentDAO {
    // define field for entity manager
    private EntityManager entityManager;

    // define field for entity using constructor injection

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // implements save methods
    @Override
    @Transactional
    public void save(Student thStudent) {
        entityManager.persist(thStudent);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

}
