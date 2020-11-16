package ui.cli

import kotlinx.cli.ArgParser
import kotlinx.cli.ExperimentalCli
import project.ProjectsComponent
import ui.cli.commands.HelloWorldCommand
import ui.cli.commands.ProjectListCommand
import ui.cli.output.Output

@ExperimentalCli
fun app(args: Array<String>, output: Output, projectsComponent: ProjectsComponent) {
    val parser = ArgParser("expensify")
    parser.subcommands(HelloWorldCommand(output = output))
    parser.subcommands(ProjectListCommand(
        projectsComponent = projectsComponent,
        output = output
    ))
    parser.parse(args)
}