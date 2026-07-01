package com.sms.file;
import com.sms.model.Student;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
public class CSVExporter {
    public static void exportStudents(List<Student> students) {
        try (FileWriter writer = new FileWriter("students.csv")) {
            writer.write("ID,Name,Age,Course,Java,DSA,DBMS,OS,CN,Total,Average,Grade\n");
            for (Student student : students) {
                writer.write(
                        student.getId() + "," +
                                student.getName() + "," +
                                student.getAge() + "," +
                                student.getCourse() + "," +
                                student.getJavaMarks() + "," +
                                student.getDsaMarks() + "," +
                                student.getDbmsMarks() + "," +
                                student.getOsMarks() + "," +
                                student.getCnMarks() + "," +
                                student.getTotalMarks() + "," +
                                student.getAverageMarks() + "," +
                                student.getGrade() + "\n"
                );
            }
            System.out.println("Students exported successfully!");
        } catch (IOException e) {
            System.out.println("Error exporting file.");
        }
    }
}