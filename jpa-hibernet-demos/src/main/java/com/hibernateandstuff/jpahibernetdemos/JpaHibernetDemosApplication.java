package com.hibernateandstuff.jpahibernetdemos;

import com.hibernateandstuff.jpahibernetdemos.dao.StudentDAO;
import com.hibernateandstuff.jpahibernetdemos.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class JpaHibernetDemosApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaHibernetDemosApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
            // createStudent(studentDAO);
            // createMultipleStudents(studentDAO);
            // readStudent(studentDAO);
            // queryForStudents(studentDAO); // konsola bastırmak için
            // printSameLastNameStudentsStream(studentDAO);
            printSameLastNameStudentsQuery(studentDAO);
        };
    }

    private void printSameLastNameStudentsQuery(StudentDAO studentDAO) {
        // get a list of students
        List<Student> students = studentDAO.findByLastName("genc");

        // display of students
        students.stream().
                forEach(student -> System.out.println(student));
    }

    private void printSameLastNameStudentsStream(StudentDAO studentDAO) {
        System.out.println();
        studentDAO.findAll().stream().
                filter(student -> student.getLastName().equals("genc"))
                .forEach(student -> System.out.println(student));
    }

    private void queryForStudents(StudentDAO studentDAO) {
        //get a list of students
        List<Student> students = studentDAO.findAll();

        // display of students
        studentDAO.findAll().stream().
                forEach(student -> System.out.println(student));

        // students.forEach(System.out::println); ileride böyle yapcan herhalde
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
        System.out.println("creating 4 new student objects...");
        Student tempStudent = new Student("berke", "genc", "gnc.berke.44@gmail.com");
        Student tempStudent1 = new Student("elif", "genc", "deneme@gmail.com");
        Student tempStudent2 = new Student("faik", "duran", "faikmail@gmail.com");
        Student tempStudent3 = new Student("daim", "duran", "daimmail@gmail.com");

        // save students
        System.out.println("saving the student...");
        studentDAO.save(tempStudent);
        studentDAO.save(tempStudent1);
        studentDAO.save(tempStudent2);
        studentDAO.save(tempStudent3);
    }

    private Student createStudent(StudentDAO studentDAO) {

        // create the student object
        System.out.println("creating new student object...");
        Student tempStudent = new Student("tarhan", "cenk", "tarhan@gmail.com");

        // save the student object
        System.out.println("saving the student...");
        studentDAO.save(tempStudent);

        // display id of the saved student
        System.out.println("saved student. generated id: " + tempStudent.getId());
        return tempStudent;
    }
}











