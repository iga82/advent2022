package problems

import utils.Utils

object ProblemOne {
    private val reader = Utils.getInputReader("problem1a")

    fun aSolution() {
        val allDearCalories = mutableListOf<List<Int>>()
        var currentDear = mutableListOf<Int>()
        reader.forEachLine {
            if (it == "") {
                allDearCalories.add(currentDear)
                currentDear = mutableListOf()
            } else {
                currentDear.add(it.toInt())
            }
        }

        val top3 = allDearCalories.map { dearCalories ->
            dearCalories.reduce { acc, next -> acc + next }
        }.sortedDescending().subList(0, 3)


        println(top3.reduce { acc, next -> acc + next })
    }
}