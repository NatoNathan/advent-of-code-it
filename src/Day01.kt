fun main() {

    fun getElivs(input: List<String>): List<Int> {
        val elivs = mutableListOf<Int>()
        var current = 0
        input.forEach {
            when (it) {
                "" -> {
                    elivs.add(current)
                    current = 0
                }

                else -> current += it.toInt()
            }
        }
        elivs.add(current)
        return elivs
    }

    fun part1(input: List<String>): Int {
        return getElivs(input).max()
    }

    fun part2(input: List<String>): Int {
        return getElivs(input).sortedDescending().take(3).sum()
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 24000)
    check(part2(testInput) == 45000)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
