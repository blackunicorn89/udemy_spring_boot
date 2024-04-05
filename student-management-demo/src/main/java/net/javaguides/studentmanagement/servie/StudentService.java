package net.javaguides.studentmanagement.servie;

import net.javaguides.studentmanagement.dto.StudentDto;
import net.javaguides.studentmanagement.entity.Student;

import java.util.List;

public interface StudentService {
    List<StudentDto>getAllStudents();
}
