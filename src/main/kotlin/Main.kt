import problems.*

fun main() {
    val problems: List<Problem> = listOf(
        ProblemOne(),
        ProblemTwo(),
        ProblemThree(),
        ProblemFour()
    )

    println("**********************")
    problems.forEachIndexed { index, problem ->
        println("Problem: ${index + 1}")
        println("Solution A: ${problem.solutionA()}")
        println("Solution B: ${problem.solutionB()}")
        println("**********************")
    }
}