package blackJackSolver;
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
        for (int i = 0; i < 25; i++)
            testD.draw();
        
        BJCardHand test = new BJCardHand();
        test.addToHand(new Card(1,1));
        test.addToHand(new Card(2,5));
        test.addToHand(new Card(2,10));
        //System.out.println(test.handTotalAce());
        //System.out.println(test.handTotalOne());
        System.out.print(test.calculateOdds(testD));
    }
}
