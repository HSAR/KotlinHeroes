package io.hsar.practice3

/*
https://codeforces.com/contest/1298/problem/D

Input:
10 4
5 4 1 5 4 3 7 1 2 5
4 6
2 1
10 8
3 5

Output:
5 4 0 5 3 3 9 0 2 5
 */
fun main() {
    val (numberOfProgrammers, numberOfQuarrels) = readLine()!!
            .split(" ")
            .map { it.toInt() }
            .let { splitArray ->
                splitArray[0] to splitArray[1]
            }
    val skillLevels = readLine()!!
            .split(" ")
            .map { it.toInt() }
    val quarrels = (0..(numberOfQuarrels - 1))
            .map {
                readLine()!!
                        .split(" ")
                        .map { it.toInt() }
                        .let { splitArray ->
                            setOf(splitArray[0], splitArray[1])
                        }
            }

    val results = skillLevels
            .mapIndexed { index, skillLevel ->
                skillLevels
                        .mapIndexed { innerIndex, innerSkillLevel ->
                            if (innerIndex != index
                                    && skillLevel > innerSkillLevel // skill level is greater
                                    && quarrels.contains(setOf(index, innerIndex)))  // not in quarrel
                            {
                                index to innerIndex
                            } else {
                                null
                            }
                        }
                        .filterNotNull()
                        .count()
            }

    val result = results.joinToString(" ")
    println(result)
}