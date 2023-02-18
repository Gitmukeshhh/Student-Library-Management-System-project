package com.example.Student_Libery_Mangement_System.Repositories;

import com.example.Student_Libery_Mangement_System.Models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AuthorRepositoris extends JpaRepository<Author,Integer> {

}
