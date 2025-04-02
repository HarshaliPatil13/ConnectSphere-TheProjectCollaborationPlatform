

package com.ProjectCollaboration.Platform.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Task {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String status; // "To-Do", "In Progress", "Done"

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;
}
