package project.gateways

import project.entities.Project
import project.entities.ProjectId

interface ProjectsGateway {
    fun countAllProjects(): Int
    fun save(project: Project): Project
    fun find(projectId: ProjectId): Project
    fun findAll(): List<Project>
}