package ui.cli.output

class DefaultOutput: Output {
    override fun writeLine(line: String) {
        println(line)
    }
}