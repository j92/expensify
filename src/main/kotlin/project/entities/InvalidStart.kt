package com.joostvandriel.expensify.project.entities

class InvalidStart(message: String) : Throwable(message) {
    companion object {
        fun withDate(date: String): InvalidStart {
            return InvalidStart("Invalid start given: $date")
        }
    }
}
