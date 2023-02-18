package com.example.Student_Libery_Mangement_System.Models;


import javax.persistence.*;

@Entity
@Table(name="student")
public class Student {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private  int id;

   private  String name;

   @Column(unique = true)
   private  String email;

    private String mobNo;
    private int age;
    private  String country;




    // plain syntax for bidirectional mapping
    //cascade = CascadeType.ALL-->hey spring the crud operation done is parent class please done it in child class
    // ""-->Name of variable of the Entity that you have written in child class foreign kry attribute
    @OneToOne(mappedBy="studentVariableName",cascade = CascadeType.ALL)
    private Card card;


    /*

       step to find Variable

    1.go to the child class(int this case card)
    2. Out of all attribute select the foreign key attribute that is helping connect with parent class

    (ref : OneToOne
    @JoinColumn
    private Student studentVariableName;

    3. Choose the variable name of the parent(ref-->studentVariableName)



    */



    public Student() {

    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobNo() {
        return mobNo;
    }

    public void setMobNo(String mobNo) {
        this.mobNo = mobNo;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
