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
    private String[] ranks={"Ace","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Jack","Queen","King"};
    /**
     * Constructor for a deck which makes a standard 52 card deck
     */
    public Deck()
    {
        String x="";
        int z=0;
        for (int i = 1; i<5; i+=1)
        {
             for (int j = 1; j<11; j+=1)
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
            for (int k = 11; k < 14; k+=1)
            {
                String y = "";
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
                if (k == 11)
                {
                    y = "Jack";
                    z=11;
                }
                else if (k ==12)
                {
                    y = "Queen";
                    z=12;
                }
                else if (k == 13)
                {
                    y = "King";
                    z=13;
                }
                nDeck.add(new Card(x,z,y));
            }
         
        }
           nDeck.add(new Card("Trump",27,"RJoker"));
            nDeck.add(new Card("Trump",28,"BJoker"));
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