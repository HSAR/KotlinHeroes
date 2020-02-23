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
fun findLessSkilled(skillsLookup: List<Pair<Int, Int>>, skillLevel: Int): Set<Int> {
    return skillsLookup
            .indexOfLast { (otherIndex, otherSkillLevel) ->
                otherSkillLevel < skillLevel
            }
            .let { skillsLookupIndex ->
                skillsLookup.subList(0, skillsLookupIndex + 1)
            }
            .toMap()
            .keys
}

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

    val quarrelsLookup = skillLevels
            .mapIndexed { index, _ -> index + 1 to mutableSetOf<Int>() }
            .toMap()
    // fill in quarrels
    quarrels.forEach { quarrel ->
        val personA = quarrel[0]
        val personB = quarrel[1]
        quarrelsLookup[personA]!!.add(personB)
        quarrelsLookup[personB]!!.add(personA)
    }
    val skillsLookup = skillLevels
            .mapIndexed { index, skillLevel ->
                index + 1 to skillLevel
            }
            .sortedBy { (_, skillLevel) -> skillLevel }

    val results = skillLevels
            .mapIndexed { index, skillLevel ->
                findLessSkilled(skillsLookup, skillLevel)
                        .minus(quarrelsLookup.getValue(index + 1))
                        .size
            }

    val result = results.joinToString(" ")
    println(result)
}