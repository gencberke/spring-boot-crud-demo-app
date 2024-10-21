package com.hibernateandstuff.jpahibernetdemos.dao;

import com.hibernateandstuff.jpahibernetdemos.entity.Student;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface StudentDAO {

    void save(Student student);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findByLastName(String lastName);

    void update(Student student);

    void updateMultipleStudents();

    void delete(Integer id);

    int deleteAll();

}
