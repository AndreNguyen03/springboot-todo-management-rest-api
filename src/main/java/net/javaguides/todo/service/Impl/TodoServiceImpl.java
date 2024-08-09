package net.javaguides.todo.service.Impl;

import lombok.AllArgsConstructor;
import net.javaguides.todo.Dto.TodoDto;
import net.javaguides.todo.entity.Todo;
import net.javaguides.todo.exception.ResourceNotFoundException;
import net.javaguides.todo.mapper.TodoMapper;
import net.javaguides.todo.repository.TodoRepository;
import net.javaguides.todo.service.TodoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TodoServiceImpl implements TodoService {
    private TodoRepository todoRepository;
    @Override
    public TodoDto addTodo(TodoDto todoDto) {
        Todo todo = TodoMapper.mapToTodo(todoDto);

        Todo savedTodo = todoRepository.save(todo);

        return TodoMapper.mapToTodoDto(savedTodo);
    }

    @Override
    public TodoDto getTodo(Long todoId) {

        Todo todo = todoRepository.findById(todoId).orElseThrow(
                () -> new ResourceNotFoundException("Todo not found with id: "+ todoId)
        );

        return TodoMapper.mapToTodoDto(todo);
    }

    @Override
    public List<TodoDto> getAllTodos() {
        List<Todo> todos = todoRepository.findAll();
        List<TodoDto> todoDtos = todos.stream().map(
                (todo) -> TodoMapper.mapToTodoDto(todo)
        ).collect(Collectors.toList());
        return todoDtos;
    }

    @Override
    public TodoDto updateTodo(TodoDto todoDto, Long todoId) {
        Todo todo = todoRepository.findById(todoId).orElseThrow(
                () -> new ResourceNotFoundException("Todo not found with id:"+ todoId)
        );
        todo.setTitle(todoDto.getTitle());
        todo.setDescription(todoDto.getDescription());
        todo.setCompleted(todoDto.isCompleted());

        Todo updatedTodo = todoRepository.save(todo);
        return TodoMapper.mapToTodoDto(updatedTodo);
    }

    @Override
    public void deleteTodo(Long todoId) {
        Todo todo = todoRepository.findById(todoId).orElseThrow(
                () -> new ResourceNotFoundException("Todo not found with id:"+ todoId)
        );
        todoRepository.deleteById(todoId);
    }

    @Override
    public TodoDto completeTodo(Long id) {
        Todo todo = todoRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Todo not found with id:"+ id)
        );
        todo.setCompleted(Boolean.TRUE);
        Todo completeTodo = todoRepository.save(todo);
        return TodoMapper.mapToTodoDto(completeTodo);
    }

    @Override
    public TodoDto inCompleteTodo(Long id) {
        Todo todo = todoRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Todo not found with id:"+ id)
        );
        todo.setCompleted(Boolean.FALSE);
        Todo inCompleteTodo = todoRepository.save(todo);
        return TodoMapper.mapToTodoDto(inCompleteTodo);
    }
}
