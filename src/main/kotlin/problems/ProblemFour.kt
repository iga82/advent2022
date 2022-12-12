package problems

import utils.Utils

class ProblemFour: Problem {
    private fun rangeContained(left: List<Int>, right: List<Int>) =
        left[0] >= right[0] && left[1] <= right[1]

    override fun solutionA(): String {
        val reader = Utils.getInputReader("problem4")
        var total = 0
        reader.forEachLine { line ->
            val ranges = line.split(",").map { range ->
                range.split("-").map { it.toInt() }
            }
            if (rangeContained(ranges[0], ranges[1]) || rangeContained(ranges[1], ranges[0])) {
                total++
            }
        }
        return total.toString()
    }

    private fun oneIsContained(left: List<Int>, right: List<Int>): Boolean {
        val (leftMin, leftMax) = left
        val (rightMin, rightMax) = right

        return (leftMin >= rightMin && leftMax <= rightMax) ||
                (leftMax >= rightMin && leftMin <= rightMax)

    }

    override fun solutionB(): String {
        val reader = Utils.getInputReader("problem4")
        var total = 0
        reader.forEachLine { line ->
            val ranges = line.split(",").map { range ->
                range.split("-").map { it.toInt() }
            }

            if (oneIsContained(ranges[0], ranges[1]) || oneIsContained(ranges[1], ranges[0])) {
                total++
            }
        }
        return total.toString()
    }
}