package com.example.Student_Libery_Mangement_System.Controller;


import com.example.Student_Libery_Mangement_System.DTO.AuthorEntryDto;
import com.example.Student_Libery_Mangement_System.DTO.AuthorResponseDto;
import com.example.Student_Libery_Mangement_System.Services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/author")
public class AuthorController {


    @Autowired
    AuthorService authorService;


    @PostMapping("/add")
    public  String  addAuthor(@RequestBody AuthorEntryDto authorEntryDto){

         return authorService.createAuthor(authorEntryDto);
    }


    @GetMapping("/getAuthor")
    public AuthorResponseDto getAuthor(@RequestParam("authorId") Integer authorId){


        return authorService.getAuthor(authorId);
    }

    }
