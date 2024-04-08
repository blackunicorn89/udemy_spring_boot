package net.javaguides.studentmanagement.controller;

import net.javaguides.studentmanagement.dto.StudentDto;
import net.javaguides.studentmanagement.servie.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping()
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
//Method to handle list students request

    @GetMapping("students")
    public String getAllStudent(Model model) {
        List<StudentDto> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "students";
    }

//    Method to hande new student request
    @GetMapping("students/new_student")
    public String newStudent(Model model) {
        //Student model object to store student form data
        StudentDto studentDto = new StudentDto();
        model.addAttribute("student", studentDto);
        return "new_student";
    }
}
