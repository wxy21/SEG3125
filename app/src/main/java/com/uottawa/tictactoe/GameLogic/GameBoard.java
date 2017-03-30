package com.uottawa.tictactoe.GameLogic;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

public class GameBoard {

    public enum Mark {
        EMPTY,
        X,
        O
    };

    public enum GameState {
        XWIN,
        OWIN,
        TIE,
        ONGOING
    }

    Mark[][] board;
    Mark turn;
    GameState state;

    public GameBoard(int rowSize) {
        board = new Mark[rowSize][rowSize];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = Mark.EMPTY;
            }
        }

        turn = Mark.X;
        state = GameState.ONGOING;
    }

    public boolean markPosition(GameMove move) {

        if (turn.equals(move.getMark()) && board[move.getXCoordinate()][move.getYCoordinate()].equals(Mark.EMPTY)) {
            board[move.getXCoordinate()][move.getYCoordinate()] = move.getMark();
            if (turn == Mark.X) turn = Mark.O;
            else if (turn == Mark.O) turn = Mark.X;
            isGameFinished();
            return true;
        } else {
            return false;
        }

    }

    /**
     * Verify if there are any rows, columns or if the main diagonal have matching marks. If so, a winner was decided.
     *
     * @return
     */
    public boolean isGameFinished() {
        if (isRowWinning()) return true;
        if (isColumnWinning()) return true;
        if (isADiagonalWinning()) return true;
        if (isGameATie()) return true;

        return false;
    }

    private boolean isRowWinning() {
        // Check all the rows for matching marks
        for (int row = 0; row < board.length; row++) {
            Boolean rowIsWinner = true;
            Mark winningMark = board[row][0];

            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] != winningMark) {
                    rowIsWinner = false;
                }
            }

            if (rowIsWinner && winningMark != Mark.EMPTY) {
                if (winningMark == Mark.X) state = GameState.XWIN;
                else if (winningMark == Mark.O) state = GameState.OWIN;
                return true;
            }
        }
        return false;
    }

    private boolean isColumnWinning() {
        // Check all the columns for matching marks
        for (int col = 0; col < board[0].length; col++) {
            Boolean colIsWinner = true;
            Mark winningMark = board[0][col];

            for (int row = 0; row < board.length; row++) {
                if (board[row][col] != winningMark) {
                    colIsWinner = false;
                }
            }

            if (colIsWinner && winningMark != Mark.EMPTY) {
                if (winningMark == Mark.X) state = GameState.XWIN;
                else if (winningMark == Mark.O) state = GameState.OWIN;
                return true;
            }
        }
        return false;
    }

    private boolean isADiagonalWinning() {
        // Check the two main diagonals for matching marks
        Boolean diag1IsWinner = true;
        Mark winningMarkDiag1 = board[0][0];
        Boolean diag2IsWinner = true;
        Mark winningMarkDiag2 = board[0][board.length - 1];

        for (int diag = 0; diag < board.length; diag++) {
            if (board[diag][diag] != winningMarkDiag1) {
                diag1IsWinner = false;
            } else if (board[diag][board.length - 1 - diag] != winningMarkDiag2) {
                diag2IsWinner = false;
            }
        }

        if (diag1IsWinner && winningMarkDiag1 != Mark.EMPTY) {
            if (winningMarkDiag1 == Mark.X) state = GameState.XWIN;
            else if (winningMarkDiag1 == Mark.O) state = GameState.OWIN;
            return true;
        } else if (diag2IsWinner && winningMarkDiag2 != Mark.EMPTY) {
            if (winningMarkDiag2 == Mark.X) state = GameState.XWIN;
            else if (winningMarkDiag2 == Mark.O) state = GameState.OWIN;
            return true;
        }
        return false;
    }

    public Queue<GameMove> findAllMoves() {
        Queue<GameMove> potentialMoves = new LinkedBlockingQueue<GameMove>();
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if(board[row][col].equals(Mark.EMPTY)) potentialMoves.add(new GameMove(row, col, turn));
            }
        }
        return potentialMoves;
    }

    private boolean isGameATie() {
        // Check if the game is a tie
        boolean gameIsATie = true;
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if(board[row][col] == Mark.EMPTY) gameIsATie = false;
            }
        }
        if (gameIsATie) state = GameState.TIE;
        return gameIsATie;
    }

    public GameState getState() {
        return state;
    }

}
