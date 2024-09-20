package com.todo.api.controller;

import com.todo.api.domain.task.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RequestMapping("/tasks")
@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public ResponseEntity<List<Task>> GetTasks() {
        return ResponseEntity.ok(taskService.getTasks());
    }

    @PostMapping
    @Transactional
    public ResponseEntity CreateTask(@RequestBody CreateTaskDTO data, HttpServletRequest request , UriComponentsBuilder uriBuilder){
        Task task = taskService.createTask(data);
        var uri = uriBuilder.path("/Tasks/{id}").buildAndExpand(task.getId()).toUri();

        return ResponseEntity.created(uri).body(new DetailsTaskDTO(task));
    }

    @PutMapping
    @Transactional
    public ResponseEntity Update(@RequestBody EditTaskDTO data){
        Task task = taskService.updateTask(data);
        return ResponseEntity.ok(new DetailsTaskDTO(task));
    }


    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> Delete(@PathVariable Long id) {
        try {
            taskService.deleteTask(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
