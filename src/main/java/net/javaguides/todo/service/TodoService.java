package net.javaguides.todo.service;

import net.javaguides.todo.Dto.TodoDto;
import net.javaguides.todo.entity.Todo;

import java.util.List;

public interface TodoService {
    TodoDto addTodo(TodoDto todoDto);

    TodoDto getTodo(Long todoId);

    List<TodoDto> getAllTodos();

    TodoDto updateTodo(TodoDto todoDto, Long todoId);

    void deleteTodo(Long todoId);

    TodoDto completeTodo(Long id);
    TodoDto inCompleteTodo(Long id);
}
