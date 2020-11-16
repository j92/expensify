package project.entities

class Project(private var name: String, val id: ProjectId) {
    private var rates: MutableList<ProjectRate> = mutableListOf()

    fun changeName(newName: String) {
        name = newName
    }

    fun getName(): String {
        return name
    }

    fun getCurrentRate(): ProjectRate? {
        return if (rates.size > 0) rates.first() else null
    }

    fun assignRate(projectRate: ProjectRate) {
        rates.add(projectRate)
        rates.sortByDescending { it.start }
    }
}