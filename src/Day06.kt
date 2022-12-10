fun main() {
    fun part1(input: String): Int {
        for (i in 0..input.length) {
            var sub = ""
            for (y in i..i + 3) {
                val char = input[y]
                if (sub.contains(char)) break
                sub += input[y]
                if (sub.length == 4) return y + 1
            }
        }
        return 0
    }

    fun part2(input: String): Int {
        for (i in 0..input.length) {
            var sub = ""
            for (y in i..i + 13) {
                val char = input[y]
                if (sub.contains(char)) break
                sub += input[y]
                if (sub.length == 14) return y + 1
            }
        }
        return 0
    }


    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day06_test")
    val testMap = mapOf(
        "mjqjpqmgbljsphdztnvjfqwrcgsmlb" to 7,
        "bvwbjplbgvbhsrlpgdmjqwftvncz" to 5,
        "nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg" to 10,
        "zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw" to 11
    )

    testMap.forEach { testString, i ->
        val res = part1(testString)
        //println("$testString became $res")
        check(part1(testString) == i)
    }

    val input = readInput("Day06").first()

    println("part 1: " + part1(input))

    val test2Map = mapOf(
        "mjqjpqmgbljsphdztnvjfqwrcgsmlb" to 19,
        "bvwbjplbgvbhsrlpgdmjqwftvncz" to 23,
        "nppdvjthqldpwncqszvftbrmjlhg" to 23,
        "nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg" to 29,
        "zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw" to 26
    )

    test2Map.forEach { testString, i ->
        val res = part2(testString)
        println("$testString became $res")
        check(res == i)
    }
    println("part 2: " + part2(input))
}