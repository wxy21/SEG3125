package com.uottawa.tictactoe.GameLogic;

public interface GameInterface {
    public GameBoard.Mark[][] resetGame();
    public GameBoard.Mark[][] markBoard(int xCoordinate, int yCoodinate);
    public boolean isPlayer1Turn();
    public boolean isGameFinished();
    public GameBoard.Mark[][] getGameBoard();
}
