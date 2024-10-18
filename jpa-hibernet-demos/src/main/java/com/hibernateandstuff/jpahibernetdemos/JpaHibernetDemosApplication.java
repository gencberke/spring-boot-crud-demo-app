package com.hibernateandstuff.jpahibernetdemos;

import com.hibernateandstuff.jpahibernetdemos.dao.StudentDAO;
import com.hibernateandstuff.jpahibernetdemos.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaHibernetDemosApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaHibernetDemosApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
            // createStudent(studentDAO);
            //createMultipleStudents(studentDAO);
            readStudent(studentDAO);
        };
    }

    private void readStudent(StudentDAO studentDAO) {
        // display the id of saved student
        int theId = createStudent(studentDAO).getId();
        System.out.println("------------------------");
        System.out.println("saved user id: " + theId);

        // retrieve student based on id: primary key
        System.out.println("retrieving student with id:  " + theId);
        Student myStudent = studentDAO.findById(theId);

        //display student
        System.out.println("found the student: " + myStudent);
    }

    private void createMultipleStudents(StudentDAO studentDAO) {
        // create multiple students
        System.out.println("creating 3 new student objects...");
        Student tempStudent = new Student("berkeg", "genc", "berke.44@gmail.com");
        Student tempStudent1 = new Student("elif", "genc", "terminal@gmail.com");
        Student tempStudent2 = new Student("bonita", "duran", "bonitaninmaeili@gmail.com");

        // save students
        System.out.println("saving the student...");
        studentDAO.save(tempStudent);
        studentDAO.save(tempStudent1);
        studentDAO.save(tempStudent2);
    }

    private Student createStudent(StudentDAO studentDAO) {

        // create the student object
        System.out.println("creating new student object...");
        Student tempStudent = new Student("berke", "genç", "gnc.berke.44@gmail.com");

        // save the student object
        System.out.println("saving the student...");
        studentDAO.save(tempStudent);

        // display id of the saved student
        System.out.println("saved student. generated id: " + tempStudent.getId());
        return tempStudent;
    }
}











