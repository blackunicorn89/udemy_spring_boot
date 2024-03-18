package net.javaguides.todo.service;

import net.javaguides.todo.dto.TodoDto;

import java.util.List;

public interface TodoService {
    TodoDto addTodo(TodoDto tododto);
    TodoDto getTodo(Long id);

    List<TodoDto> getAllTodos();

    TodoDto UpdateTodo(TodoDto todoDto, Long id);

    void DeleteToDo(Long id);

    TodoDto comppleteTodoDto(Long id);
}
