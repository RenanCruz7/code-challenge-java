package com.todo.api.domain.task;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record EditTaskDTO(
        @NotNull
        Long id,
        @NotBlank
        @Size(min = 5, max = 100)
        String title,
        @NotBlank
        @NotNull
        @Size(min = 5, max = 500)
        String description,
        boolean done,
        boolean favorite,
        @NotBlank
        Color color
) {
}
