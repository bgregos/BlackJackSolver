package com.example.bgregos.blackjacksolver;

import java.util.ArrayList;
import java.util.Collections;

public class Deck
{
    private ArrayList<Card> cards;
    
    public Deck(){
        cards = new ArrayList<Card>();
        generateDeck();
        shuffle();
    }

    private void generateDeck(){
        for (int i = 1; i < 5; i++){
            for (int j = 1; j < 14; j++){
                Card card = new Card(i, j);
                cards.add(card);
            }
        }
    }
    
    public String toString(){
        String allCards = "";
        for(int i = 0; i < this.length(); i++){
            allCards += cards.get(i) + "\n";
        }
        return allCards;
    }
    
    public Card draw(){
        Card drawnCard = cards.get(0);
        cards.remove(0);
        return drawnCard;
    }
    
    public void shuffle(){
        Collections.shuffle(cards);
    }
    
    public int length(){
        return cards.size();
    }
    
    private void addCard(Card newCard){
        cards.add(newCard);
    }
    
    private Card getCardAt(int index){
        return cards.get(index);
    }
    
    private void removeCard(Card toRemove){
        cards.remove(toRemove);
    }
    
    public Deck notDrawn(){
        Deck notDrawn = new Deck();
        for (int i = 0; i < this.length(); i++){
            notDrawn.removeCard(this.getCardAt(i));
        }
        return notDrawn;
        
    }
    
    public Card remove(String suit, String value)
    {
        Card cardToRemove = makeCard(suit, value);
        //System.out.println(cardToRemove.toString());
        for (int i = 0; i < cards.size(); i++)
        {
            if (cardToRemove.equals(cards.get(i)))
            {
                cards.remove(i);
                // to jump out of for loop
                i = cards.size();
            }
        }
        return cardToRemove;
    }
    
    private Card makeCard(String suit, String value)
    {
        int suitValue = 0;
        int cardValue = 0;
        if (suit.contains("spade"))
            suitValue = 1;
        else if (suit.contains("heart"))
            suitValue = 2;
        else if (suit.contains("clubs"))
            suitValue = 3;
        else
            suitValue = 4;
        
        if (value.contains("king"))
            cardValue = 13;
        else if (value.contains("queen"))
            cardValue = 12;
        else if (value.contains("jack"))
            cardValue = 11;
        else
            cardValue = Integer.parseInt(value);

        //System.out.println("" + suitValue + "\n" + cardValue);
        return new Card(suitValue, cardValue);
    }
    
    public int size()
    {
        return cards.size();
    }
    
}
