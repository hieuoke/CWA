package dto;

import java.io.DataInput;
import java.io.Serializable;
import java.util.Date;

public class StudentDTO implements Serializable {
    private int id;
    private String studentName;
    private int studentID;
    private String studentDob;

    public StudentDTO() {
    }


    public StudentDTO(int id, String studentName, int studentID, String studentDob) {
        this.id = id;
        this.studentName = studentName;
        this.studentID = studentID;
        this.studentDob = studentDob;
    }

    public String getStudentDob() {
        return studentDob;
    }

    public void setStudentDob(String studentDob) {
        this.studentDob = studentDob;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }


    @Override
    public String toString() {
        return "StudentDTO{" +
                "id=" + id +
                ", studentName='" + studentName + '\'' +
                ", studentID=" + studentID +
                ", studentDob='" + studentDob + '\'' +
                '}';
    }
}
