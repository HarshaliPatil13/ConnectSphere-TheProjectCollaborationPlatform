package com.ProjectCollaboration.Platform.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProjectCollaboration.Platform.Repository.ProjectRepository;
import com.ProjectCollaboration.Platform.Repository.TaskRepository;
import com.ProjectCollaboration.Platform.model.Project;
import com.ProjectCollaboration.Platform.model.Task;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private ProjectRepository projectRepository;

    public List<Task> getTasksByProjectId(Long projectId) {
        Optional<Project> projectOpt = projectRepository.findById(projectId);
        return projectOpt.map(taskRepository::findByProject).orElse(List.of());
    }

    public void createTask(Long projectId, String title, String description, String status) {
        Optional<Project> projectOpt = projectRepository.findById(projectId);
        if (projectOpt.isPresent()) {
            Task task = new Task();
            task.setTitle(title);
            task.setDescription(description);
            task.setStatus(status);
            task.setProject(projectOpt.get());
            taskRepository.save(task);
        } else {
            throw new RuntimeException("Project not found");
        }
    }
}


