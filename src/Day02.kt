enum class Moves(val score: Int) {
    Rock(1), Paper(2), Scissors(3);
}

enum class Results(val points: Int) {
    Win(6), Tie(3), Loss(0)
}

fun toMove(s: String): Moves {
    return when (s) {
        "A", "X" -> Moves.Rock
        "B", "Y" -> Moves.Paper
        else -> Moves.Scissors
    }
}

fun toResult(s:String): Results{
    return when (s) {
        "X" -> Results.Loss
        "Y" -> Results.Tie
        else -> Results.Win
    }
}

fun fight(theirMove: Moves, myMove: Moves): Int {
    return when (theirMove) {
        Moves.Rock -> when (myMove) {
            Moves.Rock -> Results.Tie.points
            Moves.Paper -> Results.Win.points
            Moves.Scissors -> Results.Loss.points
        }
        Moves.Paper -> when (myMove) {
            Moves.Rock -> Results.Loss.points
            Moves.Paper -> Results.Tie.points
            Moves.Scissors -> Results.Win.points
        }
        Moves.Scissors -> when (myMove) {
            Moves.Rock -> Results.Win.points
            Moves.Paper -> Results.Loss.points
            Moves.Scissors -> Results.Tie.points
        }
    }
}

fun calculateResult(theirMove: Moves, result: Results): Moves {
    return when (theirMove) {
        Moves.Rock -> return when (result) {
            Results.Win -> Moves.Paper
            Results.Loss -> Moves.Scissors
            Results.Tie -> Moves.Rock
        }
        Moves.Paper -> return when (result) {
            Results.Win -> Moves.Scissors
            Results.Loss -> Moves.Rock
            Results.Tie -> Moves.Paper
        }
        Moves.Scissors -> return when (result) {
            Results.Win -> Moves.Rock
            Results.Loss -> Moves.Paper
            Results.Tie -> Moves.Scissors
        }
    }
}


fun main() {
    fun part1(input: List<String>): Int {
        var sum = 0

        for (s in input) {
            val moves = s.split(" ")
            val theirMove = toMove(moves[0])
            val myMove = toMove(moves[1])
            val result = fight(theirMove, myMove)

            sum += myMove.score
            sum += result
        }

        println(sum)

        return sum
    }

    fun part2(input: List<String>): Int {
        var sum = 0

        for (s in input) {
            val moves = s.split(" ")
            println(moves)
            val theirMove = toMove(moves[0])
            val result = toResult(moves[1])

            val myMove = calculateResult(theirMove,result)

            sum+=myMove.score
            sum+= result.points
        }

        return sum
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 15)

    val input = readInput("Day02")
    println("part1: ${part1(input)}")

    check(part2(testInput) == 12)
    println("part2: ${part2(input)}")
}
