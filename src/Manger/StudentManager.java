package Manger;

import converter.StudentConvert;
import dto.StudentDTO;
import entity.StudentEntity;
import repository.StudentRepository;

import java.util.*;

public class StudentManager  {
    public Scanner scanner = new Scanner(System.in);
    private List<StudentDTO> list;
    private StudentRepository studentRepository;

    public StudentManager() {
        studentRepository = new StudentRepository();
        list=studentRepository.read();
    }

    public void addStudent(){
        int id = (list.size() > 0) ? (list.size() + 1) : 1;
        System.out.println("Student id = "+ id );
            String studenName = inputStudentName();
            int studentID = inputStudentID();
            String studentDob = inputStudentDob();
            StudentDTO studentDTO = new StudentDTO(id,studenName,studentID,studentDob);
            list.add(studentDTO);
            studentRepository.write(list);
    }
    public void EditStudent(int id){

        boolean isExisted = false;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (list.get(i).getId() == id) {
                isExisted = true;
                list.get(i).setStudentName(inputStudentName());
                list.get(i).setId(inputStudentID());
                list.get(i).setStudentDob(inputStudentDob());
                break;
            }
        }
        if (!isExisted) {
            System.out.printf("id = %d not existed.\n", id);
        } else {
            studentRepository.write(list);
        }
    }
    public void deleteStudent(int id){
        StudentDTO s = null;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (list.get(i).getId() == id) {
                s = list.get(i);
                break;
            }
        }
        if (s != null) {
            list.remove(s);
            studentRepository.write(list);
        } else {
            System.out.printf("id = %d not existed.\n", id);
        }
    }
    public void sortStudentByDob() {
        Collections.sort(list, new StudentSortbyDob());
    }
    public ArrayList<StudentDTO> searchStudent(ArrayList<StudentDTO> list, String key) {
        ArrayList<StudentDTO> result = new ArrayList<>();
        String regex = ".*" + key + ".*";
        for (int i = 0; i < list.size(); i++) {
            StudentDTO s = list.get(i);
            if (s.getStudentName().matches(regex)) {
                result.add(s);
            }
        }
        return result;
    }
    public void show() {
        System.out.println("  id |    StudentName   | StudentID  | DateOfBirth");
        System.out.println();
        for (StudentDTO s : list) {
            System.out.format("%4d | ", s.getId());
            System.out.format("%16s | ", s.getStudentName());
            System.out.format("%5d | ", s.getStudentID());
            System.out.format("%10s | ", s.getStudentDob());
            System.out.println();
        }
    }
    public int inputId() {
        System.out.print("Input student id: ");
        while (true) {
            try {
                int id = Integer.parseInt((scanner.nextLine()));
                return id;
            } catch (NumberFormatException ex) {
                System.out.print("invalid! Input student id again: ");
            }
        }
    }

    private String inputStudentName() {
        System.out.print("Input student name: ");
        return scanner.nextLine();
    }
    private int inputStudentID() {
        System.out.print("Input student ID: ");
        int studentID = Integer.parseInt(scanner.nextLine());
        return studentID;

    }
    private String inputStudentDob() {
        System.out.print("Input student Dob: ");
        return scanner.nextLine();
    }
    public List<StudentDTO> getList() {
        return list;
    }

    public void setList(List<StudentDTO> list) {
        this.list = list;
    }
}
