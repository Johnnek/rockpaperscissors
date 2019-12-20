package services;

import models.Player;
import models.WinCounter;

public interface Game {

    void runGame();

    Player chooseTurn(Player player, WinCounter winCounter);

    int faceOff(Player playerA, Player playerB);
}
