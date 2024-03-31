package tic_tac_toe;

public class Decision {
    private int position;
    private int score;

    public Decision(int position, int score) {
        this.position = position;
        this.score = score;
    }

    public Decision() {
        this.position = -1;
        this.score = 0;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
