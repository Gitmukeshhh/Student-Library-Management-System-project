package com.example.Student_Libery_Mangement_System.Controller;


import com.example.Student_Libery_Mangement_System.DTO.BookRequestDto;
import com.example.Student_Libery_Mangement_System.Models.Book;
import com.example.Student_Libery_Mangement_System.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;


    @PostMapping("/addbook")
    public String addBook(@RequestBody BookRequestDto bookRequestDto){
         return bookService.addBook(bookRequestDto);
    }
}


