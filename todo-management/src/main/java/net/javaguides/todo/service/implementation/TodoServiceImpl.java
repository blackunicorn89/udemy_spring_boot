package net.javaguides.todo.service.implementation;

import lombok.AllArgsConstructor;
import net.javaguides.todo.dto.TodoDto;
import net.javaguides.todo.entity.Todo;
import net.javaguides.todo.repository.TodoRepository;
import net.javaguides.todo.service.TodoService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TodoServiceImpl implements TodoService {

    private TodoRepository todoRepository;

    private ModelMapper modelMapper;

    @Override
    public TodoDto addTodo(TodoDto tododto) {

        //Convert todoDto into Todo Jpa entity
        Todo todo = modelMapper.map(tododto, Todo.class);

        //Todo Jpa entity
        Todo savedtodo = todoRepository.save(todo);

        //Convert saved Todo Jpa entity object into dto object.
        TodoDto savedTodoDto = modelMapper.map(savedtodo, TodoDto.class);

        return savedTodoDto;
    }
}
