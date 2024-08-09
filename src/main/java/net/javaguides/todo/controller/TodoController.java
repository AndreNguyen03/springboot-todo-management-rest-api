package net.javaguides.todo.controller;

import lombok.AllArgsConstructor;
import net.javaguides.todo.Dto.TodoDto;
import net.javaguides.todo.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
@AllArgsConstructor
public class TodoController {

    private TodoService todoService;

    // Build Add Todo REST API
    @PostMapping
    public ResponseEntity<TodoDto> addTodo(@RequestBody TodoDto todoDto) {
        TodoDto savedTodo = todoService.addTodo(todoDto);
        return new ResponseEntity<>(savedTodo, HttpStatus.CREATED);
    }

    // Build Get ToDo REST API
    @GetMapping("/{id}")
    public ResponseEntity<TodoDto> getTodo(@PathVariable("id") Long todoId) {
        TodoDto getTodo = todoService.getTodo(todoId);
        return new ResponseEntity<>(getTodo, HttpStatus.OK);
    }

    // Build Get All ToDo REST API
    @GetMapping
    public ResponseEntity<List<TodoDto>> getAllTodos() {
        List<TodoDto> todoDtos = todoService.getAllTodos();
        return new ResponseEntity<>(todoDtos, HttpStatus.OK);
    }

    // Build Update Todo REST API
    @PutMapping("/{id}")
    public ResponseEntity<TodoDto> updateTodo(@RequestBody TodoDto todoDto,@PathVariable("id") Long todoId) {
        TodoDto updateTodo = todoService.updateTodo(todoDto, todoId);
        return ResponseEntity.ok(updateTodo);
    }

    //Build Delete Todo REST API
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable("id") Long todoId) {
        todoService.deleteTodo(todoId);
        return new ResponseEntity<>("Deleted todo successfully!", HttpStatus.OK);
    }

    //Build Complete Todo REST API
    @PatchMapping("/{id}/complete")
    public ResponseEntity<TodoDto> completeTodo(@PathVariable("id") Long todoId) {
        TodoDto updatedTodoDto = todoService.completeTodo(todoId);
        return ResponseEntity.ok(updatedTodoDto);
    }

    //Build inComplete Todo REST API
    @PatchMapping("/{id}/in-complete")
    public ResponseEntity<TodoDto> inCompleteTodo(@PathVariable("id") Long todoId) {
        TodoDto updatedTodoDto = todoService.inCompleteTodo(todoId);
        return ResponseEntity.ok(updatedTodoDto);
    }
}
