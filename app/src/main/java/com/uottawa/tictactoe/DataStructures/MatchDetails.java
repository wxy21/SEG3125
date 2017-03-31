package com.uottawa.tictactoe.DataStructures;

import com.uottawa.tictactoe.GameLogic.GameBoard;
import com.uottawa.tictactoe.GameLogic.GameMove;

import java.util.List;

public class MatchDetails {

    GameBoard.GameState result;
    List<GameMove> player1Moves;
    List<GameMove> player2Moves;

    public MatchDetails(GameBoard.GameState state, List<GameMove> player1Moves, List<GameMove> player2Moves){
        this.result = state;
        this.player1Moves = player1Moves;
        this.player2Moves = player2Moves;
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
}
