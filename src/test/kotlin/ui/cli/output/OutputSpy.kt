package ui.cli.output

class OutputSpy:Output {
    private val lines: MutableList<String> = mutableListOf()

    override fun writeLine(line: String) {
        lines.add(line.trim())
    }

    fun clear() {
        lines.clear()
    }

    fun lines(): List<String> {
        return lines.toList()
    }

    override fun toString(): String {
        return "OutputSpy(lines=$lines)"
    }
}