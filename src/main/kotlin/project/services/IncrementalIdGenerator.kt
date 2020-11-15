package com.joostvandriel.expensify.project.services

class IncrementalIdGenerator:UniqueIdGenerator {
    private var id: Int = 0
    override fun generate(): String {
        id = id.plus(1)
        return id.toString()
    }
}