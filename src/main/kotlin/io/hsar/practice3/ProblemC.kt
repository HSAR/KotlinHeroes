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
    val fileLength = readLine()!!
    val fileName = readLine()!!

    val charsToRemove = fileName
            .split(Regex("[^xX]+")) // split the array by non-X characters: XXXAAAXXX -> [XXX, XXX]
            .map { eachRunOfXs ->
                val length = eachRunOfXs.length
                if (length >= 3) {
                    length - 2
                } else {
                    0
                }
            }
            .sum()

    println(charsToRemove)
}