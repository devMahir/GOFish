/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author swema
 */



public class main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<Player> players = new ArrayList<>();

        System.out.println("Welcome to Go Fish!");

        // Create human player
        System.out.print("Enter your name: ");
        String playerName = scanner.nextLine();
        GoFishPlayer human = new GoFishPlayer(playerName);
        players.add(human);

        // For simplicity, we'll add a single computer opponent.
        GoFishPlayer computer = new GoFishPlayer("Computer");
        players.add(computer);

        GoFishGame game = new GoFishGame("Go Fish", players);
        game.distributeCards();

        // Main game loop
        boolean gameOn = true;
        while (gameOn) {
            GoFishPlayer currentPlayer = game.getCurrentPlayer();
            System.out.println(currentPlayer.getName() + "'s turn!");

            if (currentPlayer == human) {
                System.out.print("Your cards: ");
                for (Card card : human.getHand().getCards()) {
                    System.out.print(card.toString() + " ");
                }
                System.out.println();

                // This is a very simplified gameplay loop, where the human player can only request cards from the computer.
                System.out.println("Which rank would you like to request from the computer? (e.g., TWO, THREE)");
                String rankInput = scanner.nextLine().toUpperCase();

                try {
                    GoFishCard.Rank requestedRank = GoFishCard.Rank.valueOf(rankInput);
                    if (computer.hasRank(requestedRank)) {
                        System.out.println("Computer has the rank! Taking the card(s)...");
                        human.addCardsOfRankToHand(computer, requestedRank);
                    } else {
                        System.out.println("Go Fish!");
                        // Add drawing a card from deck logic here.
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid rank. Try again.");
                }
            } else {
                // Simple computer logic: It requests a random rank it already has in hand.
                // In a real game, you'd want to make this smarter!
                GoFishCard.Rank randomRank = ((GoFishCard) computer.getHand().getCards().get(0)).getRank();
                System.out.println("Computer requests rank: " + randomRank);

                if (human.hasRank(randomRank)) {
                    System.out.println("You have the rank! Giving card(s) to the computer...");
                    computer.addCardsOfRankToHand(human, randomRank);
                } else {
                    System.out.println("Computer goes fishing.");
                    // Add drawing a card from deck logic here.
                }
            }

            // Check game end condition: for simplicity, let's say the game ends when one player has no cards left.
            if (human.getHand().getCards().isEmpty() || computer.getHand().getCards().isEmpty()) {
                gameOn = false;
                game.declareWinner();
            } else {
                game.nextTurn();
            }
        }
    }
}
