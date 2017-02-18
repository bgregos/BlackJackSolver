package com.example.bgregos.blackjacksolver;

public class BlackJack
{

    private Deck deck;
    //private int players;
    private BJCardHand house;
    private BJCardHand player;
    
    
    public BlackJack(){
        //this.players = players;
        deck = new Deck();
        house = new BJCardHand();
        player = new BJCardHand();
        //player.addToHand(deck.draw());
        //player.addToHand(deck.draw());
        //house.addToHand(deck.draw());
        //house.addToHand(deck.draw());
        
    }
    
    public BlackJack(int numOfDecks, int players){
        
    }
    
    public double returnPercentage()
    {
        return player.calculateOddsWithDealerFaceDown(deck);
    }
    
    public void addPlayerCard(String suit, String value)
    {
        player.addToHand(deck.remove(suit.toLowerCase(), value.toLowerCase()));
    }
    
    public void addDealerCard(String suit, String value)
    {
        player.addToHand(deck.remove(suit.toLowerCase(), value.toLowerCase()));
    }
    
    public Deck getDeck()
    {
        return deck;
    }
    
    
}
