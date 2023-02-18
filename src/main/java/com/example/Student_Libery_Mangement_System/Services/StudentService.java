package com.example.Student_Libery_Mangement_System.Services;

import com.example.Student_Libery_Mangement_System.DTO.StudentUpdateMobRequest;
import com.example.Student_Libery_Mangement_System.Enums.CardStatus;
import com.example.Student_Libery_Mangement_System.Models.Card;
import com.example.Student_Libery_Mangement_System.Models.Student;
import com.example.Student_Libery_Mangement_System.Repositories.StudentRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class StudentService {
    @Autowired
    StudentRepositories studentRepositories;

    public  String createStudent(Student student){
        //Student from the postman is already the basic attribute set

        //Card should be autogenerate  When create student function is call

        Card card=new Card();
        card.setCardStatus(CardStatus.ACTIVATED);
        card.setStudentVariableName(student);  // foreign key attribute
        // filing the value of the unidirectional



        //filing the value of the bidirectional
        student.setCard(card);

        // if there was unidirectional mapping: we had to save both of them
        // But we are super advance are using bidirectional:child will automatically save

        
           studentRepositories.save(student);

           // By cascading effect ,child will automatically to save

         return " Student and card added";

    }

    public  String getNameByEmail(String email){

        Student student=studentRepositories.findByEmail(email);
           return student.getName();

    }

    public  String updateMobNo(StudentUpdateMobRequest studentReq){

        // CONVERT THE DTO INTO ENTITY:SAVE BETTER
        // user try override
        // First we will try to fetch original dataS
         Student originalStudent=studentRepositories.findById(studentReq.getId()).get();


         // we will keep the other properties as it is : and only change the required parameter
         originalStudent.setMobNo(studentReq.getMobNo());




         studentRepositories.save(originalStudent);
         return "update student successfully";

    }
}


/*

  1->Existing function with no define
  2->Existing function +with define
  3-




 */
