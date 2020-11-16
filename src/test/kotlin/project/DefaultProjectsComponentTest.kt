package project

import project.entities.Project
import project.entities.ProjectFactory
import project.entities.ProjectId
import project.entities.ProjectRate
import project.gateways.InMemoryProjectsGateway
import project.services.IncrementalIdGenerator
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals
import kotlin.test.assertNotNull

class DefaultProjectsComponentTest {
    private var gateway = InMemoryProjectsGateway();
    private val projects: ProjectsComponent = DefaultProjectsComponent(
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

    @Test
    fun canAssignHourlyRateToProject() {
        gateway.save(project = Project("Project X", ProjectId("1")))

        projects.assignRate(
            ProjectId("1"),
            rate = 75.50,
            start = "2020-11-15",
        )

        val project = projects.getProject(ProjectId("1"))
        assertNotNull(project.getCurrentRate())
    }

    @Test
    fun canGetCurrentRate() {
        gateway.save(project = Project("Project X", ProjectId("1")))

        projects.assignRate(
            ProjectId("1"),
            rate = 75.50,
            start = "2020-01-01"
        )

        val project = projects.getProject(ProjectId("1"))

        val currentRate = project.getCurrentRate()
        val expectedRate = ProjectRate.create(75.50, "2020-01-01")
        assertNotNull(currentRate)
        assertEquals(expectedRate.toString(), currentRate.toString())
    }

    @Test
    fun getCurrentRateReturnsCorrectRateGivenMultipleRates() {
        gateway.save(project = Project("Project X", ProjectId("1")))

        projects.assignRate(ProjectId("1"), rate = 75.50, start = "2020-01-01")
        projects.assignRate(ProjectId("1"), rate = 80.00, start = "2020-10-01")
        projects.assignRate(ProjectId("1"), rate = 77.50, start = "2020-05-01")

        val project = projects.getProject(ProjectId("1"))

        val currentRate = project.getCurrentRate()
        val expectedRate = ProjectRate.create(80.00, "2020-10-01")
        assertEquals(expectedRate.toString(), currentRate.toString())
    }

    @Test
    fun canGetListOfProjects() {
        gateway.save(project = Project("Project X", ProjectId("1")))
        gateway.save(project = Project("Project Y", ProjectId("2")))

        val projects = projects.listProjects()
        assertEquals(2, projects.size)
    }
}