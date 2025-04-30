package com.example.studentmanagement.service;


import com.example.studentmanagement.pojo.Student;
import java.util.List;

/**
 * stu management
 */
public interface StudentService {

    /**
     * delete stu
     * @param id
     */
    void deleteStudent(Integer id);

    /**
     * add stu
     * @param student
     */
    void addStudent(Student student);


    /**
     * mod stu
     * @param student
     */
    void modifyStudent(Student student);

    /**
     * search stus
     */
    List<Student> getStudents();
}
