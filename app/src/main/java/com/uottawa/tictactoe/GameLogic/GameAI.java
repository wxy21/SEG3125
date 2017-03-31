package com.uottawa.tictactoe.GameLogic;

import android.support.annotation.NonNull;

import java.util.Queue;

public class GameAI {

    int botDifficulty;
    int scorePerPredictedWin = 1;
    int scorePerWin = 10;

    private class GamePrediction {
        GameMove move;
        int score;

        public GamePrediction(GameMove move, int score) {
            this.move = move;
            this.score = score;
        }

        public int getScore() {
            return score;
        }

        public GameMove getMove() {
            return move;
        }

    }

    public GameAI(int difficulty) {
        botDifficulty = difficulty;
    }

    public GameMove calculateNextMove(GameBoard game) {
        int numberOfMovesToThinkAhead = botDifficulty * 2;

        return calculateNextMove(game, numberOfMovesToThinkAhead).getMove();

    }

    public GamePrediction calculateNextMove(GameBoard game, int depth) {

        Queue<GameMove> potentialMoves = game.findAllMoves();
        // If there are no more moves left simply return
        if (potentialMoves.size() <= 0) return new GamePrediction(null, 0);

        GameMove moveThatLeadsToMaxScore = potentialMoves.peek();
        int maxCurrentScore = -999999;
        GameBoard.Mark mark = potentialMoves.peek().getMark();

        // There are no more attempts to place a piece. Let's estimate the winner from here by how many ways we can place winning combinations.
        if (depth <= 0) {
            return predictGameResultFromNumberOfWinningCombinations(game, mark);
        }

        int totalScore = 0;
        for (GameMove potentialMove : potentialMoves) {
            GameBoard gameBoardToAnalyse = game.cloneGameBoard();
            gameBoardToAnalyse.markPosition(potentialMove);
            int moveScore = 0;

            if (!gameBoardToAnalyse.getState().equals(GameBoard.GameState.ONGOING)) {
                moveScore += finalPredictionScore(gameBoardToAnalyse, mark);
            }

            // These are all the moves of our opponent. Our score is therefore the inverse
            GamePrediction opponentMove = calculateNextMove(gameBoardToAnalyse, depth - 1);
            moveScore -= opponentMove.getScore();

            if (moveScore > maxCurrentScore) {
                maxCurrentScore = moveScore;
                moveThatLeadsToMaxScore = potentialMove;
            }

            totalScore += moveScore;
        }

        return new GamePrediction(moveThatLeadsToMaxScore, totalScore);
    }

    @NonNull
    private GamePrediction predictGameResultFromNumberOfWinningCombinations(GameBoard game, GameBoard.Mark mark) {
        int xCombinations = game.numberOfPotentialWinningCombinationsRemaining(GameBoard.Mark.X);
        int oCombinations = game.numberOfPotentialWinningCombinationsRemaining(GameBoard.Mark.O);

        if (xCombinations > oCombinations && mark.equals(GameBoard.Mark.X))
            return new GamePrediction(null, scorePerPredictedWin);
        if (xCombinations > oCombinations && mark.equals(GameBoard.Mark.O))
            return new GamePrediction(null, -scorePerPredictedWin);

        if (xCombinations < oCombinations && mark.equals(GameBoard.Mark.X))
            return new GamePrediction(null, -scorePerPredictedWin);
        if (xCombinations < oCombinations && mark.equals(GameBoard.Mark.O))
            return new GamePrediction(null, scorePerPredictedWin);

        // Tie
        return new GamePrediction(null, 0);
    }

    public int finalPredictionScore(GameBoard game, GameBoard.Mark mark) {
        if (game.getState().equals(GameBoard.GameState.OWIN)) {
            if (mark.equals(GameBoard.Mark.O)) return scorePerWin;
            else return -scorePerWin;
        } else if (game.getState().equals(GameBoard.GameState.XWIN)) {
            if (mark.equals(GameBoard.Mark.X)) return scorePerWin;
            else return -scorePerWin;
        } else
            // A tie
            return 0;
    }

//    // Test the AI
//    public static void main(String[] args) {
//
//        GameBoard game = new GameBoard(5);
//        GameAI ai = new GameAI(3);
//
//        while(!game.isGameFinished()) {
//
//            GameMove aiMove = ai.calculateNextMove(game);
//            System.out.println("**************************************");
//            game.markPosition(aiMove);
//            System.out.println(aiMove);
//            System.out.println(game);
//            System.out.println();
//        }
//    }
}


