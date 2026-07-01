package com.sms.dao;
import com.sms.database.DatabaseConnection;
import com.sms.model.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.io.FileWriter;
import java.util.List;
public class StudentDAO {
    public void addStudent(Student student) {
        String sql = """
            INSERT INTO students
            (id, name, age, course,
             java_marks, dsa_marks,
             dbms_marks, os_marks, cn_marks)
            VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)
            """;
        try (
                Connection connection = DatabaseConnection.getConnection();
                java.sql.PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {
            statement.setInt(1, student.getId());
            statement.setString(2, student.getName());
            statement.setInt(3, student.getAge());
            statement.setString(4, student.getCourse());
            statement.setInt(5, student.getJavaMarks());
            statement.setInt(6, student.getDsaMarks());
            statement.setInt(7, student.getDbmsMarks());
            statement.setInt(8, student.getOsMarks());
            statement.setInt(9, student.getCnMarks());
            statement.executeUpdate();
            System.out.println("Student added successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM students";
        try (
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery()
        ) {
            while (resultSet.next()) {
                Student student = new Student(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("age"),
                        resultSet.getString("course"),
                        resultSet.getInt("java_marks"),
                        resultSet.getInt("dsa_marks"),
                        resultSet.getInt("dbms_marks"),
                        resultSet.getInt("os_marks"),
                        resultSet.getInt("cn_marks")
                );
                students.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }
    public Student searchStudentById(int id) {
        String sql = "SELECT * FROM students WHERE id = ?";
        try (
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)
        ) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Student(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("age"),
                        resultSet.getString("course"),
                        resultSet.getInt("java_marks"),
                        resultSet.getInt("dsa_marks"),
                        resultSet.getInt("dbms_marks"),
                        resultSet.getInt("os_marks"),
                        resultSet.getInt("cn_marks")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public boolean updateStudent(Student student) {
        String sql = """
            UPDATE students
            SET name = ?,
                age = ?,
                course = ?,
                java_marks = ?,
                dsa_marks = ?,
                dbms_marks = ?,
                os_marks = ?,
                cn_marks = ?
            WHERE id = ?
            """;
        try (
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)
        ) {
            statement.setString(1, student.getName());
            statement.setInt(2, student.getAge());
            statement.setString(3, student.getCourse());
            statement.setInt(4, student.getJavaMarks());
            statement.setInt(5, student.getDsaMarks());
            statement.setInt(6, student.getDbmsMarks());
            statement.setInt(7, student.getOsMarks());
            statement.setInt(8, student.getCnMarks());
            statement.setInt(9, student.getId());
            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean deleteStudent(int id) {
        String sql = "DELETE FROM students WHERE id = ?";
        try (
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)
        ) {
            statement.setInt(1, id);
            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean studentExists(int id) {
        String sql = "SELECT id FROM students WHERE id = ?";
        try (
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)
        ) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            return rs.next(); // true if student exists
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public void exportToCSV(String filePath) {
        List<Student> students = getAllStudents();
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write("ID,Name,Age,Course,Java,DSA,DBMS,OS,CN,Total,Average,Grade\n");
            for (Student s : students) {
                writer.write(
                        s.getId() + "," +
                                s.getName() + "," +
                                s.getAge() + "," +
                                s.getCourse() + "," +
                                s.getJavaMarks() + "," +
                                s.getDsaMarks() + "," +
                                s.getDbmsMarks() + "," +
                                s.getOsMarks() + "," +
                                s.getCnMarks() + "," +
                                s.getTotalMarks() + "," +
                                s.getAverageMarks() + "," +
                                s.getGrade() + "\n"
                );
            }
            System.out.println("Data exported successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public int getTotalStudentsCount() {
        String sql = "SELECT COUNT(*) FROM students";
        try (
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet rs = statement.executeQuery()
        ) {
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}