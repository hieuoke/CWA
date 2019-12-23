package converter;

import dto.StudentDTO;
import entity.StudentEntity;


import java.text.SimpleDateFormat;

public class StudentConvert {

//    public StudentDTO converterToDto(StudentEntity entity) {
//
//        StudentDTO dto = new StudentDTO();
//        dto.setStudentDob(new SimpleDateFormat("dd/MM/yyyy").format(entity.getStudentDob()));
//        dto.setId(entity.getId());
//        dto.setStudentName(entity.getStudentName());
//        dto.setStudentID(entity.getStudentID());
//
//        return dto;
//    }
//    public StudentEntity converterToEntity(StudentDTO dto) {
//
//        StudentEntity entity1 = new StudentEntity();
//        try {
//            entity1.setStudentDob(new SimpleDateFormat("dd/MM/yyyy").parse(dto.getStudentDob()));
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        entity1.setId(dto.getId());
//        entity1.setStudentName(dto.getStudentName());
//        entity1.setStudentID(dto.getStudentID());
//
//        return entity1;
//    }
}
