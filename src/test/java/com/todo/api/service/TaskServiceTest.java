package com.todo.api.service;

import com.todo.api.domain.task.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

public class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskService taskService;

    @Test
    @DisplayName("Deve criar uma nova tarefa com sucesso")
    void testCreateTask() {
        CreateTaskDTO createTaskDTO = new CreateTaskDTO("New Task", "Task Description", Color.A99A7C);
        Task task = new Task(createTaskDTO);

        when(taskRepository.save(any(Task.class))).thenReturn(task);

        Task createdTask = taskService.createTask(createTaskDTO);

        assertThat(createdTask.getTitle()).isEqualTo("New Task");
        verify(taskRepository, times(1)).save(any(Task.class));
    }
}