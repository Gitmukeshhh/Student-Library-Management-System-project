package com.example.Student_Libery_Mangement_System.Models;


import com.example.Student_Libery_Mangement_System.Enums.Genre;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private String name;
    private  int page;
    private boolean issued;

       @Enumerated(value = EnumType.STRING)
       private Genre genre;


       //Book is child  wrt to author
       // Setting here the foreign kry

       @ManyToOne
       @JoinColumn// add an extra attribute of authorId(parent table pk)for th fk of child table
       private Author author;// this is parent entity we are connect with



        // Book is child wrt card
       @ManyToOne
       @JoinColumn
       private  Card card;


      // Book is parent wrt translocation

      @OneToMany(mappedBy ="book",cascade = CascadeType.ALL)
      private List<Transactions> listOfTransactions=new ArrayList<>();





    public Book() {

    }


    public String getName() {
        return name;
    }

    public List<Transactions> getListOfTransactions() {
        return listOfTransactions;
    }

    public void setListOfTransactions(List<Transactions> listOfTransactions) {
        this.listOfTransactions = listOfTransactions;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName(String name) {
        return this.name;
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

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public boolean isIssued() {
        return issued;
    }

    public void setIssued(boolean issued) {
        this.issued = issued;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
