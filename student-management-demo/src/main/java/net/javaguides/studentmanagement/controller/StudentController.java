package net.javaguides.studentmanagement.controller;

import jakarta.validation.Valid;
import net.javaguides.studentmanagement.dto.StudentDto;
import net.javaguides.studentmanagement.entity.Student;
import net.javaguides.studentmanagement.servie.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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

//    Method to handdle student details request
    @GetMapping("/students/details/{id}")
    public String showStudentDetails(@PathVariable("id") Long id, Model model) {
        StudentDto studentDto;
        studentDto = studentService.getStudentById(id);
        model.addAttribute("studentDto", studentDto);
        return "student_details";
    }

//    Method to hande new student request
    @GetMapping("students/new_student")
    public String newStudent(Model model) {
        //Student model object to store student form data
        StudentDto studentDto = new StudentDto();
        model.addAttribute("student", studentDto);
        return "new_student";
    }

//    Method to handle add student form request

    @PostMapping("students/add")
    public String addNewStudent(@Valid @ModelAttribute("studentDto") StudentDto studentDto, BindingResult result, Model model) {
        if(result.hasErrors()) {
            model.addAttribute("studentDto", studentDto);
            return "new_student";
        }
        studentService.addNewStudent(studentDto);
        return "redirect:/students";
    }
//    Method to handle edit student form request
    @GetMapping("students/edit/{id}")
    public String editStudent(@PathVariable("id") Long id, Model model) {
        StudentDto studentDto = studentService.getStudentById(id);
        model.addAttribute("studentDto", studentDto);
        return "edit_student";
    }

//    Method to handle edit student form submit request
    @PostMapping("/students/edit/{id}")
    public String updateStudent(@PathVariable("id") Long id, @Valid @ModelAttribute("studentDto") StudentDto studentDto,
                                BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("studentDto", studentDto);
            return "edit_student";
        }
        studentDto.setId(id);
        studentService.updateStudent(studentDto);
        return "redirect:/students";
    }

//    Method to handel delete request
    @GetMapping("/students/delete/{id}")
    public String deleteStudent(@PathVariable("id") Long id) {
        studentService.deleteStudent(id);
        return "redirect:/students";
    }

}
