package ui.cli

import kotlinx.cli.ExperimentalCli
import org.junit.Before
import org.junit.Test
import project.DefaultProjectsComponent
import project.entities.ProjectFactory
import project.gateways.InMemoryProjectsGateway
import project.services.IncrementalIdGenerator
import ui.cli.output.OutputSpy
import java.lang.Error

@ExperimentalCli
class CliAppTest {
    private val output = OutputSpy()

    @Before
    fun before() {
        output.clear()
    }

    @Test
    fun runsHelloWorld() {
        val projectsComponent = DefaultProjectsComponent(
            gateway = InMemoryProjectsGateway(),
            projectFactory = ProjectFactory(
                idGenerator = IncrementalIdGenerator()
            )
        )

        app(
            args = arrayOf("hello"),
            projectsComponent = projectsComponent,
            output = output
        )

        assertOutputContains("Hello world!")
    }

    @Test
    fun runsProjectsList() {
        val factory = ProjectFactory(IncrementalIdGenerator())
        val gateway = InMemoryProjectsGateway()
        gateway.save(factory.newProject("Project X"))
        gateway.save(factory.newProject("Project Y"))

        val projectsComponent = DefaultProjectsComponent(
            gateway = gateway,
            projectFactory = ProjectFactory(
                idGenerator = IncrementalIdGenerator()
            )
        )

        app(
            args = arrayOf("projects:list"),
            projectsComponent = projectsComponent,
            output = output
        )

        assertOutputContains("[1] Project X")
        assertOutputContains("[2] Project Y")
    }

    private fun assertOutputContains(line: String) {
        val lines = output.lines()
        if (!lines.contains(line)) {
            throw Error("Output did not contain line: $line. Output was $lines")
        }
    }
}