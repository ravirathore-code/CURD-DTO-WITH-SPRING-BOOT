package DTO_CURD.demo.service;


import DTO_CURD.demo.dto.createStudentRequestDTO;
import DTO_CURD.demo.dto.createStudentResponseDTO;
import DTO_CURD.demo.dto.updateStudentRequestDTO;
import DTO_CURD.demo.dto.updateStudentResponseDTO;
import DTO_CURD.demo.entity.Students;
import DTO_CURD.demo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServices {

    StudentRepository studentRepository;

    public StudentServices(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public createStudentResponseDTO StudentCreate(createStudentRequestDTO studentRequestDTO) {

        Students students = mapToEntity(studentRequestDTO) ;

        Students studentsResp = studentRepository.save(students) ;
        return mapToResponseDTO(studentsResp) ;

    }

    public Students getStudent(long id) {
        Optional<Students> gotStudent = studentRepository.findById(id);

        if (gotStudent.isEmpty()) {
            return null;
        }

        return gotStudent.get();
    }

    public List<Students> getStudents() {
        List<Students> gotStudents = studentRepository.findAll();
        if (gotStudents.isEmpty()) {
            return null;
        }
        return gotStudents;
    }

    public updateStudentResponseDTO studentDetailsUpdate(long id, updateStudentRequestDTO studentRequestDTO) {
         Optional<Students> SearchingStudent = studentRepository.findById(id) ;

         if(SearchingStudent.isEmpty()) {
             return null ;
         }


         Students updateValue = SearchingStudent.get() ;
         updateValue.setAge(studentRequestDTO.getAge());

         updateValue.setIsDelete(false);
         updateValue.setName(studentRequestDTO.getName());
         updateValue.setPhone_number(studentRequestDTO.getPhone_number());

        Students studentToSave =   studentRepository.save(updateValue) ;

        return updateToResponse(studentToSave) ;

    }

    public String  deleteStudent(long id) {
        Optional<Students> deleteTheStudent = studentRepository.findById(id) ;

        if(studentRepository.existsById(id)) {
              studentRepository.deleteById(id);
            return "Student contact id deleted "  ;
        }

         return null ;

    }

    public String contactIsMark(long id) {
        Optional<Students> ContactIsMarked = studentRepository.findById(id);

        if (studentRepository.existsById(id)) {
            Students student = ContactIsMarked.get() ;
            student.setIsDelete(true);
            studentRepository.save(student) ;

            return "Student  marks successfully " ;


        }
        return null  ;
    }

    private Students mapToEntity(createStudentRequestDTO studentRequestDTO) {

        Students students = new Students() ;

        students.setName(studentRequestDTO.getName());
        students.setAge(studentRequestDTO.getAge());
        students.setEmail(studentRequestDTO.getEmail());
        students.setPhone_number(studentRequestDTO.getPhone_number());
        students.setCreated_at(LocalDateTime.now());
        students.setUpdate_at(LocalDateTime.now());

       students.setIsDelete(false);
        return students ;
    }

    public createStudentResponseDTO mapToResponseDTO(Students students) {

        createStudentResponseDTO studentRespDto = new createStudentResponseDTO();

        studentRespDto.setName(students.getName());
        studentRespDto.setAge(students.getAge());
        studentRespDto.setEmail(students.getEmail());
        studentRespDto.setPhone_number(students.getPhone_number());
        studentRespDto.setMassage("Contact is created successfully ");
        studentRespDto.setCreated_at(LocalDateTime.now());
        studentRespDto.setUpdate_at(LocalDateTime.now());

        return studentRespDto ;

    }

   private updateStudentResponseDTO updateToResponse( Students studentToSave) {

        updateStudentResponseDTO studentRespDto = new updateStudentResponseDTO() ;

       studentRespDto.setName(studentToSave.getName());
       studentRespDto.setAge(studentToSave.getAge());

       studentRespDto.setPhone_number(studentToSave.getPhone_number());


       studentRespDto.setUpdate_at(LocalDateTime.now());

       return studentRespDto ;
   }







}