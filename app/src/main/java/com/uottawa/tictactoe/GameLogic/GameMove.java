package com.uottawa.tictactoe.GameLogic;

public class GameMove {

    private final int xCoordinate;
    private final int yCoordinate;
    private final GameBoard.Mark mark;

    public GameMove(int xCoordinate, int yCoordinate, GameBoard.Mark mark) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.mark = mark;
    }

    public int getXCoordinate() {
        return xCoordinate;
    }

    public int getYCoordinate() {
        return yCoordinate;
    }

    public GameBoard.Mark getMark() {
        return mark;
    }

    public String toString() {
        return "Move- x: " + xCoordinate + " y: " + yCoordinate + " mark: " + mark;
    }
}
