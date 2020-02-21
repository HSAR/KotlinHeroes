package io.hsar.practice3

/*
https://codeforces.com/contest/1298/problem/C

Input:
6
xxxiii

Output:
1
 */
fun main() {
    val arrayLength = readLine()!!
    val array = readLine()!!.split(" ")
            .map { inputSegment ->
                inputSegment.toInt()
            }

    array
            .foldRight(emptyList()) { item, accumulator: List<Int> ->
                if (!accumulator.contains(item)) {
                    listOf(item) + accumulator // reversed accumulation
                } else {
                    accumulator
                }
            }
            .let { dedupedArray ->
                println(dedupedArray.size)
                println(dedupedArray.joinToString(" "))
            }
}