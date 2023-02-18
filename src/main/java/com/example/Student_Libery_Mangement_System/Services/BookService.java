package com.example.Student_Libery_Mangement_System.Services;


import com.example.Student_Libery_Mangement_System.DTO.BookRequestDto;
import com.example.Student_Libery_Mangement_System.Models.Author;
import com.example.Student_Libery_Mangement_System.Models.Book;
import com.example.Student_Libery_Mangement_System.Repositories.AuthorRepositoris;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    AuthorRepositoris authorRepositoris;

    public  String addBook(BookRequestDto bookRequestDto){

           // i want to get AuthorEntity??/?
           int authorId=bookRequestDto.getAuthorId();



         // now i will be fetching the authorEntity
        Author author= authorRepositoris.findById(authorId).get();


        // convert
        Book book=new Book();;

        // Basic attribute are being from dto to the entity layer
         book.setGenre(bookRequestDto.getGenre());
         book.setIssued(false);
         book.setPage(bookRequestDto.getPage());
         book.setName(bookRequestDto.getName());

        // setting the foreign key attr in the child class:
           book.setAuthor(author);

         // we need to update the listOfBook written in the parent class




        List<Book> currentBooksWritten=author.getBooksWritten();
        currentBooksWritten.add(book);
//        author.setBooksWritten(currentBooksWritten);

        // now the book is to be save ,but also author is also to be save
        // why d we need to again save(updating)  the author ?? bcz
        // bcz the author entity has been update... we need re-save


        authorRepositoris.save(author); // data was modified
        // save fun-->  save fun work save and update also
        // book repo.save is not required bcz automatically done bcz of cascading
          return "book added";

    }
}
