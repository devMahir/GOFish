/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;
import java.util.ArrayList;

/**
 *
 * @author swema
 */
public class GoFishGame extends Game {

    private GoFishGroupOfCards deck;
    private int currentPlayerIndex = 0;

    public GoFishGame(String name, ArrayList<Player> players) {
        super(name);
        setPlayers(players);
        initializeDeck();
    }

    private void initializeDeck() {
        deck = new GoFishGroupOfCards(52);
        for (GoFishCard.Suit suit : GoFishCard.Suit.values()) {
            for (GoFishCard.Rank rank : GoFishCard.Rank.values()) {
                deck.addCard(new GoFishCard(suit, rank));
            }
        }
        deck.shuffle();
    }

    public void distributeCards() {
        for (Player player : getPlayers()) {
            GoFishPlayer goFishPlayer = (GoFishPlayer) player;
            for (int i = 0; i < 7; i++) {
                goFishPlayer.drawCard((GoFishCard) deck.removeCard(0));
            }
        }
    }

    public GoFishPlayer getCurrentPlayer() {
        return (GoFishPlayer) getPlayers().get(currentPlayerIndex);
    }

    public void nextTurn() {
        currentPlayerIndex = (currentPlayerIndex + 1) % getPlayers().size();
    }

    @Override
    public void play() {
        // The loop for players' turns, checking for books, and game end conditions would go here.
    }

    @Override
    public void declareWinner() {
        // Logic to declare the winner based on the most books formed.
    }
}
