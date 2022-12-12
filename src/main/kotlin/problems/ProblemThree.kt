package problems

import utils.Utils

const val LOWER_DIFF = 96
const val HIGHER_DIFF = 38

class ProblemThree: Problem {
    // a - 97
    // z - 122
    // A - 65
    // Z- 90
    fun getValue(supply: Char): Int {
        return if (supply.isLowerCase()) supply.code - LOWER_DIFF else supply.code - HIGHER_DIFF
    }

    override fun solutionA(): String {
        val reader = Utils.getInputReader("problem3")
        var total = 0
        reader.forEachLine {
            val rucksack = it.toCharArray().toList()

            val firstCompartment = rucksack.subList(0, rucksack.size / 2)
            val secondCompartment = rucksack.subList(rucksack.size / 2, rucksack.size)

            val firstSet = mutableSetOf<Char>()
            firstCompartment.forEach { c -> firstSet.add(c) }

            var repeated: Char? = null
            secondCompartment.forEach { c ->
                if(firstSet.contains(c)) {
                    repeated = c
                }
            }

            total += getValue(repeated!!)
        }
        return total.toString()
    }

    override fun solutionB(): String {
        val reader = Utils.getInputReader("problem3")
        var groupCount = 0
        var carrySet = mutableSetOf<Char>()
        var total = 0
        reader.forEachLine { line ->
            val rucksack = line.toCharArray().toList()
            val uniqueItems = mutableSetOf<Char>()
            rucksack.forEach {
                uniqueItems.add(it)
            }
            groupCount++

            if (carrySet.isEmpty()) {
                carrySet.addAll(uniqueItems)
            } else {
                carrySet = carrySet.intersect(uniqueItems).toMutableSet()
            }

            if (groupCount == 3) {
                // set should be one thing
                total += getValue(carrySet.first())
                groupCount = 0
                carrySet = mutableSetOf()
            }

        }

        return total.toString()
    }
}