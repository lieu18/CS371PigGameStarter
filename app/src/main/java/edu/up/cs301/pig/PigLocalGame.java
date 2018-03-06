package edu.up.cs301.pig;

import edu.up.cs301.game.GamePlayer;
import edu.up.cs301.game.LocalGame;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.infoMsg.GameState;

import android.util.Log;

import java.util.Random;

/**
 * class PigLocalGame controls the play of the game
 *
 * @author Andrew M. Nuxoll, modified by Steven R. Vegdahl
 * @version February 2016
 */
public class PigLocalGame extends LocalGame {
    private PigGameState pigGame;
    /**
     * This ctor creates a new game state
     */
    public PigLocalGame() {
        pigGame = new PigGameState();
    }

    /**
     * can the player with the given id take an action right now?
     */
    @Override
    protected boolean canMove(int playerIdx) {
        if (playerIdx == pigGame.getTurn()) {
            return true;
        }
        else
            return false;
    }

    /**
     * This method is called when a new action arrives from a player
     *
     * @return true if the action was taken or false if the action was invalid/illegal.
     */
    @Override
    protected boolean makeMove(GameAction action) {
        if (action instanceof PigHoldAction) {
            if (pigGame.getTurn() == 0) {
                pigGame.setP0Score(pigGame.getCurTotal() + pigGame.getP0Score());
                pigGame.setTurn(1);
            }
            else if (pigGame.getTurn() == 1) {
                pigGame.setP1Score(pigGame.getCurTotal() + pigGame.getP1Score());
                pigGame.setTurn(0);
            }
            pigGame.setCurTotal(0);
            return true;
        }
        else if (action instanceof PigRollAction) {
            Random gen = new Random();
            pigGame.setCurDiceValue(gen.nextInt(6) + 1);

            if (pigGame.getCurDiceValue() == 1) {
                pigGame.setCurTotal(0);
                if (pigGame.getTurn() == 0) {
                    pigGame.setTurn(1);
                }
                else if (pigGame.getTurn() == 1) {
                    pigGame.setTurn(0);
                }
            }
            else {
                pigGame.setCurTotal(pigGame.getCurTotal() + pigGame.getCurDiceValue());
            }
            return true;
        }
        else
            return false;
    }//makeMove

    /**
     * send the updated state to a given player
     */
    @Override
    protected void sendUpdatedStateTo(GamePlayer p) {
        PigGameState copyPigGame = new PigGameState(this.pigGame);
        p.sendInfo(copyPigGame);
    }//sendUpdatedSate

    /**
     * Check if the game is over
     *
     * @return
     * 		a message that tells who has won the game, or null if the
     * 		game is not over
     */
    @Override
    protected String checkIfGameOver() {
        if (pigGame.getP0Score() >= 50) {
            return playerNames[0] + " wins with " + pigGame.getP0Score() + " points!";
        }

        else if (pigGame.getP1Score() >= 50) {
            return playerNames[1] + " wins with " + pigGame.getP1Score() + " points!";
        }
        else
            return null;
    }

}// class PigLocalGame
