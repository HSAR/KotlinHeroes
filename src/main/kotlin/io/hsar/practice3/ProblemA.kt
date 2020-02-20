package io.hsar.practice3

import kotlin.system.exitProcess

sealed class TestResult {
    class Failure : TestResult()
    class Success(val values: Triple<Int, Int, Int>) : TestResult()
}

fun testPairwiseSums(pairwiseSums: Triple<Int, Int, Int>, valA: Int): TestResult {
    val valB = pairwiseSums.first - valA
    val valC = pairwiseSums.third - valB

    return if ((pairwiseSums.second - valC) == valA) {
        TestResult.Success(Triple(valA, valB, valC))
    } else {
        TestResult.Failure()
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
            .let { list ->
                Triple(list[0], list[1], list[2])
            }

    val searchLimit = (total / 3) + 1 // the furthest we will need to search is one-third of the total
    for (valA in 1..searchLimit) {
        val result = testPairwiseSums(pairwiseSums, valA)
        if (result is TestResult.Success) {
            println("${result.values.first} ${result.values.second} ${result.values.third}")
            exitProcess(0)
        }
    }

    println("Failure to find correct values.")
}