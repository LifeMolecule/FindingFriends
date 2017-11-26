
/**
 * Shoe.java  
 *
 * @author:
 * Assignment #:
 * 
 * Brief Program Description:
 * 
 *
 */
import java.util.ArrayList;
public class Shoe
{
    private int amountOfDecks;
    private ArrayList<Card> nShoe = new ArrayList<Card>();
    /**
     * Constructor for a Shoe
     * @param Amounts of Decks in the shoe
     */
    public Shoe(int a) {
        amountOfDecks=a;
        Deck de=new Deck();
        ArrayList<Card> d=de.getDeck(); 
        for(int i=d.size()-1;i>-1;i--)
        {
            Card e=d.remove(i);
            for(int j=0;j<amountOfDecks;j++)
            {nShoe.add(e);
            }
        }
    }

    /**
     * Prints out all ranks of all cards in the Shoe with a new line starting every 50 cards
     * @return the ranks of every card in the Shoe
     */
    public String toString()
    {
        String a="";
        int d=1;
        for(Card c:nShoe)
        {
            a=a+c.getRank() + " ";
            d++;
            if(d%50==0)
            {
                a=a+"\n";
            }
        }
        return a;
    }

    /**
     * Randomizes the order the cards are in in the Shoe arraylist
     */
    public void shuffle() {
        ArrayList<Card> holder=new ArrayList<Card>();
        int a=nShoe.size();
        int b=-1;
        for(int i=0;i<a;i++)
        {
            b=(int)(Math.random()*(nShoe.size()));
            holder.add(nShoe.remove(b));
        }
        nShoe=holder;
    }

    /**
     * Gets the next Card in the Shoe and moves the counter onto the next Card and removes the card from the shoe
     * @return the next card
     */
    public Card nextCard() {
        Card c=nShoe.remove(0);
        return c;
    }

}
