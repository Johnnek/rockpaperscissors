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
        winCounter = gameService.runGame(100);

        Assert.assertNotNull(winCounter);
        assertEquals(100, winCounter.getTies()
                + winCounter.getWinsPlayerA() + winCounter.getWinsPlayerB());
    }

    @Test
    public void testChooseTurn() {
        player = new Player("Player A");
        gameService.chooseTurn(player, winCounter);

        Assert.assertNotNull(player.getTurn());
        Assert.assertTrue("Rock".equals(player.getTurn().toValue()) ||
                "Paper".equals(player.getTurn().toValue()) || "Scissor".equals(player.getTurn().toValue()));

        Player playerB = new Player("");
        winCounter = new WinCounter();
        winCounter.setTies(31);
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

    @Test
    public void testAlternativeFaceOff() {
        player = new Player("Player A");
        Player playerB = new Player("John Doe");
        winCounter = new WinCounter();

        gameService.chooseTurn(player, winCounter);
        gameService.chooseTurn(playerB, winCounter);

        int result = gameService.alternativeFaceOff(player, playerB);

        assertNotEquals(-1, result);
        assertTrue(0 <= result && result < 3);
    }
}