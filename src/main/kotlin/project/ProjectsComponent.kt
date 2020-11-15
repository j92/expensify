package com.joostvandriel.expensify.project

import com.joostvandriel.expensify.project.entities.Project
import com.joostvandriel.expensify.project.entities.ProjectId

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
}