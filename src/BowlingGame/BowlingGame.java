package BowlingGame;

/**
 * Created by frank on 2017. 2. 12..
 */
public class BowlingGame {

    private int[] rolls = new int[21];

    private int currentRoll = 0;

    public void roll(int pins) {
        rolls[currentRoll++] = pins;
    }

    public int score() {

        int totalScore = 0;
        int frameIndex = 0;

        for (int frame = 0; frame < 10; frame++) {
            if (isStrike(rolls[frameIndex])) {
                totalScore += 10 + strikeBonus(frameIndex);
                frameIndex += 1;

            } else if (isSpare(frameIndex)) {
                totalScore += 10 + spareBonus(frameIndex);
                frameIndex += 2;

            } else {
                totalScore += SumOfBallsInFrames(frameIndex);
                frameIndex += 2;
            }
        }

        return totalScore;
    }

    private int SumOfBallsInFrames(int frameIndex) {
        return rolls[frameIndex] + rolls[frameIndex + 1];
    }

    private int spareBonus(int frameIndex) {
        return rolls[frameIndex + 2];
    }

    private int strikeBonus(int frameIndex) {
        return rolls[frameIndex + 1] + rolls[frameIndex + 2];
    }

    private boolean isSpare(int frameIndex) {
        return rolls[frameIndex] + rolls[frameIndex + 1] == 10;
    }

    private boolean isStrike(int roll) {
        return roll == 10;
    }
}
