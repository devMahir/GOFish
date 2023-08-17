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

public class GoFishGroupOfCards extends GroupOfCards {

    public GoFishGroupOfCards(int size) {
        super(size);
        this.cards = new ArrayList<>(size);
    }

    public void addCard(GoFishCard card) {
        getCards().add(card);
    }

    @Override
    public GoFishCard removeCard(int index) {
        return (GoFishCard) cards.remove(index);
    }

}

