package ui.cli.commands

import kotlinx.cli.ArgType
import kotlinx.cli.ExperimentalCli
import kotlinx.cli.Subcommand
import kotlinx.cli.vararg

@ExperimentalCli
class Summary: Subcommand("summary", "Calculate summary") {
    val invert by option(ArgType.Boolean, "invert", "i", "Invert results")
    val addendums by argument(ArgType.Int, "addendums", description = "Addendums").vararg()
    var result: Int = 0

    override fun execute() {
        result = addendums.sum()
        result = if (invert!!) -1 * result else result
        println(result)
    }
}