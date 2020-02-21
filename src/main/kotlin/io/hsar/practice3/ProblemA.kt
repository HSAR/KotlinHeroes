package io.hsar.practice3

/*
https://codeforces.com/contest/1298/problem/A

Input:
201 101 101 200

Output:
1 100 100
 */
fun main() {
    val input = readLine()!!.split(" ")
            .map { inputSegment ->
                inputSegment.toInt()
            }

    val total = input.max()!!

    val pairwiseSums = input.minus(total)
            .sorted()

    val pairwiseDiffA = pairwiseSums[1] - pairwiseSums[0]
    val pairwiseDiffB = pairwiseSums[2] - pairwiseSums[1]
    val pairwiseDiffC = pairwiseSums[2] - pairwiseSums[0]

    // Sum of these pairwise differences yields 2C-2A
    val CminusA = (pairwiseDiffA + pairwiseDiffB + pairwiseDiffC) / 2
    val CplusA = pairwiseSums[1]

    val valC = (CplusA + CminusA) / 2
    val valA = CplusA - valC
    val valB = pairwiseSums[0] - valA
    println("${valA} ${valB} ${valC}")
}