package com.sms.ui;
import com.sms.exception.StudentNotFoundException;
import com.sms.util.InputValidator;
import com.sms.model.Student;
import com.sms.service.StudentService;

import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        StudentService ss=new StudentService();
        while(true) {
            System.out.println("\n-----Student Management System-----\n");
            System.out.println("1. Add Student \n");
            System.out.println("2. Display Student \n");
            System.out.println("3. Search Student \n");
            System.out.println("4. Delete Student \n");
            System.out.println("5. Update Students \n");
            System.out.println("6. Total Students \n");
            System.out.println("7. Export Students \n");
            System.out.println("8. Exiting....");
            System.out.println("Enter your choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter Student ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    if (!InputValidator.isValidId(id)) {
                        System.out.println("Invalid Student ID!");
                        break;
                    }
                    System.out.println("Enter Student Name: ");
                    String name = sc.nextLine();
                    sc.nextLine();
                    if (!InputValidator.isValidName(name)) {
                        System.out.println("Invalid Name!");
                        break;
                    }
                    System.out.println("Enter Student Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();
                    if (!InputValidator.isValidAge(age)) {
                        System.out.println("Invalid Age!");
                        break;
                    }
                    System.out.println("Enter Student Course: ");
                    String course = sc.nextLine();
                    if (!InputValidator.isValidCourse(course)) {
                        System.out.println("Invalid Course!");
                        break;
                    }
                    System.out.print("Java Marks : ");
                    int java = sc.nextInt();
                    System.out.print("DSA Marks : ");
                    int dsa = sc.nextInt();
                    System.out.print("DBMS Marks : ");
                    int dbms = sc.nextInt();
                    System.out.print("OS Marks : ");
                    int os = sc.nextInt();
                    System.out.print("CN Marks : ");
                    int cn = sc.nextInt();
                    sc.nextLine();
                    Student s = new Student(id, name, age, course, java, dsa, dbms, os, cn);
                    ss.addStudents(s);
                    break;
                case 2:
                    ss.displayStudents();
                    break;
                case 3:
                    try{
                        System.out.println("Enter Search ID: ");
                        int sid = sc.nextInt();
                        ss.searchStudent(sid);
                        break;
                    }
                    catch(StudentNotFoundException e){
                        System.out.println(e.getMessage());
                    }
                case 4:
                    try{
                        System.out.println("Enter Student ID to delete: ");
                        int did = sc.nextInt();
                        ss.deleteStudent(did);
                        break;
                    }
                    catch(StudentNotFoundException e){
                        System.out.println(e.getMessage());
                    }
                case 5:
                    System.out.println("Enter Student ID: ");
                    int uid = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter Student Name: ");
                    String uname = sc.nextLine();
                    sc.nextLine();
                    System.out.println("Enter Student Age: ");
                    int uage = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter Student Course: ");
                    String ucourse = sc.nextLine();
                    ss.updateStudent(uid,uname,uage,ucourse);
                    break;
                case 6:
                    ss.totalStudents();
                    break;
                case 7:
                    ss.exportStudents();
                    break;
                case 8:
                    System.out.println("Exiting... \n");
                    return;
                default:
                    System.out.println("Enter valid Choice: ");
            }
        }
    }
}
