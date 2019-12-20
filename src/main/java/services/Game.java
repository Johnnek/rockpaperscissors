package services;

import models.Player;

public interface Game {

    void runGame();

    Player chooseTurn(Player player);

    Player faceOff(Player playerA, Player playerB);

    int counter();
}
