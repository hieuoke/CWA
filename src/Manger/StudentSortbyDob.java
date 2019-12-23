package Manger;

import dto.StudentDTO;
import entity.StudentEntity;

import java.text.SimpleDateFormat;
import java.util.Comparator;

public class StudentSortbyDob implements Comparator<StudentDTO> {
    public StudentDTO converterToDto(StudentEntity entity) {
        StudentDTO dto = new StudentDTO();
        dto.setStudentDob(new SimpleDateFormat("dd/MM/yyyy").format(entity.getStudentDob()));
        dto.setId(entity.getId());
        dto.setStudentName(entity.getStudentName());
        dto.setStudentID(entity.getStudentID());
        return dto;
    }
    @Override
    public int compare(StudentDTO o1, StudentDTO o2) {
        return o1.getStudentDob().compareTo(o2.getStudentDob());
    }
}
