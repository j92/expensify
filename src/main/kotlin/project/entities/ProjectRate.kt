package com.joostvandriel.expensify.project.entities

import java.time.LocalDate
import java.time.format.DateTimeParseException

class ProjectRate private constructor(val rate: Double, val start: LocalDate) {
    companion object {
        fun create(rate: Double, start: String): ProjectRate {
            try {
                LocalDate.parse(start)
            } catch (error: DateTimeParseException) {
                throw InvalidStart.withDate(start)
            }

            return ProjectRate(
                rate = rate,
                start = LocalDate.parse(start)
            )
        }
    }

    override fun toString(): String {
        return "ProjectRate(rate=$rate, start=$start)"
    }
}