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

    @Override
    public void addNewStudent(StudentDto studentDto) {
        Student student = StudentMapper.mapToStudent(studentDto);
        studentRepository.save(student);
    }

    @Override
    public StudentDto getStudentById(Long id) {
        Student student = studentRepository.findById(id).get();
        StudentDto studentDto = StudentMapper.mapToStudentDto(student);
        return studentDto;
    }

    @Override
    public void updateStudent(StudentDto studentDto) {
        studentRepository.save(StudentMapper.mapToStudent(studentDto));
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
