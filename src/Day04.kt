fun main() {
    fun part1(input: List<String>): Int {
        var pairsFullyContained = 0
        for (s in input) {
            val pattern = "(\\d*)-(\\d*),(\\d*)-(\\d*)".toRegex()
            val match = pattern.find(s) ?: return -1

            val range1 = match.groupValues[1].toInt()..match.groupValues[2].toInt()
            val range2 = match.groupValues[3].toInt()..match.groupValues[4].toInt()
            val intersect = range1.intersect(range2)

            if (intersect == range1.toSet() || intersect == range2.toSet()) {
                pairsFullyContained++
            }
        }
        return pairsFullyContained
    }

    fun part2(input: List<String>): Int {
        var pairsOverlapping = 0

        for (s in input) {
            val pattern = "(\\d*)-(\\d*),(\\d*)-(\\d*)".toRegex()
            val match = pattern.find(s) ?: return -1

            val range1 = match.groupValues[1].toInt()..match.groupValues[2].toInt()
            val range2 = match.groupValues[3].toInt()..match.groupValues[4].toInt()
            val intersect = range1.intersect(range2)

            if (intersect.isNotEmpty()){
                println("pair overlapping: $s")
                pairsOverlapping++
            }
        }
        return pairsOverlapping
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day04_test")
    check(part1(testInput) == 2)

    val input = readInput("Day04")
    println("part 1: " + part1(input))

    check(part2(testInput) == 4)
    println("part 2: " + part2(input))
}