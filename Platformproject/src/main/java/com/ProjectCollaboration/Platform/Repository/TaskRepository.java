package com.ProjectCollaboration.Platform.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ProjectCollaboration.Platform.model.Task;
import com.ProjectCollaboration.Platform.model.Project;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByProject(Project project);
}
