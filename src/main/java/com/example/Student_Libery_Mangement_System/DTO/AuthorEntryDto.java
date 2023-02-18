package com.example.Student_Libery_Mangement_System.DTO;


public class AuthorEntryDto {
// This is just an obj that will be use to take req from postman

// It will contain the parameter that we want to send from postman

// id  is not here bcz we want to send it from postman





  private  String name;
  private String country;
  private int age;
  private double rating;



    public  AuthorEntryDto(){


    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}




/*





 */