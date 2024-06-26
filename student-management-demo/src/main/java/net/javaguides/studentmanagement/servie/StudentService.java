package net.javaguides.studentmanagement.servie;

import net.javaguides.studentmanagement.dto.StudentDto;
import net.javaguides.studentmanagement.entity.Student;

import java.util.List;

public interface StudentService {
    List<StudentDto>getAllStudents();

    void addNewStudent(StudentDto studentDto);

    StudentDto getStudentById(Long id);

    void updateStudent(StudentDto studentDto);

    void deleteStudent(Long id);
}
