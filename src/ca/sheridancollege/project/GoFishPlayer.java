/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author swema
 */

public class GoFishPlayer extends Player {

    private GroupOfCards hand;

    public GoFishPlayer(String name) {
        super(name);
        hand = new GoFishGroupOfCards(7); // For example, starting with 7 cards
    }

    // Add this method to get the hand
    public GroupOfCards getHand() {
        return hand;
    }
    
    public void removeCard(int index) {
        this.hand.getCards().remove(index);
    }


    public void drawCard(GoFishCard card) {
        hand.addCard(card);
    }

    public boolean hasRank(GoFishCard.Rank rank) {
        for (Card card : hand.getCards()) {
            GoFishCard goFishCard = (GoFishCard) card;
            if (goFishCard.getRank() == rank) {
                return true;
            }
        }
        return false;
    }

    public void addCardsOfRankToHand(GoFishPlayer fromPlayer, GoFishCard.Rank rank) {
        for (int i = 0; i < fromPlayer.getHand().getCards().size(); i++) {
            GoFishCard card = (GoFishCard) fromPlayer.getHand().getCards().get(i);
            if (card.getRank() == rank) {
                this.drawCard(card);
                fromPlayer.getHand().removeCard(i);
                i--;  // adjust for removed card
            }
        }
    }

    public boolean checkForBooks() {
        for (GoFishCard.Rank rank : GoFishCard.Rank.values()) {
            int count = 0;
            for (Card card : hand.getCards()) {
                GoFishCard goFishCard = (GoFishCard) card;
                if (goFishCard.getRank() == rank) {
                    count++;
                }
            }
            if (count == 4) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void play() {
        // Request card logic will go here (for simplicity, let's leave it as is for now)
    }
}

