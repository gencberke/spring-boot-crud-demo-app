package com.hibernateandstuff.jpahibernetdemos.dao;

import com.hibernateandstuff.jpahibernetdemos.entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository // execption translation da sağlar
public class StudentDAOImpl implements StudentDAO{

    //define field for entity manager
    private EntityManager entityManager;

    //inject entitiy manager using constructor injection
    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //implement save method
    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student); // save the student
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id); // entity'nin bulunduğu class ı vermiş olduk
    }

}
