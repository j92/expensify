package ui.cli.commands

import kotlinx.cli.ExperimentalCli
import kotlinx.cli.Subcommand
import ui.cli.output.Output

@ExperimentalCli
class HelloWorldCommand(val output: Output) :Subcommand("hello", "Hello world command") {
    override fun execute() {
        output.writeLine("Hello world!");
    }
}