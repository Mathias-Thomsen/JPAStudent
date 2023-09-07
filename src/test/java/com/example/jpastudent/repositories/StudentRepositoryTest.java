package com.example.jpastudent.repositories;

import com.example.jpastudent.model.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
class StudentRepositoryTest {


    @Autowired
    StudentRepository studentRepository;

    @BeforeEach
    void setUp(){
        Student std = new Student();
        std.setName("Bruce");
        studentRepository.save(std);
    }

    @Test
    void testOneBruce(){
        List<Student> lst = studentRepository.findAllByName("Bruce");
        assertEquals(1, lst.size());
    }

    @Test
    void testOneViggo(){
        Student s2 = new Student();
        s2.setName("Viggo");
        s2.setBornDate(LocalDate.of(2005, 10, 12));
        studentRepository.save(s2);

        List<Student> lst = studentRepository.findAllByName("Viggo");
        assertEquals(1, lst.size());
    }











}