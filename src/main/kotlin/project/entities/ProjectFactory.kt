package project.entities

import project.services.UniqueIdGenerator
import project.entities.Project
import project.entities.ProjectId

class ProjectFactory(private val idGenerator: UniqueIdGenerator) {
    fun newProject(name: String): Project {
        return Project(
            name = name,
            id = ProjectId(idGenerator.generate())
        )
    }
}