package com.example.Student_Libery_Mangement_System.Controller;

import com.example.Student_Libery_Mangement_System.DTO.StudentUpdateMobRequest;
import com.example.Student_Libery_Mangement_System.Models.Student;
import com.example.Student_Libery_Mangement_System.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.UnsatisfiedServletRequestParameterException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {


    @Autowired
    StudentService studentService;


    @PostMapping("/add")
    public  String  createStudent(@RequestBody Student student){

        String str=studentService.createStudent(student);
          return str;
    }

    @GetMapping("/get_user")
    public String getNameByEmail(@RequestParam("email") String  email){

        return studentService.getNameByEmail(email);

    }
     @PutMapping("/update_student")
    public  String updateMobNo(@RequestBody StudentUpdateMobRequest studentReqDto ){

      return   studentService.updateMobNo(studentReqDto);


    }







}
