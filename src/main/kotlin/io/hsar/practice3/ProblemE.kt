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
    val quarrels = (0 until numberOfQuarrels)
            .map {
                readLine()!!
                        .split(" ")
                        .map { it.toInt() }
            }
    val quarrelsLookup = skillLevels.mapIndexed { index, _ -> index + 1 to mutableSetOf<Int>() }.toMap()
    // fill in quarrels
    quarrels.forEach { quarrel ->
        val personA = quarrel[0]
        val personB = quarrel[1]
        quarrelsLookup[personA]!!.add(personB)
        quarrelsLookup[personB]!!.add(personA)
    }

    val results = skillLevels
            .mapIndexed { index, skillLevel ->
                skillLevels
                        .mapIndexed { innerIndex, innerSkillLevel ->
                            if (innerIndex != index
                                    && skillLevel > innerSkillLevel // skill level is greater
                                    && !quarrelsLookup[index + 1]!!.contains(innerIndex + 1))  // not in quarrel
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