package com.example.jpastudent;

import com.example.jpastudent.model.Student;
import com.example.jpastudent.repositories.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalTime;

@SpringBootApplication
public class JpaStudentApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaStudentApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(StudentRepository repository) {
        return (args) -> {
            // Opret og gem nogle studerende med både fødselsdato og fødselstid
            repository.save(new Student("Alice", LocalDate.of(2000, 1, 1), LocalTime.of(8, 30)));
            repository.save(new Student("Bob", LocalDate.of(1999, 2, 2), LocalTime.of(14, 45)));
            // Tilføj flere studerende efter behov
        };
    }

}
