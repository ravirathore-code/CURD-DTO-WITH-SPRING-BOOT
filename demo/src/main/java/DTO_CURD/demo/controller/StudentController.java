package DTO_CURD.demo.controller;


import DTO_CURD.demo.dto.createStudentRequestDTO;
import DTO_CURD.demo.dto.createStudentResponseDTO;
import DTO_CURD.demo.dto.updateStudentRequestDTO;
import DTO_CURD.demo.dto.updateStudentResponseDTO;
import DTO_CURD.demo.entity.Students;
import DTO_CURD.demo.service.StudentServices;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    StudentServices studentServices ;

    public StudentController(StudentServices studentServices) {
        this.studentServices = studentServices;
    }
     @PostMapping("/Create")
    public ResponseEntity<createStudentResponseDTO> create ( @Valid @RequestBody createStudentRequestDTO studentRequestDTO) {
         createStudentResponseDTO created = studentServices.StudentCreate(studentRequestDTO) ;

        return ResponseEntity.ok().body(created) ;

    }
      @GetMapping("/Get/{id}")
    public ResponseEntity<Students> get(@PathVariable long id ) {
         Students getValue = studentServices.getStudent(id) ;
        if(getValue == null) {

            return   ResponseEntity.notFound().build();
        }

        return ResponseEntity.accepted().body(getValue) ;
    }
    @GetMapping()
    public ResponseEntity<List<Students>> gets() {
        List<Students> getValues =  studentServices.getStudents() ;
          if(getValues == null) {
           return     ResponseEntity.notFound().build();
          }
        return ResponseEntity.accepted().body(getValues) ;
     }
      @PutMapping("/update/{id}")
     public ResponseEntity<updateStudentResponseDTO> IsUpdate(@PathVariable long id , @RequestBody updateStudentRequestDTO studentRequestDTO) {
         updateStudentResponseDTO IsUpdated = studentServices.studentDetailsUpdate(id , studentRequestDTO) ;

         if(IsUpdated == null) {
             return     ResponseEntity.notFound().build();
         }
         return ResponseEntity.ok().body(IsUpdated) ;
     }

     @DeleteMapping("/delete/{id}")
     public ResponseEntity<String> deleteContact(@PathVariable long id) {
         String  DeletedCon = studentServices.deleteStudent(id) ;


        if(DeletedCon == null) {

            return     ResponseEntity.notFound().build();
        }

       return ResponseEntity.ok().body("Contact is deleted ") ;
     }

     @PatchMapping("/soft/{id}")
     public ResponseEntity<String > softDelete(@PathVariable long id) {
         String  softDeleted = studentServices.contactIsMark(id) ;

         if(softDeleted == null ) {
             return     ResponseEntity.notFound().build();
         }

        return ResponseEntity.ok().body("Contact is deleted") ;


     }















}
