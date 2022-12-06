fun main() {

    fun getTestPuzzle(): List<MutableList<String>> {
        return listOf(
            mutableListOf("Z", "N"),
            mutableListOf("M", "C", "D"),
            mutableListOf("P")
        )
    }

    fun getPuzzle(): List<MutableList<String>> {
        return listOf(
            mutableListOf("Z", "J", "N", "W", "P", "S"),
            mutableListOf("G", "S", "T"),
            mutableListOf("V", "Q", "R", "L", "H"),
            mutableListOf("V", "S", "T", "D"),
            mutableListOf("Q", "Z", "T", "D", "B", "M", "J"),
            mutableListOf("M", "W", "T", "J", "D", "C", "Z", "L"),
            mutableListOf("L", "P", "M", "W", "G", "T", "J"),
            mutableListOf("N", "G", "M", "T", "B", "F", "Q", "H"),
            mutableListOf("R", "D", "G", "C", "P", "B", "Q", "W")
        )
    }

    fun part1(puzzle: List<MutableList<String>>, input: List<String>): String {
        val it = input.iterator()
        while (it.hasNext() && !it.next().isEmpty()) {
        }

        while (it.hasNext()) {
            val line = it.next()
            val pattern = "move (\\d*) from (\\d*) to (\\d*)".toRegex()
            val match = pattern.find(line) ?: return ""

            val number = match.groupValues[1].toInt()
            val from = match.groupValues[2].toInt() - 1
            val to = match.groupValues[3].toInt() - 1

            val temp = mutableListOf<String>()
            for (i in 1..number) {
                val rem = puzzle[from].removeLast()
                temp.add(rem)
            }

            for (s in temp) {
                puzzle[to].add(s)
            }

        }

        var string = ""
        for (list in puzzle) {
            string += list.last()
        }

        return string
    }

    fun part2(puzzle: List<MutableList<String>>, input: List<String>): String {
        val it = input.iterator()
        while (it.hasNext() && !it.next().isEmpty()) {
        }

        while (it.hasNext()) {
            val line = it.next()
            val pattern = "move (\\d*) from (\\d*) to (\\d*)".toRegex()
            val match = pattern.find(line) ?: return ""

            val number = match.groupValues[1].toInt()
            val from = match.groupValues[2].toInt() - 1
            val to = match.groupValues[3].toInt() - 1

            val temp = mutableListOf<String>()
            for (i in 1..number) {
                val rem = puzzle[from].removeLast()
                temp.add(rem)
            }

            for (s in temp.reversed()) {
                puzzle[to].add(s)
            }

        }

        var string = ""
        for (list in puzzle) {
            string += list.last()
        }

        return string
    }


    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day05_test")
    check(part1(getTestPuzzle(), testInput) == "CMZ")

    val input = readInput("Day05")

    println("part 1: " + part1(getPuzzle(), input))

    check(part2(getTestPuzzle(), testInput) == "MCD")



    println("part 2: " + part2(getPuzzle(), input))
}