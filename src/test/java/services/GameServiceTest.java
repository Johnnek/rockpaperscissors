package services;

import models.Player;
import models.WinCounter;
import org.junit.Assert;
import org.junit.Test;
import services.impl.GameServiceImpl;

import static org.junit.Assert.*;

public class GameServiceTest {

    private GameService gameService = new GameServiceImpl();
    private Player player;
    private WinCounter winCounter;

    @Test
    public void testRunGameWithFixLength() {
        winCounter = gameService.runGameWithFixLength();

        Assert.assertNotNull(winCounter);
        assertEquals(32, winCounter.getDraws());
        assertEquals(31, winCounter.getWinnerPlayerA());
        assertEquals(37, winCounter.getWinnerPlayerB());
    }

    @Test
    public void testChooseTurn() {
        player = new Player("Player A");
        gameService.chooseTurn(player, winCounter);

        Assert.assertNotNull(player.getTurn());
        assertEquals("Paper", player.getTurn().toValue());

        Player playerB = new Player("");
        winCounter = new WinCounter();
        winCounter.setDraws(31);
        gameService.chooseTurn(playerB, winCounter);

        Assert.assertNotNull(playerB.getTurn());
        assertNotEquals("Paper", playerB.getTurn());
    }

    @Test
    public void testFaceOff() {
        player = new Player("Player A");
        Player playerB = new Player("John Doe");
        winCounter = new WinCounter();

        gameService.chooseTurn(player, winCounter);
        gameService.chooseTurn(playerB, winCounter);

        int result = gameService.faceOff(player, playerB);

        assertTrue(0 <= result && result < 3);
    }
}