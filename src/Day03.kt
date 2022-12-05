fun main() {

    fun charToValue(c: Char): Int{
        val points = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
        return points.indexOf(c)+1
    }

    fun part1(input: List<String>): Int {
        var priorities = 0
        for(s in input){
            val firstCompartment = s.slice(IntRange(0,(s.length/2)-1)).toList()
            val secondCompartment = s.slice(IntRange(s.length/2,s.length-1)).toList()

            val common = firstCompartment.intersect(secondCompartment.toSet())
            val priority = common.sumOf { charToValue(it) }

            priorities+=priority
        }

        return priorities
    }

    fun part2(input: List<String>): Int {
        val chunks = input.chunked(3)
        var priorities = 0;
        for(chunk in chunks) {
            val common = chunk[0].toSet().intersect(chunk[1].toSet()).intersect(chunk[2].toSet())
            priorities += common.sumOf { charToValue(it) }
        }
        return priorities
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day03_test")
    check(part1(testInput) == 157)

    val input = readInput("Day03")
    println(part1(input))


    check(part2(testInput) == 70)
    println(part2(input))
}