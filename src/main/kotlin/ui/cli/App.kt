package com.joostvandriel.expensify.ui.cli

import ui.cli.commands.HelloWorldCommand
import kotlinx.cli.*

@ExperimentalCli
fun app(args: Array<String>) {
    val parser = ArgParser("expensify")
    parser.subcommands(HelloWorldCommand())
    parser.parse(args)
}