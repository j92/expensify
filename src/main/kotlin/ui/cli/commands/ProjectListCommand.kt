package ui.cli.commands

import kotlinx.cli.ExperimentalCli
import kotlinx.cli.Subcommand
import project.ProjectsComponent
import ui.cli.output.Output

@ExperimentalCli
class ProjectListCommand(
    private val projectsComponent: ProjectsComponent,
    private val output: Output
) : Subcommand(
    name = "projects:list",
    actionDescription = "Displays a list of projects"
) {
    override fun execute() {
        val projects = projectsComponent.listProjects()

        for (project in projects) {
            output.writeLine("[${project.id}] ${project.getName()}")
        }
    }
}