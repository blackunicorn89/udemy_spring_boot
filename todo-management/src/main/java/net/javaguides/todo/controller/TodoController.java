package net.javaguides.todo.controller;

import lombok.AllArgsConstructor;
import net.javaguides.todo.dto.TodoDto;
import net.javaguides.todo.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/todos")
@AllArgsConstructor
public class TodoController {
    private TodoService todoService;

    //Add todo REST API
    @PostMapping
    @RequestMapping("/add")
    public ResponseEntity<TodoDto> addTodo(@RequestBody TodoDto todoDto) {
        TodoDto savedTodoDto = todoService.addTodo(todoDto);
        return new ResponseEntity<>(savedTodoDto, HttpStatus.CREATED);
    }

    //Get Single todo REST API
    @GetMapping("{id}")
    public ResponseEntity<TodoDto> getSingleTodo(@PathVariable("id") Long todoId) {
        TodoDto singleToDo = todoService.getTodo(todoId);
        return new ResponseEntity<>(singleToDo, HttpStatus.OK);

    }

    //Get all todos REST API
    @GetMapping
    public ResponseEntity<List<TodoDto>> getAllTodos() {
        List<TodoDto>allTodos = todoService.getAllTodos();
        return new ResponseEntity<>(allTodos, HttpStatus.OK);
        //return ResponseEntity.ok(allTodos);
    }

    //Edit todo REST API
    @RequestMapping
    @PutMapping("/edit/{id}")
    public ResponseEntity<TodoDto>editTodo(@RequestBody TodoDto todoDto, @PathVariable("id") Long todoId) {
        TodoDto updatedTodoDto = todoService.UpdateTodo(todoDto, todoId);
        return ResponseEntity.ok(updatedTodoDto);
    }

    //Set todo to completed REST API
    @PatchMapping("/setCompleted/{id}")
    public ResponseEntity<TodoDto>setTodoToCompleted(@PathVariable("id") Long todoId) {
        TodoDto completedToDo = todoService.comppleteTodoDto(todoId);
        return ResponseEntity.ok(completedToDo);
    }

    //Delete todo REST Api
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String>deleteToDo(@PathVariable("id") Long id) {
        todoService.DeleteToDo(id);
        return ResponseEntity.ok("Successfully removed todo with the id " + id);
    }

}
