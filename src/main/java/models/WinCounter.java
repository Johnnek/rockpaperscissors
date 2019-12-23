package models;

public class WinCounter {

    private int draws;
    private int winnerPlayerA;
    private int winnerPlayerB;

    public WinCounter() {
        this.draws = 0;
        this.winnerPlayerA = 0;
        this.winnerPlayerB = 0;
    }

    public int getDraws() {
        return draws;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    public int getWinnerPlayerA() {
        return winnerPlayerA;
    }

    public void setWinnerPlayerA(int winnerPlayerA) {
        this.winnerPlayerA = winnerPlayerA;
    }

    public int getWinnerPlayerB() {
        return winnerPlayerB;
    }

    public void setWinnerPlayerB(int winnerPlayerB) {
        this.winnerPlayerB = winnerPlayerB;
    }
}
