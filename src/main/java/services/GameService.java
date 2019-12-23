package services;

import models.Player;
import models.WinCounter;

public interface GameService {

    WinCounter runGameWithFixLength();

    void runGameWithVariableLength();

    void chooseTurn(Player player, WinCounter winCounter);

    int faceOff(Player playerA, Player playerB);
}
