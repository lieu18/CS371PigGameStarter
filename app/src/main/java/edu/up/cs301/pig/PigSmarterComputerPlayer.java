package edu.up.cs301.pig;


import edu.up.cs301.game.GameComputerPlayer;
import edu.up.cs301.game.infoMsg.GameInfo;

/**
 * Created by AnthonyLieu on 3/7/18.
 */

public class PigSmarterComputerPlayer extends GameComputerPlayer {

    public PigSmarterComputerPlayer(String name) {
        super(name);
    }

    protected void receiveInfo(GameInfo info) {
        PigGameState pigGame = (PigGameState) info;
        if (this.playerNum != pigGame.getTurn()) {
            return;
        }
        else {
            if (pigGame.getCurTotal() + pigGame.getP1Score() >= 50) {
                game.sendAction(new PigHoldAction(this));
            }
            else if (pigGame.getCurTotal() < 12) {
                game.sendAction(new PigRollAction(this));
            }
            else if (pigGame.getCurTotal() > 12) {
                game.sendAction(new PigHoldAction(this));
            }
            else if (pigGame.getP0Score() > pigGame.getP1Score()) {
                game.sendAction(new PigRollAction(this));
            }
            else if ((pigGame.getP0Score() >= 40) && (pigGame.getP1Score() < pigGame.getP0Score())) {
                game.sendAction(new PigRollAction(this));
            }
            else {
                game.sendAction(new PigHoldAction(this));
            }
        }
    }
}
