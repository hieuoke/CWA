package Views;

import Controller.ControllerUltility;
import Controller.DataController;
import Model.Student;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Views {
    public static void main(String[] args) throws IOException {
        int funcion = 0;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("============MENU===============");
            System.out.println("1. Thêm 1 học sinh vào danh sách  ");
            System.out.println("2. Hiển thị các học sinh trong file ");
            System.out.println("4. Thoat");
            System.out.println("Hay chon lua [1-4] : ");
            funcion = scanner.nextInt();
            scanner.nextLine();

            switch (funcion){
                case 4 :
                    scanner.close();
                    System.out.println("Cam ơn đã sử dụng dịch vụ  ");break;
                case 1 :
                    ObjectOutputStream oos = null;
                    try{
                        oos = new ObjectOutputStream(new FileOutputStream("Student.DAT"));
                        String StudentName;
                        int StudentId;
                        String dob;
                        System.out.println("Nhap tên SV : ");
                        StudentName = scanner.nextLine();
                        System.out.println("Nhập Mã SV : ");
                        StudentId = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Nhap ngay sinh");
                        dob=scanner.nextLine();
                        Student student = new Student(StudentName,StudentId,dob);
                        DataController dataController = new DataController();
                        dataController.Writestudenttofile(student,"Student.DAT");
                    }catch (IOException ex) {
                        ex.printStackTrace();
                    }finally {
                        oos.close();
                    }
            }
        }while (funcion != 0);
    }
}