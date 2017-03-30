package com.uottawa.tictactoe.GameLogic;

import java.util.Queue;

public class GameAI {

    int botDifficulty;

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
       // GameBoard game = (GameBoard) gameBoard.clone();
        int numberOfMovesToThinkAhead = botDifficulty * 2;

        Queue<GameMove> potentialMoves = game.findAllMoves();
        GameMove moveThatLeadsToMaxScore = potentialMoves.peek();
        int maxScore = -999999;
        for (GameMove potentialMove : potentialMoves) {
            GamePrediction prediction = calculateNextMove(game, potentialMove, numberOfMovesToThinkAhead);
            if (prediction.getScore() > maxScore) {
                maxScore = prediction.getScore();
                moveThatLeadsToMaxScore = prediction.getMove();
            }
        }

        return moveThatLeadsToMaxScore;

    }

    public GamePrediction calculateNextMove(GameBoard game, GameMove move, int depth) {

        if (depth <= 0) return new GamePrediction(null, 0);

        game.markPosition(move);
        if (!game.getState().equals(GameBoard.GameState.ONGOING)) {
            int score = finalGameScore(game, move.getMark());
            return new GamePrediction(move, score);
        }

        Queue<GameMove> potentialOpponentMoves = game.findAllMoves();
        int score = 0;
        for (GameMove potentialOpponentMove : potentialOpponentMoves) {
            // These are all the moves of our opponent. Our score is therefore the inverse
            score -= calculateNextMove(game, potentialOpponentMove, depth - 1).getScore();
        }

        return new GamePrediction(move, score);
    }

    public int finalGameScore(GameBoard game, GameBoard.Mark mark) {
        if (game.getState().equals(GameBoard.GameState.OWIN)) {
            if (mark.equals(GameBoard.GameState.OWIN)) return 1;
            else return -1;
        } else if (game.getState().equals(GameBoard.GameState.XWIN)) {
            if (mark.equals(GameBoard.GameState.XWIN)) return 1;
            else return -1;
        } else
            // A tie
            return 0;
    }

//    public static void  main(String[] args) {
//
//        GameBoard game = new GameBoard(3);
//        GameAI ai = new GameAI(2);
//
//        System.out.println("turn 1" + game.turn);
//        GameMove move = new GameMove(0,0, GameBoard.Mark.X);
//        game.markPosition(move);
//
//        System.out.println("turn 2" + game.turn);
//        GameMove aiMove = ai.calculateNextMove(game);
//        System.out.println(aiMove);
//        game.markPosition(aiMove);
//        System.out.println(aiMove);
//
//        move = new GameMove(1,1, GameBoard.Mark.X);
//        game.markPosition(move);
//
//        aiMove = ai.calculateNextMove(game);
//        game.markPosition(aiMove);
//        System.out.println(aiMove);
//
//    }
}


