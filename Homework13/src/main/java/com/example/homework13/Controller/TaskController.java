package com.example.homework13.Controller;

import com.example.homework13.Model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.DeleteExchange;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {

    ArrayList<Task> tasks = new ArrayList<>();



    @GetMapping("")
    public ArrayList<Task> getTasks(){
        return tasks;
    }

    @GetMapping("/{index}")
    public Task getTask(@PathVariable int index){
       Task task=  tasks.get(index);
       return task;
    }

    @PostMapping("")
    public String addTask(@RequestBody Task task){
        tasks.add(task);
        return "Task has been added successfully";
    }

    @PutMapping("/{index}")
    public Task updateTask(@PathVariable int index, @RequestBody Task task){
        tasks.set(index, task);
        return tasks.get(index);
    }

    @DeleteMapping("/{index}")
    public String deleteTask(@PathVariable int index){
        tasks.remove(index);
        return "Task is successfully deleted";
    }

    @PatchMapping("/{index}")
    public Task updateTaskField(@PathVariable int index, @RequestBody Task task){
        Task updatedTask = tasks.get(index);
        updatedTask.setStatus(task.getStatus());
        tasks.set(index,updatedTask);
        return updatedTask;
    }

    @GetMapping("/")
    public List<Task> searchByTitle(@RequestParam(value = "title") String title){

        List<Task> result =
                tasks
                .stream()
                .filter(p-> p.getTitle().equals(("Learning")))
                .collect(Collectors.toList());

        return result;

    }


}
