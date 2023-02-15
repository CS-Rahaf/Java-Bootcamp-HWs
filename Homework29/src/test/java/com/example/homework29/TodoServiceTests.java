package com.example.homework29;


import com.example.homework29.model.MyUser;
import com.example.homework29.model.Todo;
import com.example.homework29.repository.AuthRepository;
import com.example.homework29.repository.TodoRepository;
import com.example.homework29.service.TodoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TodoServiceTests {

    @InjectMocks
    TodoService todoService;

    @Mock
    TodoRepository todoRepository;

    @Mock
    AuthRepository authRepository;


    Todo todo1,todo2,todo3;
    List<Todo> todos;
    MyUser myUser;

    @BeforeEach
    void setUp() {
        myUser=new MyUser(1,"Rahaf" , "1234" , "ADMIN" , null);
        todo1 = new Todo(1 , "todo1", myUser );
        todo2 = new Todo(2 , "todo2", myUser );
        todo3 = new Todo(3 , "todo3", null );

        todos = new ArrayList<>();

        todos.add(todo1);
        todos.add(todo2);
        todos.add(todo3);
    }

    @Test
    void getTodosTest(){
        when(authRepository.findMyUserById(myUser.getId())).thenReturn(myUser);
        when(todoRepository.findAllByMyUser(myUser)).thenReturn(todos);

        List<Todo> todoList = todoService.getTodos(myUser.getId());

        Assertions.assertEquals(3,todoList.size());
        verify(todoRepository,times(1)).findAllByMyUser(myUser);
        verify(authRepository,times(1)).findMyUserById(myUser.getId());
    }

    @Test
    void addTodoTest(){
       todoService.addTodo(myUser, todo3);

        verify(todoRepository,times(1)).save(todo3);
    }

    @Test
    void updateTodoTest(){
        when(todoRepository.findTodoById(todo1.getId())).thenReturn(todo1);

        todoService.UpdateTodo(myUser,todo1.getId(),todo3);

        verify(todoRepository,times(1)).findTodoById(todo1.getId());
        verify(todoRepository,times(1)).save(todo3);
    }

    @Test
    void deleteTodoTest(){
        when(todoRepository.findTodoById(todo1.getId())).thenReturn(todo1);

        todoService.removeTodo(myUser,todo1.getId());

        verify(todoRepository,times(1)).findTodoById(todo1.getId());
        verify(todoRepository,times(1)).deleteById(todo1.getId());
    }

}
