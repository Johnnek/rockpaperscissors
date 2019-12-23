package services.impl;

import models.Player;
import models.Turn;
import models.WinCounter;
import services.GameService;

import java.util.Random;
import java.util.Scanner;

public class GameServiceImpl implements GameService {

    private Player playerA;
    private Player playerB;
    private WinCounter winCounter;
    private int falseCounter = 0;


    /**
     * This functions starts a game with 100 rounds
     */
    @Override
    public WinCounter runGameWithFixLength() {
        playerA = new Player("Player A");
        playerB = new Player("Player B");
        winCounter = new WinCounter();

        int tmp;
        for (int round = 0; round<100; round++){
            chooseTurn(playerA, winCounter);
            chooseTurn(playerB, winCounter);

            tmp = faceOff(playerA, playerB);
            if (tmp == 0) {
                winCounter.setDraws(winCounter.getDraws()+1);
            }
            else if (tmp == 1) {
                winCounter.setWinnerPlayerA(winCounter.getWinnerPlayerA()+1);
            }
            else if (tmp == 2) {
                winCounter.setWinnerPlayerB(winCounter.getWinnerPlayerB()+1);
            } else {
                System.err.println("Error occured in choosing a turn");
            }

        }
        System.out.println("Player A won "+winCounter.getWinnerPlayerA()+" times.");
        System.out.println("Player B won "+winCounter.getWinnerPlayerB()+" times.");
        System.out.println("The players tied "+winCounter.getDraws()+" times.");
        return winCounter;
    }

    @Override
    public void runGameWithVariableLength() {
        playerA = new Player("Player A");
        playerB = new Player("Player B");

        System.out.println("How many rounds do you want to play?");
        Scanner scanner = new Scanner(System.in);
        int maxRounds = scanner.nextInt();

        for (int round = 0; round<maxRounds; round++){
            chooseTurn(playerA, winCounter);
            chooseTurn(playerB, winCounter);
        }
    }

    @Override
    public void chooseTurn(Player player, WinCounter winCounter) {
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
        }
    }

    /**
     * Function to check who wins the rounds
     * @param playerA Object of the first player: Player A
     * @param playerB Object of the second player: Player B
     * @return Number between 0-2; 0 = Tie, 1 = Player A win, 2 = Player B win, -1 = Error
     */
    @Override
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
