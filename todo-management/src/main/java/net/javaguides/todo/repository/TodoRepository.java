package net.javaguides.todo.repository;

import net.javaguides.todo.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

//JpaRepository takes two arguments, entity type and its primary key type
public interface TodoRepository extends JpaRepository<Todo, Long> {
}
