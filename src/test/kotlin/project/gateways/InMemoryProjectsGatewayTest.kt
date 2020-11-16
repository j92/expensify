package project.gateways

import project.entities.Project
import project.entities.ProjectId
import project.entities.ProjectNotFound
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class InMemoryProjectsGatewayTest {

    @Test
    fun canFindAProject() {
        val gateway = InMemoryProjectsGateway()
        gateway.save(
            Project(
            id = ProjectId("1"),
            name = "Project X"
        )
        )

        val project = gateway.find(ProjectId("1"))
        assertEquals("Project X", project.getName())
    }

    @Test
    fun findThrowsNotFoundException() {
        val gateway = InMemoryProjectsGateway()
        assertFailsWith<ProjectNotFound>(block = {gateway.find(ProjectId("1"))})
    }
}