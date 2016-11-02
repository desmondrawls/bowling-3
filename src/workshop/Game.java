package workshop;

/**
 * Created by pivotal on 11/2/16.
 */
public class Game {
    private int totalScore = 0;
    private int currentFrame = 0;
    private int currentRoll = 0;
    private int pinsFirstRoll = 0;
    private boolean strike = false;
    private boolean spare = false;


    public void addRoll(int pins) {
        totalScore += pins;

        pinsFirstRoll = currentRoll == 0? pins: 0;


        // First roll in a new frame?
        if (currentRoll == 0 && (strike || spare)) {
                totalScore += pins;

        }

        // Second roll after spare in previous frame?
        if (currentRoll == 1 && strike){
                totalScore += pins;

        }

        // Strike?
        strike = (currentRoll == 1) && (pins == 10);

        // Spare?
        spare = (currentRoll == 2) && (pins + pinsFirstRoll == 10);

        currentRoll++;

        if (currentRoll == 2 || strike) {
            currentFrame++;
            currentRoll = 0;
        }

    }

    public int getTotalScore() {
        return totalScore;
    }

    public boolean isGameOver() {
        return currentFrame == 10;
    }
}
