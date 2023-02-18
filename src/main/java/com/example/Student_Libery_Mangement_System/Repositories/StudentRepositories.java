package com.example.Student_Libery_Mangement_System.Repositories;

import com.example.Student_Libery_Mangement_System.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepositories extends JpaRepository<Student,Integer> {
    //1 --> JPA have some predefine query.
    //2 --> JPA write  basic query for us.
    //3--> findByName() just like.
    //4--> it also return object.
    //5--> complex query return by user


    Student findByEmail(String email);
    // select * from Student where country= india
    List<Student> findByCountry(String country);
}
