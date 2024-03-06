package net.javaguides.springboot.controller;

import net.javaguides.springboot.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/students")

public class StudentController {
    //http://localhost:8080/student
    @GetMapping("/student")
    public ResponseEntity<Student> getStudent() {
        Student student = new Student(1, "Jane", "Matalaguru");
//        return new ResponseEntity<>(student, HttpStatus.OK);
        return ResponseEntity.ok().header("custom-header", "Juuh onnistui").body(student);
    }
    //http://localhost:8080/students
    @GetMapping
    public ResponseEntity<List<Student>> getStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Jane", "Matalaguru"));
        students.add(new Student(2, "Yaruno", "NewerAnswersMyMessages"));
        students.add(new Student(3, "Jonna", "Pökkelipää"));
        students.add(new Student(4, "Heidi", "Mäntyistö"));
        return ResponseEntity.ok(students);

    }

//    Spring BOOT REST Api with one Path variable
    // {id} - URL template variable
    //http://localhost/students/5
    @GetMapping("/{id}")
    public ResponseEntity<Student>  studentPathVariable(@PathVariable("id") int studentId) {
        Student student = new Student(studentId, "Anchi", "Helanderi");
        return ResponseEntity.ok(student);
    }

//    Spring BOOT REST Api with multiple Path variables
    //http://localhost:8080/students/5/anchi/hilanderi
    @GetMapping("/{id}/{first-name}/{last-name}")
    public ResponseEntity<Student> studentPathMultipleVariable(@PathVariable("id") int studentId, @PathVariable("first-name") String firstName, @PathVariable("last-name") String lastName) {
        Student student = new Student(studentId, firstName, lastName);
        return ResponseEntity.ok(student);
    }

    //Spring BOOT REST API with one Request Param
    //http://localhost:8080/students/query/single?id=1
    @GetMapping("/query/single")
    public ResponseEntity<Student> studentRequestVariable(@RequestParam int id) {
        Student student = new Student(id, "Yaruno", "NewerAnswersMyMessages");;
        return ResponseEntity.ok(student);
    }

    //Spring BOOT REST API with multiple Request Params
    //http://localhost:8080/students/query/multiple?id=1&firstname=Yaruno&lastname=NewerAnswersMyMessages
    @GetMapping("/query/multiple")
    public ResponseEntity<Student> studentRequestMultipleVariable(@RequestParam int id, @RequestParam String firstname, @RequestParam String lastname) {
        Student student = new Student(id, firstname, lastname);
        return ResponseEntity.ok(student);
    }

    //Spring BOOT REST API that handles HTTP POST Request - creating new resource
//    @PostMapping and @RequestBody
    //http://localhost:8080/students/create
    @PostMapping("/create")
//    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        System.out.println(student.getId());
        System.out.println(student.getFirstname());
        System.out.println(student.getLastname());
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    //Spring boot REST API that handles HTTP PUT Request - updating existing resource
    //http://localhost:8080/students/update/:id
    @PutMapping("/update/{id}")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable("id") int studentId) {
        System.out.println("Updated the student with the id " + studentId);
        System.out.println(student.getFirstname());
        System.out.println(student.getLastname());
        return ResponseEntity.ok(student);
    }

    //Spring boot REST API that handles HTTP DELETE Request - deleting existing resource
    //http://localhost:8080/students/delete/:id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int studentId) {
        return ResponseEntity.ok("Student with the id " + studentId + " deleted successfully");
    }


}
