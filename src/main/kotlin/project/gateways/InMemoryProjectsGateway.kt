package project.gateways

import project.entities.Project
import project.entities.ProjectId
import project.entities.ProjectNotFound

class InMemoryProjectsGateway: ProjectsGateway {
    private val projects = mutableMapOf<String, Project>()

    override fun save(project: Project): Project {
        projects[project.id.toString()] = project
        return project
    }

    override fun find(projectId: ProjectId): Project {
        val project = projects[projectId.toString()]
        if (project === null) {
            throw ProjectNotFound(projectId.toString())
        }
        return project
    }

    override fun countAllProjects(): Int {
        return projects.size
    }

    fun reset() {
        this.projects.clear()
    }
}
