package com.joostvandriel.expensify.project.entities

import com.joostvandriel.expensify.project.services.UniqueIdGenerator

class ProjectFactory(private val idGenerator: UniqueIdGenerator) {
    fun newProject(name: String): Project {
        return Project(
            name = name,
            id = ProjectId(idGenerator.generate())
        )
    }
}