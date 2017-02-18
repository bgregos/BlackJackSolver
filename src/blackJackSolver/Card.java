package blackJackSolver;

public class Card
{
    private Suit suit;
    private Value val;
    
    public Card(int suit, int val){
        this.suit = new Suit(suit);
        this.val = new Value(val);
    }
    
    public Suit getSuit(){
        return suit;
    }
    
    public Value getVal(){
        return val;
    }

    public String toString(){
        String str = val.toString() + " of " +suit.toString();
        return str;
    }
}
