package com.todo.api.domain.task;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Table(name = "tasks")
@Entity(name = "Task")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private boolean done;
    private boolean favorite;
    @Enumerated(EnumType.STRING)
    private Color color;
    private LocalDateTime createdAt;


    public Task(CreateTaskDTO dados) {
        this.title = dados.title();
        this.description = dados.description();
        this.done = false;
        this.favorite = false;
        this.color = dados.color();
        this.createdAt = LocalDateTime.now();
    }


}
