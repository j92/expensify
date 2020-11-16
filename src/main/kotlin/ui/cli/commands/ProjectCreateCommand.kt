package ui.cli.commands

import kotlinx.cli.*
import project.ProjectsComponent
import ui.cli.output.Output

@ExperimentalCli
class ProjectCreateCommand(
    private val projectsComponent: ProjectsComponent,
    private val output: Output
) : Subcommand(
    name = "projects:create",
    actionDescription = "Create a new project",
) {
    private val projectName by argument(ArgType.String, "name", "Project name")

    override fun execute() {
        val project = projectsComponent.create(name = projectName)

        output.writeLine("[${project.id}] ${project.getName()} created")
    }
}