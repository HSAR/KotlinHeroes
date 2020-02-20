package io.hsar.practice3

/**
 * Returns a pair. The boolean indicates whether it was success, the list is the results.
 */
fun testPairwiseSums(pairwiseSums: List<Int>, valA: Int): Pair<Boolean, Array<Int>> {
    val valB = pairwiseSums[0] - valA
    val valC = pairwiseSums[2] - valB

    return if ((pairwiseSums[1] - valC) == valA) {
        true to arrayOf(valA, valB, valC)
    } else {
        false to emptyArray()
    }
}

fun main() {
    val input = readLine()!!.split(" ")
            .map { inputSegment ->
                inputSegment.toInt()
            }

    val total = input.max()!!

    val pairwiseSums = input.minus(total)
            .sorted()

    val searchLimit = (total / 3) + 1 // the furthest we will need to search is one-third of the total
    for (valA in 1..searchLimit) {
        val (result, values) = testPairwiseSums(pairwiseSums, valA)
        if (result) {
            println("${values[0]} ${values[1]} ${values[2]}")
        }
    }
}