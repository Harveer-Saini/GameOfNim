import java.util.Scanner;

public class NimGame {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int piecesLeft = 20; // Number of pieces initially in the game

        // Starting the AI 
        boolean aiTurn = true;

        System.out.println("Game of Nim!");
        System.out.println("At the start of the game, there are " + piecesLeft + " pieces on the table.");
        System.out.println("You must remove between 1 to half of the pieces left after each turn.");
        System.out.println("Whoever takes the last piece will lose the game, and the AI will start.");

        while (piecesLeft > 0) {
            System.out.println("Pieces remaining: " + piecesLeft);

            if (aiTurn) {
                // AI's move
                int aiRemove = NimGameAI.calculateAIMove(piecesLeft);
                piecesLeft -= aiRemove;
                System.out.println("The AI removed " + aiRemove + " piece(s).");
            } else {
                // Player's move
                System.out.print("\nYour turn! How many pieces do you want to remove? ");
                int maxTake = piecesLeft / 2;
                if (maxTake < 1) {
                    maxTake = 1;
                }
                int playerRemove = input.nextInt();
                while (playerRemove < 1 || playerRemove > maxTake) {
                    System.out.print("That is an invalid number. You have to remove between 1 and " + maxTake + " pieces: ");
                    playerRemove = input.nextInt();
                }
                piecesLeft -= playerRemove;
            }

            if (piecesLeft == 0) {
                if (aiTurn) {
                    System.out.println("\nThe AI took the last piece, so the AI lost. Congratulations, you win the Game of Nim!");
                } else {
                    System.out.println("\nYou took the last piece, so you lost the game. Better luck next time!");
                }
                break;
            }

            aiTurn = !aiTurn;
            System.out.println();
        }

        input.close();
    }
}
