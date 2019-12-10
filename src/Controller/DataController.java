package Controller;

import Model.Student;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class DataController {
    private FileWriter fileWriter;
    private BufferedWriter bufferedWriter;
    private PrintWriter printWriter;
    private Scanner scanner;
    public void openfiletoWrite(String filename) throws IOException {
        try {
            fileWriter = new FileWriter(filename, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            printWriter = new PrintWriter(bufferedWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void OpenfiletoRead(String filename){
        try {
            scanner =new Scanner(Paths.get(filename),"UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void ClosefileafterRead(String filename){
        try {
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void Writestudenttofile(Student student, String filename) throws IOException {
        openfiletoWrite(filename);
        printWriter.println(student.getStudentName() + " | " + student.getStudentId() + " | " + student.getDob()
        );
        ClosefileAfterWrite(filename);
    }
    void ClosefileAfterWrite(String filename) {
        try {
            printWriter.close();
            bufferedWriter.close();
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//    public ArrayList<Student> readReadfromtofile(String filename){
//        OpenfiletoRead(filename);
//        ArrayList<Student> students = new ArrayList<>();
//        while (scanner.hasNextLine()){
//            String data = scanner.nextLine();
//            Student student = creatrStudentfromdata(data);
//            students.add(student);
//        }
//        ClosefileafterRead(filename);
//        return students;
//    }

//    private Student creatrStudentfromdata(String data) {
//        String[] datas = data.split("\\|");
//        Student student = new Student(datas[0],Integer.parseInt(datas[1]), [2]);
//        return  student;
//    }

}
