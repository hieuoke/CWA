package controller;

import Manger.StudentManager;
import dto.StudentDTO;
import repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentController {


    public static void main(String[] args) {
        int funcion = 0;
        Scanner scanner = new Scanner(System.in);
        StudentManager studentManager =new StudentManager();
        ArrayList<StudentDTO> students = new ArrayList<StudentDTO>();
        int studentID;
        do {
            showMenu();
            funcion = scanner.nextInt();
            scanner.nextLine();
            switch (funcion){
                case 0 :
                    scanner.close();
                    break;
                case 1 :
                    studentManager.addStudent();
                    break;
                case 2 :
                    studentID = studentManager.inputId();
                    studentManager.EditStudent(studentID);
                    break;
                case 3 :
                     studentID = studentManager.inputId();
                    studentManager.deleteStudent(studentID);
                    break;
                case 4 :
                    studentManager.sortStudentByDob();
                    break;
                case 5 :
                    StudentRepository studentRepository = new StudentRepository();
                    students = (ArrayList<StudentDTO>) studentRepository.read();
                    String key = null;
                    System.out.println("Nhâp từ khóa cần tìm : ");
                    key= scanner.nextLine();
                    ArrayList<StudentDTO> result = studentManager.searchStudent(students,key);
                    if (result.size()==0){
                        System.out.println("Không tìm thấy tên sinh viên trong file");
                    }else {
                        ShowIn4Student(result);
                    }
                    System.out.println();
                    break;
                case 6 :
                    studentManager.show();
                    break;

            }


        }while (funcion != 0);
    }


    public static void showMenu() {
        System.out.println("-----------menu------------");
        System.out.println("1. Add student.");
        System.out.println("2. Edit student by id.");
        System.out.println("3. Delete student by id.");
        System.out.println("4. Sort Student by Dob.");
        System.out.println("5. Seach Student by Name.");
        System.out.println("6. Show student.");
        System.out.println("0. exit.");
        System.out.println("---------------------------");
        System.out.print("Please choose: ");
    }
    private static void ShowIn4Student(List<StudentDTO> students) {
        for (StudentDTO s:students) {
            System.out.println(s);
        }
}
}
