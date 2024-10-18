package com.hibernateandstuff.jpahibernetdemos.dao;

import com.hibernateandstuff.jpahibernetdemos.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student student);

    Student findById(Integer id);

    List<Student> findAll();
}
