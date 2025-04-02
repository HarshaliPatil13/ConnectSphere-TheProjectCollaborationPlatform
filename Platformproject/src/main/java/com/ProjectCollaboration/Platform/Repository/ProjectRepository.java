package com.ProjectCollaboration.Platform.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ProjectCollaboration.Platform.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Long>{

}