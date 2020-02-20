package io.hsar.practice3

fun main() {
    val arrayLength = readLine()!!
    val array = readLine()!!.split(" ")
            .map { inputSegment ->
                inputSegment.toInt()
            }

    array
            .toSet()
            .toTypedArray()
            .let { dedupedArray ->
                println(dedupedArray.size)
                println(dedupedArray.joinToString(" "))
            }
}