fun main() {
    fun part1(input: List<String>): Int {
        var highest = 0
        var acc = 0
        for (s in input) {
            if (s.isEmpty()) {
                if (acc > highest) highest = acc
                acc = 0
            } else {
                val i = Integer.parseInt(s)
                acc += i
            }
        }
        return highest
    }

    fun part2(input: List<String>): Int {
        val sums = mutableListOf<Int>()

        var sum = 0
        for (s in input) {
            if (!s.isEmpty()) {
                sum += Integer.parseInt(s)
            } else {
                sums.add(sum)
                sum = 0
            }
        }
        sums.add(sum)

        return sums.sorted().reversed().slice(IntRange(0, 2)).sum()
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 24000)

    val input = readInput("Day01")
    println("part1: ${part1(input)}")
    println("part2: ${part2(input)}")
}
