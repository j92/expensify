package com.joostvandriel.expensify.project

import com.joostvandriel.expensify.project.entities.Project
import com.joostvandriel.expensify.project.entities.ProjectId
import com.joostvandriel.expensify.project.gateways.ProjectsGateway
import com.joostvandriel.expensify.project.services.UniqueIdGenerator

class DefaultProjectsComponent(
    private val gateway: ProjectsGateway,
    private val idGenerator: UniqueIdGenerator
) : ProjectsComponent {
    override fun create(name: String): Project {
        val project = Project(
            name = name,
            id = ProjectId(idGenerator.generate())
        )
        return gateway.save(project)
    }

    override fun count(): Int {
        return gateway.countAllProjects()
    }

    override fun changeName(projectId: ProjectId, newName: String) {
        val project = gateway.find(projectId)
        project.changeName(newName)
    }

    override fun getProject(projectId: ProjectId): Project {
        return gateway.find(projectId)
    }
}