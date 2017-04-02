package com.uottawa.tictactoe.DataStorage;

import android.content.SharedPreferences;

import com.uottawa.tictactoe.DataStructures.MatchDetails;
import com.uottawa.tictactoe.GameLogic.GameBoard;
import com.uottawa.tictactoe.GameLogic.GameMove;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MatchHistory {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    int totalMatches = 0;
    List<MatchDetails> matchDetails;

    String keyTotalMatches = "totalMatches";
    String keyMatchId = "matchId";
    String keyMatchResult = "matchResult";
    String keyPlayer1 = "player1";
    String keyPlayer2 = "player2";
    String keyNumberOfMoves = "keyNumberOfMoves";
    String keyXCoordinate = "XCoordinate";
    String keyYCoordinate = "YCoordinate";
    String keyDate = "date";
    String keyOpponent = "opponent";

    public MatchHistory(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
        editor = sharedPreferences.edit();
        matchDetails = new LinkedList<>();
    }

    public void saveMatch(MatchDetails matchDetails) {

        GameBoard.GameState state = matchDetails.getResult();
        List<GameMove> player1Moves = matchDetails.getPlayer1Moves();
        List<GameMove> player2Moves = matchDetails.getPlayer2Moves();

        int matchId = totalMatches;

        // Increase the number of matches
        totalMatches++;
        editor.putInt(keyTotalMatches, totalMatches);

        // Record the matches status, moves by player 1 and the moves of the opponent
        editor.putString(keyMatchId + matchId + keyMatchResult, state.toString());
        editor.putInt(keyMatchId + matchId + keyPlayer1 + keyNumberOfMoves, player1Moves.size());
        for(GameMove move: player1Moves) {
            editor.putInt(keyMatchId + matchId + keyPlayer1 + keyXCoordinate, move.getXCoordinate());
            editor.putInt(keyMatchId + matchId + keyPlayer1 + keyXCoordinate, move.getXCoordinate());
        }

        editor.putInt(keyMatchId + matchId + keyPlayer2 + keyNumberOfMoves, player2Moves.size());
        for(GameMove move: player2Moves) {
            editor.putInt(keyMatchId + matchId + keyPlayer2 + keyXCoordinate, move.getXCoordinate());
            editor.putInt(keyMatchId + matchId + keyPlayer2 + keyXCoordinate, move.getXCoordinate());
        }

        // Put opponentName
        editor.putString(keyMatchId + matchId + keyOpponent, matchDetails.getOpponentName());

        // Put in the date
        editor.putLong(keyMatchId + matchId + keyDate, matchDetails.getDate());

        // Commit/Save the settings
        editor.commit();
        editor.apply();
    }

    public void loadMatches() {

        totalMatches = sharedPreferences.getInt(keyTotalMatches, totalMatches);

        for(int matchId = 0; matchId < totalMatches; matchId++){
            GameBoard.GameState matchResult = GameBoard.GameState.valueOf(sharedPreferences.getString(keyMatchId + matchId + keyMatchResult, GameBoard.GameState.TIE.toString()));

            List<GameMove> player1Moves = new LinkedList<GameMove>();
            int player1NumberOfMoves = sharedPreferences.getInt(keyMatchId + matchId + keyPlayer1 + keyNumberOfMoves, 0);
            for(int i = 0; i < player1NumberOfMoves; i++) {
                int xCoordinate = sharedPreferences.getInt(keyMatchId + matchId + keyPlayer1 + keyXCoordinate, 0);
                int yCoordinate = sharedPreferences.getInt(keyMatchId + matchId + keyPlayer2 + keyYCoordinate, 0);
                GameMove move = new GameMove(xCoordinate, yCoordinate, GameBoard.Mark.X);
                player1Moves.add(move);
            }

            List<GameMove> player2Moves = new LinkedList<GameMove>();
            int player2NumberOfMoves = sharedPreferences.getInt(keyMatchId + matchId + keyPlayer2 + keyNumberOfMoves, 0);
            for(int i = 0; i < player2NumberOfMoves; i++) {
                int xCoordinate = sharedPreferences.getInt(keyMatchId + matchId + keyPlayer2 + keyXCoordinate, 0);
                int yCoordinate = sharedPreferences.getInt(keyMatchId + matchId + keyPlayer2 + keyYCoordinate, 0);
                GameMove move = new GameMove(xCoordinate, yCoordinate, GameBoard.Mark.O);
                player2Moves.add(move);
            }

            long date = sharedPreferences.getLong(keyMatchId + matchId + keyDate, 0);

            String opponentName = sharedPreferences.getString(keyMatchId + matchId + keyOpponent, new String("Player 2"));

            MatchDetails newMatchDetail = new MatchDetails(date, matchResult, player1Moves, player2Moves, opponentName);
            matchDetails.add(newMatchDetail);
        }

    }

    public List<MatchDetails> getMatchDetails() {
        return matchDetails;
    }

}
