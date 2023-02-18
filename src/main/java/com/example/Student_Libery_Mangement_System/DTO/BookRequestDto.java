package com.example.Student_Libery_Mangement_System.DTO;

import com.example.Student_Libery_Mangement_System.Enums.Genre;

public class BookRequestDto {

    private  String  name;
    private  int page;
    private Genre genre;
    private int authorId;




    public  BookRequestDto(){



    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }
}
