fun main() {
    val day = "Day00"

    val testOutputPart1 = 0
    fun part1(input: List<String>): Int {
        TODO()
    }

    val testOutputPart2 = 0
    fun part2(input: List<String>): Int {
        TODO()
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("${day}_test")
    check(part1(testInput) == testOutputPart1)
    check(part2(testInput) == testOutputPart2)

    val input = readInput(day)
    println(part1(input))
    println(part2(input))
}