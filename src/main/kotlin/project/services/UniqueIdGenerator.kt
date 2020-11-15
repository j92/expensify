package com.joostvandriel.expensify.project.services

interface UniqueIdGenerator {
    fun generate(): String
}