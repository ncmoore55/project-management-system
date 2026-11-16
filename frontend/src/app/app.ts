
import { Component, OnInit, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Project, ProjectService } from './services/project';

@Component({
  selector: 'app-root',
  imports: [CommonModule, FormsModule],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App implements OnInit {

  private projectService = inject(ProjectService);

  projects: Project[] = [];

  newProject: Project = {
    name: '',
    description: '',
    status: 'Not Started'
  };

  ngOnInit(): void {
    this.loadProjects();
  }

  loadProjects(): void {
    this.projectService.getProjects().subscribe({
      next: (data) => {
        this.projects = data;
      },
      error: (error) => {
        console.error('Error loading projects:', error);
      }
    });
  }

  addProject(): void {
    if (!this.newProject.name.trim()) {
      alert('Please enter a project name.');
      return;
    }

    this.projectService.createProject(this.newProject).subscribe({
      next: () => {
        alert('Project created successfully!');

        this.loadProjects();

        this.newProject = {
          name: '',
          description: '',
          status: 'Not Started'
        };
      },
      error: (error) => {
        console.error('Error creating project:', error);
        alert('Failed to create project.');
      }
    });
  }

  get inProgressCount(): number {
    return this.projects.filter(
      project => project.status === 'In Progress'
    ).length;
  }

  get completedCount(): number {
    return this.projects.filter(
      project => project.status === 'Completed'
    ).length;
  }

  editProject(project: Project): void {
    if (project.id === undefined) {
      return;
    }

    const name = prompt('Edit project name:', project.name);

    if (name === null || !name.trim()) {
      return;
    }

    const description = prompt(
      'Edit project description:',
      project.description
    );

    if (description === null) {
      return;
    }

    const status = prompt(
      'Edit project status (Not Started, In Progress, Completed):',
      project.status
    );

    if (status === null) {
      return;
    }

    const updatedProject: Project = {
      name: name.trim(),
      description: description,
      status: status
    };

    this.projectService.updateProject(project.id, updatedProject).subscribe({
      next: () => {
        this.loadProjects();
        alert('Project updated successfully!');
      },
      error: (error) => {
        console.error('Error updating project:', error);
        alert('Failed to update project.');
      }
    });
  }
}
