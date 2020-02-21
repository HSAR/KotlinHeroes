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

    val hypotheses = (0..busCapacity)
            .mapNotNull { hypothesis ->
                val validDeltas = overallDeltas
                        .map { eachDelta ->
                            val eachHypothesisDelta = hypothesis + eachDelta
                            if (eachHypothesisDelta >= 0 && eachHypothesisDelta <= busCapacity) {
                                1
                            } else {
                                0
                            }
                        }
                        .sum()
                if (validDeltas == overallDeltas.size) {
                    hypothesis
                } else {
                    null
                }
            }

    val result = hypotheses.count()
    println(result)
}