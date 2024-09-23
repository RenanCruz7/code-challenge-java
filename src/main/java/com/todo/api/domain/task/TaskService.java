package com.todo.api.domain.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getTasks() {
        try {
            var tasks = taskRepository.findAll();
            if (tasks.isEmpty()) {
                throw new RuntimeException("No tasks found");
            } else {
                return tasks;
            }
        } catch (RuntimeException e) {
            // Log the exception if necessary
            return List.of(); // Return an empty list
        }
    }

    public Task createTask(CreateTaskDTO data) {
        var task = new Task(data);
        return taskRepository.save(task);
    }

    public Task updateTask(EditTaskDTO data) {
        var task = taskRepository.findById(data.id())
                .orElseThrow(() -> new RuntimeException("Task not found"));
        task.setTitle(data.title());
        task.setDescription(data.description());
        task.setDone(data.done());
        task.setFavorite(data.favorite());
        task.setColor(data.color());
        return taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        if (taskRepository.existsById(id)) {
            taskRepository.deleteById(id);
        } else {
            throw new RuntimeException("Task not found");
        }
    }

    public List<Task> getFavoriteTasks() {
        return taskRepository.findByFavoriteTrue();
    }



}
