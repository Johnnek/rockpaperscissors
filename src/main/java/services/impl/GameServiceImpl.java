package services.impl;

import models.Player;
import models.Turn;
import models.WinCounter;
import services.GameService;

import java.util.Objects;
import java.util.Random;

public class GameServiceImpl implements GameService {

    private Player playerA;
    private Player playerB;

    /**
     * This functions starts a game with given rounds
     */
    @Override
    public WinCounter runGame(int maxRounds) {
        playerA = new Player("Player A");
        playerB = new Player("Player B");
        WinCounter winCounter = new WinCounter();
        runRounds(maxRounds, winCounter);
        output(winCounter);
        return winCounter;
    }

    /**
     * @param maxRounds  Amount of rounds to be played in a game
     * @param winCounter Object to save the amount of wins of each player
     */
    private void runRounds(int maxRounds, WinCounter winCounter) {

        for (int round = 0; round < maxRounds; round++) {
            playerA.setTurn(Turn.PAPER);
            chooseTurn(playerB, winCounter);
            int tmp = alternativeFaceOff(playerA, playerB);

            if (tmp == 0) {
                winCounter.setTies(winCounter.getTies() + 1);
            } else if (tmp == 1) {
                winCounter.setWinsPlayerA(winCounter.getWinsPlayerA() + 1);
            } else if (tmp == 2) {
                winCounter.setWinsPlayerB(winCounter.getWinsPlayerB() + 1);
            }
        }
    }

    /**
     * @param winCounter Object with ties, wins player A and wins player B
     */
    public void output(WinCounter winCounter) {
        int playedRounds = winCounter.getTies()+winCounter.getWinsPlayerA()+winCounter.getWinsPlayerB();
        System.out.println(playerA.getName() + " won " + winCounter.getWinsPlayerA() + " of " + playedRounds + " times.");
        System.out.println(playerB.getName() + " won " + winCounter.getWinsPlayerB() + " of " + playedRounds + " times.");
        System.out.println("The players tied " + winCounter.getTies() + " of " + playedRounds + " times.");
    }

    /**
     * @param player     Object of the player who will choose turn
     * @param winCounter Object with counters for each scenario
     */
    @Override
    public void chooseTurn(Player player, WinCounter winCounter) {

        Random random = new Random();
        // Pick a random turn between 0-2; 0 = Rock, 1 = Paper, 2 = Scissor
        player.setTurn(Turn.values()[random.nextInt(3)]);

        /*
        // Output to see which turn got chosen
        System.out.println(player.getTurn().toValue());
        */

        /*
        // Alternative output to get closer to the 31-37-32 game result
        int tmp = random.nextInt(1000);
        if(tmp >= 0 && tmp < 310){
            player.setTurn(Turn.ROCK);
        }
        if(tmp >= 310 && tmp < 630){
            player.setTurn(Turn.PAPER);
        }
        if(tmp >= 630 && tmp < 1000){
            player.setTurn(Turn.SCISSOR);
        }
        */

        /*
        // Alternative output to get the exact 31-37-32 game result
        boolean flag = false;
        while(!flag){
            player.setTurn(Turn.values()[random.nextInt(3)]);
            if ("Paper".equals(player.getTurn().toValue())){
                if (winCounter.getTies() < 32){
                    flag = true;
                }
                falseCounter++;
                System.out.println(falseCounter);
            } else if ("Rock".equals(player.getTurn().toValue())){
                if(winCounter.getWinsPlayerA() < 31){
                    flag = true;
                }
                falseCounter++;
                System.out.println(falseCounter);
            } else {
                if (winCounter.getWinsPlayerB() < 37){
                    flag = true;
                }
                falseCounter++;
                System.out.println(falseCounter);
            }
        }
        */
    }

    /**
     * Function to check who wins the rounds
     *
     * @param playerA Object of the first player: Player A
     * @param playerB Object of the second player: Player B
     * @return Number between 0-2; 0 = tie, 1 = Player A win, 2 = Player B win, -1 = error
     */
    @Override
    public int faceOff(Player playerA, Player playerB) {
        // Check if both players have chosen their turns
        if (playerA.getTurn() != null && playerB.getTurn() != null) {
            // Check different turns
            if ("Rock".equals(playerA.getTurn().toValue())) {
                if ("Rock".equals(playerB.getTurn().toValue())) {
                    return 0;
                } else if ("Paper".equals(playerB.getTurn().toValue())) return 2;
                else if ("Scissor".equals(playerB.getTurn().toValue())) return 1;
                else return -1;
            } else if ("Paper".equals(playerA.getTurn().toValue())) {
                if ("Paper".equals(playerB.getTurn().toValue())) {
                    return 0;
                } else if ("Rock".equals(playerB.getTurn().toValue())) return 1;
                else if ("Scissor".equals(playerB.getTurn().toValue())) return 2;
                else return -1;
            } else if ("Scissor".equals(playerA.getTurn().toValue())) {
                if ("Scissor".equals(playerB.getTurn().toValue())) {
                    return 0;
                } else if ("Paper".equals(playerB.getTurn().toValue())) return 1;
                else if ("Rock".equals(playerB.getTurn().toValue())) return 2;
                else return -1;
            }
        }
        return -1;
    }

    /**
     * Alternative function to check who wins the rounds
     *
     * @param playerA Object of the first player: Player A
     * @param playerB Object of the second player: Player B
     * @return Number between 0-2; 0 = tie, 1 = Player A win, 2 = Player B win, -1 = error
     */
    @Override
    public int alternativeFaceOff(Player playerA, Player playerB) {
        if ("Rock".equals(playerA.getTurn().toValue())) {
            switch (Objects.requireNonNull(playerB.getTurn().toValue())) {
                case "Rock":
                    return 0;
                case "Paper":
                    return 2;
                case "Scissor":
                    return 1;
                default:
                    return -1;
            }
        } else if ("Paper".equals(playerA.getTurn().toValue())) {
            switch (Objects.requireNonNull(playerB.getTurn().toValue())) {
                case "Rock":
                    return 1;
                case "Paper":
                    return 0;
                case "Scissor":
                    return 2;
                default:
                    return -1;
            }
        } else if ("Scissor".equals(playerA.getTurn().toValue())) {
            switch (Objects.requireNonNull(playerB.getTurn().toValue())) {
                case "Rock":
                    return 2;
                case "Paper":
                    return 1;
                case "Scissor":
                    return 0;
                default:
                    return -1;
            }
        }
        return -1;
    }
}
