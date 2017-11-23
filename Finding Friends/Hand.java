
/**
 * Write a description of class Hand here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.ArrayList;
public class Hand
{
    private ArrayList<Card> h=new ArrayList<Card>();
    public ArrayList<Card> getHand()
    {
        return h;
    }
    //adds a card to the hand
    public void addCard(Card c)
    {h.add(c);
    }
}
