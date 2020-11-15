package com.joostvandriel.expensify.project.entities

class Project(private var name: String, val id: ProjectId) {
    fun changeName(newName: String) {
        name = newName
    }

    fun getName(): String {
        return name
    }
}