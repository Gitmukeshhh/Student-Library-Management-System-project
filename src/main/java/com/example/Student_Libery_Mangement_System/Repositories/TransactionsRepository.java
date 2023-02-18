package com.example.Student_Libery_Mangement_System.Repositories;

import com.example.Student_Libery_Mangement_System.Models.Transactions;
import org.apache.el.util.Validation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transaction;
import java.util.List;


@Repository
public interface TransactionsRepository extends JpaRepository<Transactions,Integer> {



 @Query(value = "select * from transactions where book_id=:bookId and card_id=:cardId and is_issue_operation=true",
         nativeQuery = true)

/*
 @Query(value = "select * from transactions t where t.book_id=:bookId ans t.card_id=:cardId and is_issue_operation=true",
 nativeQuery = true)
*/

 List<Transactions> getTransactionsForBookAndCard(int bookId, int cardId);

}
