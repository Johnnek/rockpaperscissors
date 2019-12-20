package services.impl;

import models.Player;
import models.Turn;
import services.Game;

public class GameImpl implements Game {

    Player playerA;
    Player playerB;
    int draw;

    public void runGame() {
        playerA = new Player();
        playerA.setName("Player A");
        playerB = new Player();
        playerB.setName("Player B");

        for (int i = 0; i<100; i++){
            chooseTurn(playerA);
            chooseTurn(playerB);
            faceOff(playerA, playerB);
        }
    }

    public Player chooseTurn(Player player) {
        if(player.getName().equals("Player A")){
            player.setTurn(Turn.PAPER);
        }
        else{
            player.setTurn(Turn.PAPER);
        }
        return player;
    }

    public Player faceOff(Player playerA, Player playerB) {

        return null;
    }

    public int counter() {
        return 0;
    }
}
