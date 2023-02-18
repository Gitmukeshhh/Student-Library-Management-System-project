package com.example.Student_Libery_Mangement_System.Repositories;

import com.example.Student_Libery_Mangement_System.Models.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CardRepositoris extends JpaRepository<Card,Integer> {
}
