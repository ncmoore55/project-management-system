package com.nikdev.backend.controller;

import com.nikdev.backend.model.Project;
import com.nikdev.backend.repository.ProjectRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    private final ProjectRepository projectRepository;

    public ProjectController(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    // GET - Retrieve all projects
    @GetMapping
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    // POST - Create a new project
    @PostMapping
    public Project createProject(@RequestBody Project project) {
        return projectRepository.save(project);
    }

    // PUT - Update an existing project
    @PutMapping("/{id}")
    public Project updateProject(
            @PathVariable Long id,
            @RequestBody Project updatedProject) {

        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Project not found"));

        project.setName(updatedProject.getName());
        project.setDescription(updatedProject.getDescription());
        project.setStatus(updatedProject.getStatus());

        return projectRepository.save(project);
    }

    // DELETE - Remove a project
    @DeleteMapping("/{id}")
    public void deleteProject(@PathVariable Long id) {

        if (!projectRepository.existsById(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Project not found");
        }

        projectRepository.deleteById(id);
    }
}
