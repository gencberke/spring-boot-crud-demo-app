package com.hibernateandstuff.jpahibernetdemos.dao;

import com.hibernateandstuff.jpahibernetdemos.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository // execption translation da sağlar
public class StudentDAOImpl implements StudentDAO{

    // define field for entity manager
    private EntityManager entityManager;

    // inject entitiy manager using constructor injection
    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // implement save method
    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student); // save the student
    }

    // implement findById method
    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id); // entity'nin bulunduğu class ı vermiş olduk
    }

    // implement query gathers all students
    @Override
    public List<Student> findAll() {
        // create query
        TypedQuery<Student> typedQuery = entityManager.createQuery(
                "FROM Student order by lastName asc", Student.class);

        // return query results
        return typedQuery.getResultList();
    }

    // implement lastName Query
    @Override
    public List<Student> findByLastName(String lastName) {
        // create query for lastName query
        TypedQuery<Student> typedQuery = entityManager.createQuery(
                "FROM Student WHERE lastName =:theData",Student.class);

        // set "theData" parameter
        typedQuery.setParameter("theData",lastName);

        // return query results as a list
        return typedQuery.getResultList();
    }
}













