package com.joostvandriel.expensify.project.gateways

import com.joostvandriel.expensify.project.entities.Project
import com.joostvandriel.expensify.project.entities.ProjectId

interface ProjectsGateway {
    fun countAllProjects(): Int
    fun save(project: Project): Project
    fun find(projectId: ProjectId): Project
}