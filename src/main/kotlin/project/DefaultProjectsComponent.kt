package com.joostvandriel.expensify.project

import com.joostvandriel.expensify.project.entities.Project
import com.joostvandriel.expensify.project.entities.ProjectFactory
import com.joostvandriel.expensify.project.entities.ProjectId
import com.joostvandriel.expensify.project.entities.ProjectRate
import com.joostvandriel.expensify.project.gateways.ProjectsGateway

class DefaultProjectsComponent(
    private val gateway: ProjectsGateway,
    private val projectFactory: ProjectFactory
) : ProjectsComponent {
    override fun create(name: String): Project {
        val project = projectFactory.newProject(name = name)
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

    override fun assignRate(projectId: ProjectId, rate: Double, start: String) {
        val project = gateway.find(projectId)
        project.assignRate(ProjectRate.create(rate = rate, start = start))
    }
}