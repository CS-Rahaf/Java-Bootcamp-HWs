package com.example.homework29.contoller;

import com.example.homework29.dto.Response;
import com.example.homework29.model.MyUser;
import com.example.homework29.model.Todo;
import com.example.homework29.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/todo")
public class TodoController {

    private  TodoService todoService;


    @GetMapping()
    public ResponseEntity getTodos(@AuthenticationPrincipal MyUser myUser){
        List<Todo> todos = todoService.getTodos(myUser.getId());
        return ResponseEntity.status(200).body(todos);
    }

    @PostMapping()
    public ResponseEntity <Response> addTodos(@AuthenticationPrincipal MyUser myUser, @RequestBody Todo todo){
        todoService.addTodo(myUser,todo);
        return ResponseEntity.status(201).body(new Response("New Todo added !",201));
    }


    @PutMapping("/{todoId}")
    public ResponseEntity <Response> updateTodos(@AuthenticationPrincipal MyUser myUser, @PathVariable Integer todoId, @RequestBody Todo todo){
        todoService.UpdateTodo(myUser, todoId, todo);
        return ResponseEntity.status(201).body(new Response("Todo updated !",200));
    }

    @DeleteMapping("/{todoId}")
    public ResponseEntity <Response> addTodos(@AuthenticationPrincipal MyUser myUser, @PathVariable Integer todoId){
        todoService.removeTodo(myUser,todoId);
        return ResponseEntity.status(200).body(new Response("Todo deleted !",200));
    }


}
