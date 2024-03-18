package net.javaguides.todo.service.implementation;

import lombok.AllArgsConstructor;
import net.javaguides.todo.dto.TodoDto;
import net.javaguides.todo.entity.Todo;
import net.javaguides.todo.exception.ResourceNotFoundException;
import net.javaguides.todo.repository.TodoRepository;
import net.javaguides.todo.service.TodoService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @Override
    public TodoDto getTodo(Long id) {
        Todo foundToDo = todoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo not found with the id: " + id));
        return modelMapper.map(foundToDo, TodoDto.class);

    }

    @Override
    public List<TodoDto> getAllTodos() {
        List<Todo> allTodos = todoRepository.findAll();
        return allTodos.stream().map((todo) -> modelMapper.map(todo, TodoDto.class)).collect(Collectors.toList());
    }

    @Override
    public TodoDto UpdateTodo(TodoDto updateTodoDto, Long todoId) {
        Todo updateTodo = todoRepository.findById(todoId).orElseThrow(() -> new ResourceNotFoundException("Todo not found with the id: " + todoId));

        updateTodo.setTitle((updateTodoDto.getTitle()));
        updateTodo.setDescription((updateTodoDto.getDescription()));
        updateTodo.setCompleted((updateTodoDto.isCompleted()));
        Todo updatedTodo = todoRepository.save(updateTodo);

        return modelMapper.map(updatedTodo, TodoDto.class);

    }

    @Override
    public void DeleteToDo(Long id) {
        Todo deleteToDo = todoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Todo not found with the id: " + id));
        todoRepository.delete(deleteToDo);
    }

    @Override
    public TodoDto comppleteTodoDto(Long id) {
        Todo todo = todoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Todo not found with the id: " + id));
        todo.setCompleted(Boolean.TRUE);

        Todo updatedTodo = todoRepository.save(todo);
        return modelMapper.map(updatedTodo, TodoDto.class);
    }
}
