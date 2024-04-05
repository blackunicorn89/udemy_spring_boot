package net.javaguides.studentmanagement.servie.impl;

import net.javaguides.studentmanagement.dto.StudentDto;
import net.javaguides.studentmanagement.entity.Student;
import net.javaguides.studentmanagement.mapper.StudentMapper;
import net.javaguides.studentmanagement.repository.StudentRepository;
import net.javaguides.studentmanagement.servie.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    private StudentRepository studentRepository;

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        List<StudentDto>studentDtos = students.stream()
                .map((student)-> StudentMapper.mapToStudentDto(student)).collect(Collectors.toList());
        return studentDtos;
    }
}
