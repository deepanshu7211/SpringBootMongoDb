package com.deep.mongodb.service;

import com.deep.mongodb.entity.Student;
import com.deep.mongodb.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> getStudent() {
        return studentRepository.findAll();
    }

    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(String id) {
        studentRepository.deleteById(id);
        return;
    }

    public List<Student> getStudentByName(String name) {
        return studentRepository.findByName(name);
    }

    public List<Student> getStudentByNameAndEmail(String name, String email) {
        return studentRepository.findByNameAndEmail(name,email);
    }

    public List<Student> studentsByNameOrMail(String name, String email) {
        return studentRepository.findByNameOrEmail(name,email);
    }

    public List<Student> getStudentsByPagination(int pageno, int pagesize) {
        Pageable pageable = PageRequest.of(pageno-1,pagesize);
        return studentRepository.findAll(pageable).getContent();

    }

    public List<Student> getStudentWithSorting() {
        Sort sort = Sort.by(Sort.Direction.ASC,"name");
        return studentRepository.findAll(sort);
    }

    public List<Student> getStudentsWithDepartmentName(String deptName) {
        return studentRepository.findByDepartmentDepartmentName(deptName);

    }

    public List<Student> getStudentsWithSubjectName(String subjectName) {
        return studentRepository.findBySubjectsSubjectName(subjectName);
    }

    public List<Student> getStudentsByEmailLike(String email) {
        return studentRepository.findByEmailLike(email);
    }
}
