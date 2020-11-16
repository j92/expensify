package ui.cli

import kotlinx.cli.ArgParser
import kotlinx.cli.ExperimentalCli
import project.ProjectsComponent
import ui.cli.commands.HelloWorldCommand
import ui.cli.commands.ProjectCreateCommand
import ui.cli.commands.ProjectListCommand
import ui.cli.output.Output

@ExperimentalCli
fun app(args: Array<String>, output: Output, projectsComponent: ProjectsComponent) {
    val parser = ArgParser("expensify")

    val helloWorldCommand = HelloWorldCommand(output = output)
    val projectListCommand = ProjectListCommand(
        projectsComponent = projectsComponent,
        output = output
    )
    val projectCreateCommand = ProjectCreateCommand(
        projectsComponent= projectsComponent,
        output = output
    )

    parser.subcommands(helloWorldCommand, projectListCommand, projectCreateCommand)
    parser.parse(args)
}