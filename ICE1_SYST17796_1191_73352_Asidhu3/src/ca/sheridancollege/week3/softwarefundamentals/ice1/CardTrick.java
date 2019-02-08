/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.week3.softwarefundamentals.ice1;

import java.util.Random;
import java.util.Scanner;

/**
 * A class that fills a magic hand of 7 cards with random Card Objects
 * and then asks the user to pick a card and searches the array of cards
 * for the match to the user's card. To be used as starting code in ICE 1
 * @author Yiyao Zhang
 */
public class CardTrick {
    
    public static void main(String[] args) throws Exception{
        InputHandleSystem inputHandleSystem = new InputHandleSystem();

        Card[] magicHand = new Card[7];
        
        magicHand = createSevenCards();
        System.out.println("Pick a card");
        int suitIndex = inputHandleSystem.getInt("Suit index of this card: (0:Hearts, 1:Diamonds, 2:Spades, 3:Clubs)", Domain.limited, 0, 3);
        int value = inputHandleSystem.getInt("Pick a value: ", Domain.limited, 1, 13);
        inputHandleSystem.closeReader();

        Card userCard = new Card();
        userCard.setValue(value);
        userCard.setSuit(Card.SUITS[suitIndex]);

        // and search magicHand here
        String result = isMagicHandCard(userCard);
        //Then report the result here
        System.out.println(result);
        
        //luckyCard
        Card luckyCard = new Card();
        luckyCard.setValue(10);
        luckyCard.setSuit(Card.SUITS[2]);
    }



    static private String randomSuit() throws IllegalArgumentException {
        Random random = new Random();
        int newSuit = random.nextInt(4);

        switch (newSuit) {
            case 0:
                return "Spades";
            case 1:
                return "Hearts";
            case 2:
                return "Clubs";
            case 3:
                return "Diamonds";
            default:
                throw new IllegalArgumentException("CardTrick randomSuit: suit index error");
        }
    }

    static Card[] createSevenCards() {
        Random random = new Random();
        int newValue;
        Card[] cards = new Card[7];

        for (int i = 0; i < 7; i++) {

            newValue = random.nextInt(13) + 1;

            cards[i] = new Card();
            cards[i].setSuit(randomSuit());
            cards[i].setValue(newValue);
        }

        return cards;
    }

    static String isMagicHandCard(Card card) {
        Card[] myCards = createSevenCards();

        for (Card myCard : myCards) {
            if ((myCard.getSuit() + myCard.getValue()).equals(card.getSuit() + card.getValue())) {
                return "your chosen card is in the magic hand of random cards!";
            }
        }

        return "Sorry, chosen card is not in the magic hand of random cards.";
    }
    
}
