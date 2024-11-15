import java.util.Random;

public class NimGameAI {
    private int strategyLevel;
    private Random random;

    // Constructor
    public NimGameAI(int strategyLevel) {
        this.strategyLevel = strategyLevel;
        this.random = new Random();
    }

    // Method to determine the best move for AI
    public int calculateAIMove(int piecesLeft) {
        int maxTake = piecesLeft / 2;
        if (maxTake < 1) {
            maxTake = 1;
        }

        // Strategy 1: Random move
        if (strategyLevel == 1) {
            return random.nextInt(maxTake) + 1;
        }

        // Strategy 2: Optimal move (default logic)
        int idealCount = nearestPowerOfTwoMinusOne(piecesLeft);
        int aiRemove = piecesLeft - idealCount;

        if (aiRemove < 1 || aiRemove > maxTake) {
            aiRemove = 1;
        }

        return aiRemove;
    }

    // Helper to locate largest power of two minus one below current pieces
    public static int nearestPowerOfTwoMinusOne(int piecesLeft) {
        int result = 1;
        while (result <= piecesLeft) {
            result *= 2;
        }
        return result / 2 - 1;
    }
}
