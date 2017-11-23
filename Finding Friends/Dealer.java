
/**
 * Write a description of class Dealer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Scanner;
import java.util.ArrayList;
public class Dealer
{
  private Shoe shoe;
  //maybe instantiate 4 players and 4 hands here as well
  public Dealer()
  {
      shoe=new Shoe(2);
      shoe.shuffle();
    }
    //deals a card to a player and returns which card it is
  public Card dealToPlayer(Player player) { 
      
    }
    //looks at the 4 arraylists and compares them to the lead to see who is the highest/who wins the points
    public String turnCalculator(ArrayList<Card> p1,ArrayList<Card> p2, ArrayList<Card> p3, ArrayList<Card> p4,int lead)
    {
        
    }
}
