package com.example.Student_Libery_Mangement_System.Models;


import com.example.Student_Libery_Mangement_System.Enums.CardStatus;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="card")
public class Card {

    //plane is to save in DB
    // Before saving i have to set its attribute


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;  // its autogenerate

    @CreationTimestamp // Auto timestamp the time when an entry is created;
    private Date createOn; //its autogenerate

    @UpdateTimestamp // Set time when an entry an updated;
    private Date updateOn; // its autogenerate


    @Enumerated(value = EnumType.STRING)
    private CardStatus cardStatus; // set this attribute

    // Unidirectional MAPPING
    @OneToOne
    @JoinColumn
    private Student studentVariableName;// this variable use in parent class while doing bidirectional mapping


    // card is parent with respect to book
    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL)
    private  List<Book> booksIssued=new ArrayList<>();//references of child here book



    // connecting the card class to the transaction
    // bidirectional

    @OneToMany(mappedBy = "card",cascade = CascadeType.ALL)
    private  List<Transactions> transactionsList=new ArrayList<>();

    public Card() {
    }


    public List<Transactions> getTransactionsList() {
        return transactionsList;
    }

    public void setTransactionsList(List<Transactions> transactionsList) {
        this.transactionsList = transactionsList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreateOn() {
        return createOn;
    }

    public void setCreateOn(Date createOn) {
        this.createOn = createOn;
    }

    public Date getUpdateOn() {
        return updateOn;
    }

    public void setUpdateOn(Date updateOn) {
        this.updateOn = updateOn;
    }

    public CardStatus getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(CardStatus cardStatus) {
        this.cardStatus = cardStatus;
    }

    public Student getStudentVariableName() {
        return studentVariableName;
    }

    public void setStudentVariableName(Student studentVariableName) {
        this.studentVariableName = studentVariableName;
    }

    public List<Book> getBooksIssued() {
        return booksIssued;
    }

    public void setBooksIssued(List<Book> booksIssued) {
        this.booksIssued = booksIssued;
    }
}
