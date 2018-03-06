package edu.up.cs301.pig;

import edu.up.cs301.game.infoMsg.GameState;

/**
 * Created by lieu18 on 3/6/2018.
 */

public class PigGameState extends GameState {
    private int turn; // 0 -> player 0, 1 -> player 1
    private int p0Score;
    private int p1Score;
    private int curTotal;
    private int curDiceValue;

    public PigGameState() {
        turn = 0;
        p0Score = 0;
        p1Score = 0;
        curTotal = 0;
        curDiceValue = 1;
    }

    // copy constructor
    public PigGameState(PigGameState g) {
        this.turn = g.turn;
        this.p0Score = g.p0Score;
        this.p1Score = g.p1Score;
        this.curTotal = g.curTotal;
        this.curDiceValue = g.curDiceValue;
    }

    public int getTurn() {
        return this.turn;
    }

    public int getP0Score() {
        return p0Score;
    }

    public int getP1Score() {
        return p1Score;
    }

    public int getCurTotal() {
        return curTotal;
    }

    public int getCurDiceValue() {
        return curDiceValue;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public void setP0Score(int p0Score) {
        this.p0Score = p0Score;
    }

    public void setP1Score(int p1Score) {
        this.p1Score = p1Score;
    }

    public void setCurTotal(int curTotal) {
        this.curTotal = curTotal;
    }

    public void setCurDiceValue(int curDiceValue) {
        this.curDiceValue = curDiceValue;
    }
}