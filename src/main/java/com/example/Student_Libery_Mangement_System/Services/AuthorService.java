package com.example.Student_Libery_Mangement_System.Services;


import com.example.Student_Libery_Mangement_System.DTO.AuthorEntryDto;
import com.example.Student_Libery_Mangement_System.DTO.AuthorResponseDto;
import com.example.Student_Libery_Mangement_System.DTO.BookResponseDto;
import com.example.Student_Libery_Mangement_System.Models.Author;
import com.example.Student_Libery_Mangement_System.Models.Book;
import com.example.Student_Libery_Mangement_System.Repositories.AuthorRepositoris;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {

    @Autowired
    AuthorRepositoris authorRepositoris;

    public String createAuthor(AuthorEntryDto authorEntryDto){

        //important step is : int the param : the object
        // of type DTO but the repository interacts with entities
        // Solution: convert authorEntryDto-->Author;



        // create obj of Author
        Author author=new Author();

        // we can setting its attribute so that we can save
        // correct value int the db
        // Repo always work with entity
        author.setName(authorEntryDto.getName());
        author.setAge(authorEntryDto.getAge());
        author.setCountry(authorEntryDto.getCountry());
        author.setRating(authorEntryDto.getRating());
        authorRepositoris.save(author);
        return "Author added";
    }



       public AuthorResponseDto getAuthor(Integer authorId){

        Author author=authorRepositoris.findById(authorId).get();
        AuthorResponseDto authorResponseDto= new AuthorResponseDto();

            // set its attribute;

           List<Book> bookList=author.getBooksWritten();

           List<BookResponseDto> bookWrittenDto=new ArrayList<>();
           for(Book b:bookList){

               BookResponseDto bookResponseDto=new BookResponseDto();
               bookResponseDto.setGenre(b.getGenre());
               bookResponseDto.setPages(b.getPage());
               bookResponseDto.setName(b.getName());

               bookWrittenDto.add(bookResponseDto);
           }

               authorResponseDto.setBooksWritten(bookWrittenDto);
               authorResponseDto.setName(author.getName());
               authorResponseDto.setAge(author.getAge());
               authorResponseDto.setRating(author.getRating());

               return authorResponseDto;
       }

}
