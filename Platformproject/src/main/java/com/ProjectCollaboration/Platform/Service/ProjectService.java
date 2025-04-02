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
public class ProjectService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private ProjectRepository projectRepository;

    public void createTask(Long projectId, String title, String description, String status) {
        Optional<Project> projectOpt = projectRepository.findById(projectId);
        if (projectOpt.isPresent()) {
            Task task = new Task();
            task.setProject(projectOpt.get());
            task.setTitle(title);
            task.setDescription(description);
            task.setStatus(status);
            taskRepository.save(task);
        }
    }

    public Optional<Project> findById(Long projectId) {
        return projectRepository.findById(projectId);
    }

    public List<Task> getTasksByProjectId(Long projectId) {
        return projectRepository.findById(projectId)
                .map(project -> taskRepository.findByProject(project))
                .orElse(List.of());
    }



    public void saveProject(Project project) {
        projectRepository.save(project);
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public void deleteProject(Long projectId) {
        projectRepository.deleteById(projectId);
    }
}