package project

import com.joostvandriel.expensify.project.DefaultProjectsComponent
import com.joostvandriel.expensify.project.entities.Project
import com.joostvandriel.expensify.project.entities.ProjectFactory
import com.joostvandriel.expensify.project.entities.ProjectId
import com.joostvandriel.expensify.project.gateways.InMemoryProjectsGateway
import com.joostvandriel.expensify.project.services.IncrementalIdGenerator
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

class DefaultProjectsComponentTest {
    private var gateway = InMemoryProjectsGateway();
    private val projects = DefaultProjectsComponent(
        gateway = gateway,
        projectFactory = ProjectFactory(idGenerator = IncrementalIdGenerator())
    )

    @Before
    fun before() {
        gateway.reset()
    }

    @Test
    fun canCreateAProject() {
        projects.create("Project X")

        assertEquals(1, projects.count())
    }

    @Test
    fun canCreateMultipleProjects() {
        val projectX = projects.create("Project X")
        val projectY = projects.create("Project Y")

        assertNotEquals(projectX.id.toString(), projectY.id.toString())
    }

    @Test
    fun canChangeAProjectName() {
        gateway.save(project = Project("Project X", ProjectId("1")))

        projects.changeName(ProjectId("1"), "Project XYZ")

        val project = projects.getProject(ProjectId("1"))
        assertEquals("Project XYZ", project.getName())
    }
}