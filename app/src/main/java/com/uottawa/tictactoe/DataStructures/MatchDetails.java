package com.uottawa.tictactoe.DataStructures;

import com.uottawa.tictactoe.GameLogic.GameBoard;
import com.uottawa.tictactoe.GameLogic.GameMove;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class MatchDetails {

    Date date;
    SimpleDateFormat dateFormat;
    GameBoard.GameState result;
    List<GameMove> player1Moves;
    List<GameMove> player2Moves;
    boolean markOfPlayer1WasX;
    String opponentName;

    public MatchDetails(GameBoard.GameState state, List<GameMove> player1Moves, List<GameMove> player2Moves, String opponentName){
        date = new Date();
        dateFormat = new SimpleDateFormat("dd/MM/yy");
        this.result = state;
        this.player1Moves = player1Moves;
        this.player2Moves = player2Moves;
        this.opponentName = opponentName;
    }

    public MatchDetails(long date, GameBoard.GameState state, List<GameMove> player1Moves, List<GameMove> player2Moves, String opponentName){
        this.date = new Date(date);
        dateFormat = new SimpleDateFormat("dd/MM/yy");
        this.result = state;
        this.player1Moves = player1Moves;
        this.player2Moves = player2Moves;
        this.opponentName = opponentName;
    }

    public GameBoard.GameState getResult() {
        return result;
    }

    public List<GameMove> getPlayer1Moves() {
        return player1Moves;
    }

    public List<GameMove> getPlayer2Moves() {
        return player2Moves;
    }

    public long getDate() {
        return date.getTime();
    }

    public String getDateAsString() {
        return dateFormat.format(date);
    }

    public String getOpponentName() {
        return opponentName;
    }
}
