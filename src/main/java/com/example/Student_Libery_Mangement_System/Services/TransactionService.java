package com.example.Student_Libery_Mangement_System.Services;

import com.example.Student_Libery_Mangement_System.DTO.IssueBookRequestDto;
import com.example.Student_Libery_Mangement_System.Enums.CardStatus;
import com.example.Student_Libery_Mangement_System.Enums.TransactionStatus;
import com.example.Student_Libery_Mangement_System.Models.Book;
import com.example.Student_Libery_Mangement_System.Models.Card;
import com.example.Student_Libery_Mangement_System.Models.Student;
import com.example.Student_Libery_Mangement_System.Models.Transactions;
import com.example.Student_Libery_Mangement_System.Repositories.BookRepositoris;
import com.example.Student_Libery_Mangement_System.Repositories.CardRepositoris;
import com.example.Student_Libery_Mangement_System.Repositories.StudentRepositories;
import com.example.Student_Libery_Mangement_System.Repositories.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TransactionService {

    @Autowired
    TransactionsRepository transactionsRepository;

    @Autowired
    BookRepositoris bookRepositoris;

    @Autowired
    CardRepositoris cardRepositoris;

    public  String issueBook(IssueBookRequestDto issueBookRequestDto) throws  Exception{

        int bookId=issueBookRequestDto.getBookId();
        int cardId=issueBookRequestDto.getCardId();

        // get the book Entity ans card entity ???? why do we need this
        // we are doing this bcz we want to set the transaction attribute;

        Book book=bookRepositoris.findById(bookId).get();
        Card card=cardRepositoris.findById(cardId).get();



        // Finial goal is  to make transaction entity set it...
        // and save it


           Transactions transactions =new Transactions();

           // setting the attribute
          transactions .setBook(book);
          transactions.setCard(card);
          transactions.setTransactionId(UUID.randomUUID().toString());
          transactions.setIssueOperation(true);
          transactions.setTransactionStatus(TransactionStatus.PENDING);

        // attribute left is success/Failure
        //Check for validation

        if(book==null || book.isIssued()==true){

            transactions.setTransactionStatus(TransactionStatus.FAILED);
            transactionsRepository.save(transactions);
            throw new Exception("Book is not available");
        }


        if(card==null ||card.getCardStatus()!= CardStatus.ACTIVATED){
               transactions.setTransactionStatus(TransactionStatus.FAILED);
               transactionsRepository.save(transactions);
               throw new Exception("card is not valid");
        }

             // We have reached a success case now..

            transactions.setTransactionStatus(TransactionStatus.SUCCESS);

            // set attribute of book
             book.setIssued(true);


             //Btw the book transaction :-->bidirectional
            List<Transactions>  listOfTransactionsForBook =book.getListOfTransactions();
            listOfTransactionsForBook.add(transactions);
            book.setListOfTransactions(listOfTransactionsForBook);



            // I need to make change in the card
            //Book and the card
           List<Book> issuedBookForCard=card.getBooksIssued();
           issuedBookForCard.add(book);
           card.setBooksIssued(issuedBookForCard);

           // card and truncation :_> Bidirectional
           List<Transactions>  transactionsListForCard=card.getTransactionsList();
           transactionsListForCard.add(transactions);
           card.setTransactionsList(transactionsListForCard);







         // Do some  validation





        // set the origin keys and bidirectional setting




        // save the parent...


        // Auto by cascading :book and transaction will be save;;
        // Saving th parent..
        cardRepositoris.save(card);

               return "Book issue successfully";
    }


     public String getTransactions(int bookId,int cardId){

       List<Transactions> transactionsList=transactionsRepository.getTransactionsForBookAndCard(bookId,cardId);
       String transactionId=transactionsList.get(0).getTransactionId();
       return  transactionId;

    }
}
