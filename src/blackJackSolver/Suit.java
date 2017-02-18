package blackJackSolver;
/**
 * 
 * @author Kipp Dunn
 * @version 2016.18.1
 *
 * This class will represent the suit of a playing card either being spade 
 * diamond club or heart.
 */
public class Suit
{
    int suit; 
    
    public Suit(int suit) {
        this.suit = suit;
    }
    
    public int getSuitVal(){
        return suit;
    }
    
    public String toString(){
        String cardSuit;
        int val = suit;
        switch (val) {
            case 1:  cardSuit = "Spades";
                     break;
            case 2:  cardSuit = "Hearts";
                     break;
            case 3:  cardSuit = "Clubs";
                     break;
            case 4:  cardSuit = "Diamonds";
                     break;
            default: cardSuit = "Joker";
                     break;
                     
        }
        return cardSuit;
    }
}
