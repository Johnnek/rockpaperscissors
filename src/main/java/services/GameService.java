package services;

import models.Player;
import models.WinCounter;

public interface GameService {

    WinCounter runGame(int maxRounds);

    void chooseTurn(Player player, WinCounter winCounter);

    int faceOff(Player playerA, Player playerB);

    int alternativeFaceOff(Player playerA, Player playerB);
}
