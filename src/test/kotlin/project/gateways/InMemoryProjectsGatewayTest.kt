package project.gateways

import com.joostvandriel.expensify.project.entities.Project
import com.joostvandriel.expensify.project.entities.ProjectId
import com.joostvandriel.expensify.project.entities.ProjectNotFound
import com.joostvandriel.expensify.project.gateways.InMemoryProjectsGateway
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class InMemoryProjectsGatewayTest {

    @Test
    fun canFindAProject() {
        val gateway = InMemoryProjectsGateway()
        gateway.save(Project(
            id = ProjectId("1"),
            name = "Project X"
        ))

        val project = gateway.find(ProjectId("1"))
        assertEquals("Project X", project.getName())
    }

    @Test
    fun findThrowsNotFoundException() {
        val gateway = InMemoryProjectsGateway()
        assertFailsWith<ProjectNotFound>(block = {gateway.find(ProjectId("1"))})
    }
}