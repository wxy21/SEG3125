package com.uottawa.tictactoe.GameLogic;

import com.uottawa.tictactoe.DataStorage.ApplicationSettings;
import com.uottawa.tictactoe.DataStructures.MatchDetails;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SinglePlayerGame implements GameInterface {

    int boardSize;
    int aiDifficulty;
    GameBoard gameBoard;

    List<GameMove> playerMove;
    List<GameMove> aiMove;

    public SinglePlayerGame(int boardSize, int aiDifficulty) {
        this.boardSize = boardSize;
        this.aiDifficulty = aiDifficulty;
        gameBoard = new GameBoard(boardSize);

        playerMove = new LinkedList<GameMove>();
        aiMove = new LinkedList<GameMove>();
    }

    public GameBoard.Mark[][] resetGame() {
        gameBoard = new GameBoard(boardSize);
        return gameBoard.getBoard();
    }

    public GameBoard.Mark[][] markBoard(int xCoordinate, int yCoordinate) {
        if (!gameBoard.isGameFinished() && isPlayer1Turn()) {
            GameMove playerNextMove = new GameMove(xCoordinate, yCoordinate, gameBoard.getTurn());
            gameBoard.markPosition(playerNextMove);
            playerMove.add(playerNextMove);
        }
        return gameBoard.getBoard();
    }

    public GameBoard.Mark[][] markBoardAI() {

        // Simulate the ai is thinking
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (!gameBoard.isGameFinished()) {
            GameAI gameAI = new GameAI(aiDifficulty);
            GameMove aiNextMove = gameAI.calculateNextMove(gameBoard);
            gameBoard.markPosition(aiNextMove);
            aiMove.add(aiNextMove);
        }

        return gameBoard.getBoard();
    }

    public boolean isPlayer1Turn() {
        if(gameBoard.getTurn().equals(GameBoard.Mark.X)) {
            return true;
        }
        return false;
    }

    public GameBoard.Mark[][] getGameBoard() {
        return gameBoard.getBoard();
    }

    public boolean isGameFinished() {
        return gameBoard.isGameFinished();
    }

    public MatchDetails getMatchDetails(String opponent) {
        MatchDetails details = new MatchDetails(gameBoard.getState(), playerMove, aiMove, opponent);
        return details;
    }
}
