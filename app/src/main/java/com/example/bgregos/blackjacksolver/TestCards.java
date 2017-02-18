package com.example.bgregos.blackjacksolver;
import student.TestCase;


public class TestCards extends TestCase
{

    public void setUp(){
        
    }
    
    public void testCardClass(){
        
        Card test = new Card(1, 5);
        assertEquals("5 of Spades", test.toString());
    }
    
    public void testDeck(){
        Deck test = new Deck();
        //System.out.println(test);
        for (int i = 0; i < 52; i++){
            //System.out.println(test.draw());
            test.shuffle();
        }
    }
    
    public void testCardhand(){
        Deck testD = new Deck();
        for (int i = 0; i < 16; i++)
            testD.draw();
        //System.out.println(testD.toString());
        BJCardHand test = new BJCardHand();
        test.addToHand(testD.draw());
        test.addToHand(testD.draw());
        //System.out.println(testD.toString() + "\n\n\n");
        
        //System.out.println(test.toString());
        //test.addToHand(testD.draw());
        //System.out.println(test.handTotalAce());
        //System.out.println(test.handTotalOne());
        System.out.print(test.calculateOdds(testD));
    }
    
    public void testA()
    {
        BlackJack bj = new BlackJack();
        //System.out.println(bj.getDeck().size());
        bj.addPlayerCard("Spade", "2");
        //System.out.println(bj.getDeck().size());
    }
}
