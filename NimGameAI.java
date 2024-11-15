public class NimGameAI { 
    // Method to determine the best move for AI
    public static int calculateAIMove(int piecesLeft) {
        int maxTake = piecesLeft / 2;
        if (maxTake < 1) {
            maxTake = 1;
        }

        // Find target based on P-position logic
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
