package problems

import utils.Utils
import java.io.BufferedReader

const val LOSING_SCORE = 0
const val WINNING_SCORE = 6
const val DRAW_SCORE = 3

const val OUTCOME_DRAW = "Y"
const val OUTCOME_WIN = "Z"

class ProblemTwo: Problem {


    enum class Move {
        Rock,
        Paper,
        Scissors,
    }

    private fun moveScore(move: Move): Int = when (move) {
        Move.Rock -> 1
        Move.Paper -> 2
        Move.Scissors -> 3
    }

    private fun parseMove(moveStr: String): Move = when(moveStr) {
        "X","A" -> Move.Rock
        "Y","B" -> Move.Paper
        "Z","C" -> Move.Scissors
        else -> throw Error("Invalid Move")
    }

    private fun outcomeScore(myMove: Move, theirMove: Move): Int {
        if (myMove == theirMove) return DRAW_SCORE
        return when(myMove) {
            Move.Rock -> if (theirMove == Move.Scissors) WINNING_SCORE else LOSING_SCORE
            Move.Scissors -> if (theirMove == Move.Paper) WINNING_SCORE else LOSING_SCORE
            Move.Paper -> if (theirMove == Move.Rock) WINNING_SCORE else LOSING_SCORE
        }
    }

    override fun solutionA(): String {
        val reader = Utils.getInputReader("problem2")
        var totalScore = 0
        reader.forEachLine {
            val (theirMove, myMove) = it.split(" ").map { moveStr -> parseMove(moveStr) }
            totalScore += moveScore(myMove) + outcomeScore(myMove, theirMove)
        }
        reader.close()
        return totalScore.toString()
    }

    private fun moveNeeded(theirMove: Move, outCome: String): Move {
        if (outCome == OUTCOME_DRAW) {
            return theirMove
        }
        return when (theirMove) {
            Move.Rock -> if (outCome == OUTCOME_WIN) Move.Paper else Move.Scissors
            Move.Paper -> if (outCome == OUTCOME_WIN) Move.Scissors else Move.Rock
            Move.Scissors -> if (outCome == OUTCOME_WIN) Move.Rock else Move.Paper
        }
    }

    override fun solutionB(): String {
        val reader = Utils.getInputReader("problem2")
        var totalScore = 0
        reader.forEachLine {
            val (theirMoveStr, outcome)  = it.split(" ")
            val theirMove = parseMove(theirMoveStr)
            val myMove = moveNeeded(theirMove, outcome)
            totalScore += moveScore(myMove) + outcomeScore(myMove, theirMove)
        }
        reader.close()
        return totalScore.toString()
    }
}