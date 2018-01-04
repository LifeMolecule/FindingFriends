import java.util.ArrayList;
/**
 * deck.java  
 *
 * @author:
 * Assignment #:
 * 
 * Brief Program Description:
 * 
 *
 */
public class Deck
{
    private ArrayList<Card> nDeck=new ArrayList<Card>(); 
    private String[] ranks={"Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Jack","Queen","King","Ace"};
    /**
     * Constructor for a deck which makes a standard 52 card deck
     */
    public Deck()
    {
        String x="";
        int z=0;
        for (int i = 1; i<5; i+=1)
        {
             for (int j = 1; j<14; j+=1)
            {
                if (i == 1)
                {
                    x = "Hearts";
                }
                else if (i ==2)
                {
                    x = "Spades";
                }
                else if (i == 3)
                {
                    x = "Clubs";
                }
                else if (i == 4)
                {
                    x = "Diamonds";
                }
                nDeck.add(new Card(x,j,ranks[j-1]));
                
            }
        }
           nDeck.add(new Card("Trump",28,"RJoker"));
            nDeck.add(new Card("Trump",27,"BJoker"));
    }
    /**
     * Deck getter
     * @return the Arraylist of cards
     */
    public ArrayList<Card> getDeck()
    {
        return nDeck;
    }
    
    
    
    
    /** 
     * To string method which returns out all the ranks in the deck
     * @return all the ranks in the deck
     */
    public String toString()
    {
        String a="";
        for(Card c: nDeck)
        {
            a=a + c.getRank() + " ";
        }
        return a;
    }
}