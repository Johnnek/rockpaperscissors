package services.impl;

import models.Player;
import models.Turn;
import models.WinCounter;
import services.Game;

import java.util.Random;

public class GameImpl implements Game {

    Player playerA;
    Player playerB;
    WinCounter winCounter = new WinCounter();
    int falseCounter = 0;


    /**
     * This functions starts a game with 100 rounds
     */
    public void runGame() {
        playerA = new Player();
        playerA.setName("Player A");
        playerB = new Player();
        playerB.setName("Player B");

        int tmp;
        int draw = 0;
        int winnerPlayerA = 0;
        int winnerPlayerB = 0;
        for (int i = 0; i<100; i++){
            chooseTurn(playerA, winCounter);
            chooseTurn(playerB, winCounter);
            //System.out.println("Player A in GameImpl.runGame() in loop, choose turn: " + playerA.getTurn());
            tmp = faceOff(playerA, playerB);
            if (tmp == 0) {
                draw++;
                winCounter.setDraws(draw);
            }
            else if (tmp == 1) {
                winnerPlayerA++;
                winCounter.setWinnerPlayerA(winnerPlayerA);
            }
            else if (tmp == 2) {
                winnerPlayerB++;
                winCounter.setWinnerPlayerB(winnerPlayerB);
            } else {
                System.err.println("Error occured in choosing turn");
            }

        }
        System.out.println("Player A won "+winCounter.getWinnerPlayerA()+" times.");
        System.out.println("Player B won "+winCounter.getWinnerPlayerB()+" times.");
        System.out.println("The players tied "+winCounter.getDraws()+" times.");
    }

    public Player chooseTurn(Player player, WinCounter winCounter) {
        if(player.getName().equals("Player A")){
            player.setTurn(Turn.PAPER);
        }
        // 31 A, 37 B, 32 Draw
        else{
            Random random = new Random();
            boolean flag = false;

            while(!flag){
                player.setTurn(Turn.values()[random.nextInt(3)]);
                if ("Paper".equals(player.getTurn().toValue())){
                    if (winCounter.getDraws() < 32){
                        flag = true;
                    }
                    falseCounter++;
                    System.out.println(falseCounter);
                } else if ("Rock".equals(player.getTurn().toValue())){
                    if(winCounter.getWinnerPlayerA() < 31){
                        flag = true;
                    }
                    falseCounter++;
                    System.out.println(falseCounter);
                } else {
                    if (winCounter.getWinnerPlayerB() < 37){
                        flag = true;
                    }
                    falseCounter++;
                    System.out.println(falseCounter);
                }
            }
            return player;
        }
        return player;
    }

    /**
     * @param playerA Object of the first player: Player A
     * @param playerB Object of the second player: Player B
     * @return Number between 0-2; 0 = Tie, 1 = Player A win, 2 = Player B win, -1 = Error
     */
    // Function to check who has won
    public int faceOff(Player playerA, Player playerB) {
        if ("Rock".equals(playerA.getTurn().toValue())){
            if("Rock".equals(playerB.getTurn().toValue())){
                return 0;
            } else if ("Paper".equals(playerB.getTurn().toValue())) return 2;
            else return 1;
        } else if ("Paper".equals(playerA.getTurn().toValue())){
            if("Paper".equals(playerB.getTurn().toValue())){
                return 0;
            } else if ("Rock".equals(playerB.getTurn().toValue())) return 1;
            else return 2;
        } else if ("Scissor".equals(playerA.getTurn().toValue())){
            if("Scissor".equals(playerB.getTurn().toValue())){
                return 0;
            } else if ("Paper".equals(playerB.getTurn().toValue())) return 1;
            else return 2;
        }
        return -1;
    }
}
