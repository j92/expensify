package project.entities

import com.joostvandriel.expensify.project.entities.InvalidStart
import com.joostvandriel.expensify.project.entities.ProjectRate
import org.junit.Test
import kotlin.test.assertFailsWith

class ProjectRateTest {
    @Test
    fun canCreateProjectRate() {
        ProjectRate.create(10.01, "2020-11-16")
    }

    @Test
    fun failsWhenGivenInvalidStart() {
        assertFailsWith<InvalidStart>(block = {ProjectRate.create(10.00, "invalid start")})
    }
}