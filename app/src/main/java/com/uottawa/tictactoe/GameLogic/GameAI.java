package com.uottawa.tictactoe.GameLogic;

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
        GameBoard gameBoardToAnalyse = game.cloneGameBoard();
        int numberOfMovesToThinkAhead = botDifficulty * 2 - 1;

        Queue<GameMove> potentialMoves = gameBoardToAnalyse.findAllMoves();
        GameMove moveThatLeadsToMaxScore = potentialMoves.peek();
        int maxScore = -999999;
        for (GameMove potentialMove : potentialMoves) {
            GamePrediction prediction = calculateNextMove(gameBoardToAnalyse, potentialMove, numberOfMovesToThinkAhead);
            if (prediction.getScore() > maxScore) {
                maxScore = prediction.getScore();
                moveThatLeadsToMaxScore = prediction.getMove();
            }
        }

        return moveThatLeadsToMaxScore;

    }

    public GamePrediction calculateNextMove(GameBoard game, GameMove move, int depth) {

        GameBoard gameBoardToAnalyse = game.cloneGameBoard();
        gameBoardToAnalyse.markPosition(move);

        if (!gameBoardToAnalyse.getState().equals(GameBoard.GameState.ONGOING)) {
            int score = finalPredictionScore(gameBoardToAnalyse, move.getMark());
            return new GamePrediction(move, score);
        }

        if (depth <= 0) {
            int xCombinations = gameBoardToAnalyse.numberOfPotentialWinningCombinationsRemaining(GameBoard.Mark.X);
            int oCombinations = gameBoardToAnalyse.numberOfPotentialWinningCombinationsRemaining(GameBoard.Mark.O);

            if (xCombinations > oCombinations && move.getMark().equals(GameBoard.Mark.X))
                return new GamePrediction(null, scorePerPredictedWin);
            if (xCombinations > oCombinations && move.getMark().equals(GameBoard.Mark.O))
                return new GamePrediction(null, -scorePerPredictedWin);

            if (xCombinations < oCombinations && move.getMark().equals(GameBoard.Mark.X))
                return new GamePrediction(null, -scorePerPredictedWin);
            if (xCombinations < oCombinations && move.getMark().equals(GameBoard.Mark.O))
                return new GamePrediction(null, scorePerPredictedWin);

            // Tie
            return new GamePrediction(null, 0);
        }

        Queue<GameMove> potentialOpponentMoves = gameBoardToAnalyse.findAllMoves();
        int score = 0;
        for (GameMove potentialOpponentMove : potentialOpponentMoves) {
            // These are all the moves of our opponent. Our score is therefore the inverse
            score -= calculateNextMove(gameBoardToAnalyse, potentialOpponentMove, depth - 1).getScore();
        }

        return new GamePrediction(move, score);
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

//    public static void main(String[] args) {
//
//        GameBoard game = new GameBoard(3);
//        GameAI ai = new GameAI(2);
//
//        GameMove move = new GameMove(0,0, GameBoard.Mark.X);
//        System.out.println(move);
//        game.markPosition(move);
//
////        while(!game.isGameFinished()) {
////
////            GameMove aiMove = ai.calculateNextMove(game);
////            System.out.println("**************************************");
////            game.markPosition(aiMove);
////            System.out.println(aiMove);
////            System.out.println(game);
////            System.out.println();
////        }
//
//        move = new GameMove(1,1, GameBoard.Mark.O);
//        System.out.println(move);
//        game.markPosition(move);
//
//        System.out.println(game);
//
//        move = new GameMove(0,2, GameBoard.Mark.X);
//        System.out.println(move);
//        game.markPosition(move);
//
//        System.out.println(game);
//
//        move = new GameMove(0,1, GameBoard.Mark.O);
//        System.out.println(move);
//        game.markPosition(move);
//
//        System.out.println(game);
//
//        GameMove aiMove = ai.calculateNextMove(game);
//        System.out.println(aiMove);
//        game.markPosition(aiMove);
//
//        System.out.println(game);
//    }
}


