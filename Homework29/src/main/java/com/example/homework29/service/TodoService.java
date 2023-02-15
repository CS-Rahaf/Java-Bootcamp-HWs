package com.example.homework29.service;


import com.example.homework29.Exception.ApiException;
import com.example.homework29.model.MyUser;
import com.example.homework29.model.Todo;
import com.example.homework29.repository.AuthRepository;
import com.example.homework29.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {

   private final TodoRepository todoRepository;
   private final AuthRepository authRepository;


   /* public Optional<Todo> getTodos(MyUser myUser) {
        List<Todo> allTodos= todoRepository.findAll();
        Optional<Todo> todos = Optional.ofNullable(allTodos.stream()
                .filter(todo1 -> (myUser.getId()).equals(todo1.getMyUser().getId()))
                .findAny()
                .orElse(null));


        return todos;
    }*/

    public List<Todo> getTodos(Integer userId) {
        MyUser user = authRepository.findMyUserById(userId);
        List<Todo> todos = todoRepository.findAllByMyUser(user);
        return todos;
    }

    public Todo getTodo(Integer id){
       Todo todo = todoRepository.findTodoById(id);
        if(todo==null){
            throw new ApiException("Todo not found");
        }
        return todo;
    }

    public void addTodo(MyUser myUser,Todo todo) {
        todo.setMyUser(myUser);
        todoRepository.save(todo);
    }

    public void UpdateTodo(MyUser myUser, Integer todoId , Todo todo) {
        Todo currentTodo= getTodo(todoId);

        if(currentTodo.getMyUser().getId() != myUser.getId()){
            throw new ApiException("This user doesn't have this todo");
        }

        todo.setId(currentTodo.getId());
        todoRepository.save(todo);

      /*  Todo currentTodo= getTodo(todoId);

        if(currentTodo.getUserId()!=userId){
           throw new ApiException("This user doesn't have this todo");
        }

        todo.setId(currentTodo.getId());
        todoRepository.save(todo);*/

    }

    public void removeTodo(MyUser myUser, Integer todoId) {
        Todo todo= getTodo(todoId);

        if(todo.getMyUser().getId() != myUser.getId()){
            throw new ApiException("This user doesn't have this todo");
        }

        todoRepository.deleteById(todoId);
    }



}
