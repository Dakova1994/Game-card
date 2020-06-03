package com.company;

import java.util.ArrayList;
import java.util.List;

public class CardDeck
{
    private ArrayList<Card> cards = new ArrayList<Card>();

    public CardDeck() {

        for(Card.Suit s: Card.Suit.values())
        {
            for(Card.Rank r: Card.Rank.values())
            {
                cards.add(new Card(r,s));
            }
        }
    }

    public List<Card> getCardDeck(){
        return cards;
    }




    @Override
    public String toString() {
        String result = cards.size() + " cards:" + System.lineSeparator();
        for (Card card : cards)
        {
            result = result.concat(card + System.lineSeparator());
        }

        return result;
    }
}
