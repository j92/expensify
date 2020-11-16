package com.joostvandriel.expensify.ui.cli.commands

import kotlinx.cli.ExperimentalCli
import kotlinx.cli.Subcommand

@ExperimentalCli
class HelloWorldCommand:Subcommand("hello", "Hello world command") {
    override fun execute() {
        println("Hello world!")
    }
}