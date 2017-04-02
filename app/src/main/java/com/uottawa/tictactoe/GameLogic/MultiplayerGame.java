package com.uottawa.tictactoe.GameLogic;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MultiplayerGame implements GameInterface{

    int boardSize;
    GameBoard gameBoard;

    List<GameMove> player1Move;
    List<GameMove> player2Move;

    public MultiplayerGame(int boardSize) {
        this.boardSize = boardSize;
        gameBoard = new GameBoard(boardSize);

        player1Move = new LinkedList<GameMove>();
        player2Move = new LinkedList<GameMove>();
    }

    public GameBoard.Mark[][] resetGame() {
        gameBoard = new GameBoard(boardSize);
        return gameBoard.getBoard();
    }

    public GameBoard.Mark[][] markBoard(int xCoordinate, int yCoordinate) {
        if (!gameBoard.isGameFinished()) {
            GameMove playerNextMove = new GameMove(xCoordinate, yCoordinate, gameBoard.getTurn());
            gameBoard.markPosition(playerNextMove);
            if (isPlayer1Turn()) {
                player1Move.add(playerNextMove);
            } else {
                player2Move.add(playerNextMove);
            }
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

}
