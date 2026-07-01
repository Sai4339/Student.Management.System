package com.sms.service;
import com.sms.model.Student;
import com.sms.file.CSVExporter;
import com.sms.dao.StudentDAO;
import java.util.List;
import com.sms.exception.StudentNotFoundException;
import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;
public class StudentService {
    private StudentDAO studentDAO = new StudentDAO();
    public void addStudents(Student student) {
        if (studentDAO.studentExists(student.getId())) {
            System.out.println("Student already exists!");
            return;
        }
        studentDAO.addStudent(student);
        System.out.println("Student added Successfully!!");
    }
    public void displayStudents(){
        List<Student> students = studentDAO.getAllStudents();
        if(students.isEmpty()) {
            System.out.println("No Students found!");
            return;
        }
        for(Student s:students){
            System.out.println("----------------------------------------");
            System.out.println("ID        : " + s.getId());
            System.out.println("Name      : " + s.getName());
            System.out.println("Age       : " + s.getAge());
            System.out.println("Course    : " + s.getCourse());

            System.out.println("Java      : " + s.getJavaMarks());
            System.out.println("DSA       : " + s.getDsaMarks());
            System.out.println("DBMS      : " + s.getDbmsMarks());
            System.out.println("OS        : " + s.getOsMarks());
            System.out.println("CN        : " + s.getCnMarks());

            System.out.println("Total     : " + s.getTotalMarks());
            System.out.println("Average   : " + s.getAverageMarks());
            System.out.println("Grade     : " + s.getGrade());
            System.out.println("----------------------------------------");
        }
    }
    public void searchStudent(int id) throws StudentNotFoundException{
        Student student = studentDAO.searchStudentById(id);
        if(student == null){
            System.out.println("Student Not Found!");
            return;
        }
        System.out.println("----------------------------------------");
        System.out.println("ID        : " + student.getId());
        System.out.println("Name      : " + student.getName());
        System.out.println("Age       : " + student.getAge());
        System.out.println("Course    : " + student.getCourse());
        System.out.println("Java      : " + student.getJavaMarks());
        System.out.println("DSA       : " + student.getDsaMarks());
        System.out.println("DBMS      : " + student.getDbmsMarks());
        System.out.println("OS        : " + student.getOsMarks());
        System.out.println("CN        : " + student.getCnMarks());
        System.out.println("Total     : " + student.getTotalMarks());
        System.out.println("Average   : " + student.getAverageMarks());
        System.out.println("Grade     : " + student.getGrade());
        System.out.println("----------------------------------------");
        throw new StudentNotFoundException(
                "Student with ID " + id + " not found."
        );
    }
    public void deleteStudent(int id) throws StudentNotFoundException{
        boolean deleted = studentDAO.deleteStudent(id);
        if(deleted){
            System.out.println("Student Deleted Successfully!");
        }else{
            System.out.println("Student not found!");
        }
        throw new StudentNotFoundException(
                "Student with ID " + id + " not found."
        );
    }
    public void updateStudent(int id, String name, int age, String course) {
        Student student = studentDAO.searchStudentById(id);
        if (student == null) {
            System.out.println("Student not found!");
            return;
        }
        student.setName(name);
        student.setAge(age);
        student.setCourse(course);
        boolean updated = studentDAO.updateStudent(student);
        if (updated) {
            System.out.println("Student Updated Successfully!");
        } else {
            System.out.println("Student not found!");
        }
    }
    public void totalStudents(){
        int count = studentDAO.getTotalStudentsCount();
        System.out.println("Total Students: " + count);
    }
    public void exportStudents() {
        studentDAO.exportToCSV("students.csv");

    }
}
