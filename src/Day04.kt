
typealias AssignmentsPair = Pair<IntRange, IntRange>

fun getPair(input:String): AssignmentsPair  {
    val (one, two) = input.split(",").map { getAssignments(it) }
    return Pair(one, two)
}

fun getAssignments(input:String): IntRange {
    val (lower, upper) = input.split('-').map { it.toInt() }
    return lower..upper
}

fun doesFullyOverlap(pair: AssignmentsPair): Boolean {
    val (first,second ) = pair
    val firstOverlaps = (first.first <= second.first && second.last <= first.last )
    val secondOverlaps = (second.first <= first.first && first.last <= second.last)
    return firstOverlaps || secondOverlaps
}

fun doesOverlap(pair: AssignmentsPair): Boolean = pair.first.any { pair.second.contains(it) }


fun main() {
    val day = "Day04"

    val testOutputPart1 = 2
    fun part1(input: List<String>): Int = input.map { getPair(it) }.count { doesFullyOverlap(it) }

    val testOutputPart2 = 4
    fun part2(input: List<String>): Int = input.map { getPair(it) }.count { doesOverlap(it) }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("${day}_test")
    check(part1(testInput) == testOutputPart1)
    check(part2(testInput) == testOutputPart2)

    val input = readInput(day)
    println(part1(input))
    println(part2(input))
}