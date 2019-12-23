package models;

public class WinCounter {

    private int ties;
    private int winsPlayerA;
    private int winsPlayerB;

    public WinCounter() {
        this.ties = 0;
        this.winsPlayerA = 0;
        this.winsPlayerB = 0;
    }

    public int getTies() {
        return ties;
    }

    public void setTies(int ties) {
        this.ties = ties;
    }

    public int getWinsPlayerA() {
        return winsPlayerA;
    }

    public void setWinsPlayerA(int winsPlayerA) {
        this.winsPlayerA = winsPlayerA;
    }

    public int getWinsPlayerB() {
        return winsPlayerB;
    }

    public void setWinsPlayerB(int winsPlayerB) {
        this.winsPlayerB = winsPlayerB;
    }
}
