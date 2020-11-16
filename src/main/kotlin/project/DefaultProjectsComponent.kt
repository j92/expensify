package project

import project.entities.Project
import project.entities.ProjectFactory
import project.entities.ProjectId
import project.entities.ProjectRate
import project.gateways.ProjectsGateway
import project.ProjectsComponent

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