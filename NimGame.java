import java.util.Scanner;

public class NimGame {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Set up the initial pile of pieces
        int piecesLeft = 20; // Number of pieces in the game

        // Set AI to start
        boolean aiTurn = true;

        System.out.println("Welcome to the Modified Nim Game!");
        System.out.println("We begin with " + piecesLeft + " pieces on the table.");
        System.out.println("Each player must remove between 1 and half of the remaining pieces each turn.");
        System.out.println("The player who takes the last piece loses.");
        System.out.println("AI begins the game.\n");

        while (piecesLeft > 0) {
            System.out.println("Pieces remaining: " + piecesLeft);

            if (aiTurn) {
                // AI's move
                int aiRemove = NimAI.calculateAIMove(piecesLeft);
                piecesLeft -= aiRemove;
                System.out.println("AI removes " + aiRemove + " piece(s).");
            } else {
                // Player's move
                System.out.print("\nYour move. How many pieces will you take? ");
                int maxTake = piecesLeft / 2;
                if (maxTake < 1) {
                    maxTake = 1;
                }
                int playerRemove = input.nextInt();
                while (playerRemove < 1 || playerRemove > maxTake) {
                    System.out.print("Invalid choice. Please remove between 1 and " + maxTake + " pieces: ");
                    playerRemove = input.nextInt();
                }
                piecesLeft -= playerRemove;
            }

            if (piecesLeft == 0) {
                if (aiTurn) {
                    System.out.println("\nAI takes the last piece and loses! You win!");
                } else {
                    System.out.println("\nYou took the last piece. You lose! AI wins!");
                }
                break;
            }

            aiTurn = !aiTurn;
            System.out.println();
        }

        input.close();
    }
}
