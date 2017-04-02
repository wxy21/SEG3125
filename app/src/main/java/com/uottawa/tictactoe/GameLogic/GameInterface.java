package com.uottawa.tictactoe.GameLogic;

import com.uottawa.tictactoe.DataStructures.MatchDetails;

public interface GameInterface {
    public GameBoard.Mark[][] resetGame();
    public GameBoard.Mark[][] markBoard(int xCoordinate, int yCoodinate);
    public boolean isPlayer1Turn();
    public boolean isGameFinished();
    public GameBoard.Mark[][] getGameBoard();
    public MatchDetails getMatchDetails(String opponent);
}
