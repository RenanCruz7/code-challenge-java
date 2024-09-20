package com.todo.api.domain.task;

import java.time.LocalDateTime;

public record DetailsTaskDTO(Long id, String title, String description, boolean done, boolean favorite, Color color, LocalDateTime createdAt) {
    public DetailsTaskDTO(Task task) {
        this(task.getId(), task.getTitle(), task.getDescription(), task.isDone(), task.isFavorite(), task.getColor(), task.getCreatedAt());
    }
}
