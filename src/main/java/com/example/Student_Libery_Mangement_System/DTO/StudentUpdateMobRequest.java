package com.example.Student_Libery_Mangement_System.DTO;

public class StudentUpdateMobRequest {

    private  int id;
    private String mobNo;

    // DTO's  depend om the API'S CALLED ...add
    // DTO's  depend om the API'S CALLED ...add


    public  StudentUpdateMobRequest(){


    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMobNo() {
        return mobNo;
    }

    public void setMobNo(String mobNo) {
        this.mobNo = mobNo;
    }
}
