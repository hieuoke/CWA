package Model;

import java.util.Date;

public class Student {
    private static int id = 10000000;
    private String StudentName;
    private int StudentId;
    private String dob;

    public Student() {
    }

    public Student(String studentName, int studentId, String dob) {
        this.StudentName = studentName;
        this.StudentId = studentId;
        this.dob = dob;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Student.id = id;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

    public int getStudentId() {
        return StudentId;
    }

    public void setStudentId(int studentId) {
        StudentId = studentId;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }
}



