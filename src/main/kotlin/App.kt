import kotlinx.cli.ExperimentalCli
import project.DefaultProjectsComponent
import project.entities.ProjectFactory
import project.gateways.InMemoryProjectsGateway
import project.services.IncrementalIdGenerator
import ui.cli.app
import ui.cli.output.DefaultOutput

@ExperimentalCli
fun main(args: Array<String>) {
    val projectsComponent = DefaultProjectsComponent(
        gateway = InMemoryProjectsGateway(),
        projectFactory = ProjectFactory(
            IncrementalIdGenerator()
        )
    )
    app(
        args = args,
        projectsComponent = projectsComponent,
        output = DefaultOutput()
    )
}