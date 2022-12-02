enum class Play(val score: Int) {
    Rock(1),
    Paper(2),
    Scissors(3);

    fun getResult(player: Play): Result = when {
        this == player -> Result.Draw
        this == Rock && player != Paper -> Result.Win
        this == Scissors && player != Rock -> Result.Win
        this == Paper && player != Scissors -> Result.Win
        else -> Result.Lose
    }

    companion object {
        fun pickPlay(other: Play, neededResult: Result) = values()
            .filter { it.getResult(other) == neededResult }
            .maxBy { it.score }

        fun decodePlay(input: String): Play = when (input) {
            "A","X" -> Rock
            "B","Y" -> Paper
            "C","Z" -> Scissors
            else -> throw Exception("Not a valid play")
        }
    }
}

enum class Result(val score: Int) {
    Win(6),
    Draw(3),
    Lose(0);

    companion object {
        fun decodeResult(input: String): Result = when(input) {
            "X" -> Lose
            "Y" -> Draw
            "Z"-> Win
            else -> throw Exception("Not a valid result")
        }
    }
}

fun main() {

    fun part1(input: List<String>): Int {
        var sum = 0
        input.forEach { s ->
            val (other, you) = s.split(" ").map { Play.decodePlay(it) }
            sum += you.getResult(other).score + you.score
        }
        return sum
    }

    fun part2(input: List<String>): Int {
        var sum = 0
        input.forEach {
            val (otherStr, neededResultStr) = it.split(" ")
            val neededResult = Result.decodeResult(neededResultStr)
            sum += Play.pickPlay(Play.decodePlay(otherStr),neededResult).score + neededResult.score
        }
        return sum
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 15)
    check(part2(testInput) == 12)

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}
