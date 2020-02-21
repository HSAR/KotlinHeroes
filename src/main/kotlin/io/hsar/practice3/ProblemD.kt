package io.hsar.practice3

/*
https://codeforces.com/contest/1298/problem/D

Input:
3 5
2 1 -3

Output:
3
 */
fun main() {
    val (numberOfStops, busCapacity) = readLine()!!
            .split(" ")
            .map { it.toInt() }
            .let { splitArray ->
                splitArray[0] to splitArray[1]
            }
    val capacityDeltas = readLine()!!
            .split(" ")
            .map { it.toInt() }

    val overallDeltas = capacityDeltas.fold(listOf(0)) { deltaProgression: List<Int>, capacityDelta ->
        deltaProgression + listOf(deltaProgression.last() + capacityDelta)
    }

    val minDelta = overallDeltas.min()!!
    val maxDelta = overallDeltas.max()!!

    val negDelta = if (minDelta <= 0) {
        minDelta
    } else {
        0
    }
    val posDelta = if (maxDelta >= 0) {
        maxDelta
    } else {
        0
    }

    val possibilities = busCapacity + 1
    val hypotheses = (possibilities + negDelta) - posDelta
    val result = if (-negDelta > busCapacity || posDelta > busCapacity || hypotheses < 0) {
        0
    } else {
        hypotheses
    }
    println(result)
}