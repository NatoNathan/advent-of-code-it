fun Char.getPriority(): Int =  when {
        this.isLowerCase() -> this.code -96
        this.isUpperCase() -> this.code - 38
        else -> throw Exception("Not a Letter")
    }

fun getHalfs(items: String): List<String> = items.chunked(items.length/2)

fun getErrorItem(items: List<String>): Char {
    val (one, two) = items
    return one.find { two.contains(it) }!!
}

fun getBadge(items: List<String>): Char {
    val (one, two, three) = items
    return one.find { two.contains(it) && three.contains(it) }!!
}

fun main() {
    val day = "Day03"

    val testOutputPart1 = 157
    fun part1(input: List<String>): Int = input.sumOf { getErrorItem(getHalfs(it)).getPriority() }

    val testOutputPart2 = 70
    fun part2(input: List<String>): Int = input.chunked(3).sumOf { getBadge(it).getPriority() }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("${day}_test")
    check(part1(testInput) == testOutputPart1)
    check(part2(testInput) == testOutputPart2)

    val input = readInput(day)
    println(part1(input))
    println(part2(input))
}