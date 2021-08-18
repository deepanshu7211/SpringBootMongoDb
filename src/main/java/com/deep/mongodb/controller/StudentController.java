package com.deep.mongodb.controller;

import com.deep.mongodb.entity.Student;
import com.deep.mongodb.repository.DepartmentRepository;
import com.deep.mongodb.repository.SubjectRepository;
import com.deep.mongodb.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private DepartmentRepository  departmentRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @PostMapping
    public ResponseEntity<Student> createStudents(@RequestBody Student student){
       /* if(student.getDepartment()!=null){
            departmentRepository.save(student.getDepartment());
        }
        if(student.getSubjects()!=null && student.getSubjects().size()>0){
            subjectRepository.saveAll(student.getSubjects());
        }*/
        Student student1 = studentService.createStudent(student);
        return new ResponseEntity<>(student1, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Student>> getStudents(){
        List<Student> students = studentService.getStudent();
        System.out.println("--- getStudents ======");
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Student> updateStudent(@RequestBody Student student){
           Student updateStudent= studentService.updateStudent(student);
           return new ResponseEntity<>(updateStudent,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") String id){
        studentService.deleteStudent(id);
        return new ResponseEntity<>("SuccessFully Delted ",HttpStatus.NO_CONTENT);
    }

    @GetMapping("/byName/{name}")
    public ResponseEntity<List<Student>> getStudents(@PathVariable("name") String name){
        List<Student> students = studentService.getStudentByName(name);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/nameandemail")
    public ResponseEntity<List<Student>> getStudents(@RequestParam("name") String name,@RequestParam("email") String email){
        List<Student> students = studentService.getStudentByNameAndEmail(name,email);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/nameoremail")
    public ResponseEntity<List<Student>> studentsByNameOrMail(@RequestParam String name,
                                        @RequestParam String email) {
        List<Student> students = studentService.studentsByNameOrMail(name,email);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/pagination")
    public ResponseEntity<List<Student>> studentsByNameOrMail(@RequestParam int pageno,
                                                              @RequestParam int pagesize) {
        List<Student> students = studentService.getStudentsByPagination(pageno,pagesize);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/sort")
    public ResponseEntity<List<Student>> getStudentsWithSorting(){
        List<Student> students = studentService.getStudentWithSorting();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/dept/{deptName}")
    public ResponseEntity<List<Student>> getStudentsWithDepartmentName(@PathVariable("deptName") String departmentName){
        List<Student> students = studentService.getStudentsWithDepartmentName(departmentName);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/subject/{subname}")
    public ResponseEntity<List<Student>> getStudentsWithSubjectName(@PathVariable("subname") String subjectName){
        List<Student> students = studentService.getStudentsWithSubjectName(subjectName);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/emaillike/{email}")
    public ResponseEntity<List<Student>> getStudentsByEmailLike(@PathVariable("email") String email){
        List<Student> students = studentService.getStudentsByEmailLike(email);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
}
