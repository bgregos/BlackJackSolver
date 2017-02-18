package blackJackSolver;

import java.util.ArrayList;

public class BJCardHand
{
    private ArrayList<Card> hand;
    
    public BJCardHand(){
        hand = new ArrayList<Card>();
    }
    
    public void addToHand(Card newCard){
        hand.add(newCard);
    }
    
    public int handTotalOne(){
        int total = 0;
        for (int i = 0; i < hand.size(); i ++){
            
            if (hand.get(i).getVal().getVal() == 11
                    || hand.get(i).getVal().getVal() == 12
                    || hand.get(i).getVal().getVal() == 13)
                    total += 10;
            
            else
                total += hand.get(i).getVal().getVal();
        }
        return total;
    }
    
    public int handTotalAce(){
        int total = 0;
        
        for (int i = 0; i < hand.size(); i ++){
            if (hand.get(i).getVal().getVal() == 1)
                total += 11;
            
            else if (hand.get(i).getVal().getVal() == 11
                || hand.get(i).getVal().getVal() == 12
                || hand.get(i).getVal().getVal() == 13)
                total += 10;
            
            else
                total += hand.get(i).getVal().getVal();
        }
        return total;
    }
    
    public String calculateOdds(Deck discard){
        String result = "";
        Deck notDrawn = discard.notDrawn();
        int poss1 = this.handTotalAce();
        int poss2 = this.handTotalOne();
        int count = 0;
        if (poss2 < 21){
            while(notDrawn.length() > 0){
                int newCardVal = notDrawn.draw().getVal().getVal();
                if (poss2 + newCardVal <= 21){
                    count++;
                }
            }
        }
        
        return "You have a %" +((count / discard.length()) * 100) + " of not busting.";
    }
    
}