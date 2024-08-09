package net.javaguides.todo.mapper;

import net.javaguides.todo.Dto.TodoDto;
import net.javaguides.todo.entity.Todo;

public class TodoMapper {
    public static TodoDto mapToTodoDto(Todo todo) {
        return new TodoDto(
                todo.getId(),
                todo.getTitle(),
                todo.getDescription(),
                todo.isCompleted()
        );
    }

    public static Todo mapToTodo(TodoDto todoDto) {
        return new Todo(
                todoDto.getId(),
                todoDto.getTitle(),
                todoDto.getDescription(),
                todoDto.isCompleted()
        );
    }
}
