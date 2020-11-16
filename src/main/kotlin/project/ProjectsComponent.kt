package project

import project.entities.Project
import project.entities.ProjectId

interface ProjectsComponent {
    /**
     * Create a new project
     */
    fun create(name: String): Project

    /**
     * Get the total amount of projects
     */
    fun count(): Int

    /**
     * Change a projects name
     */
    fun changeName(projectId: ProjectId, newName: String)

    /**
     * Find a project by id
     */
    fun getProject(projectId: ProjectId): Project

    /**
     * Assign new rate to project
     */
    fun assignRate(projectId: ProjectId, rate: Double, start: String)
}