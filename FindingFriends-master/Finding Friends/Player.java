
/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Scanner;
import java.util.ArrayList;
public class Player
{
    private Hand hand;
    private String type;
    private Scanner scan=new Scanner(System.in);
    private boolean incontrol=false;
    public Player(String t)
    {
        type=t;   
        Hand hand=new Hand();
    }

    public boolean getIncontrol()
    {
        return incontrol;
    }

    public String drawCard(Card c,String x,String trump)
    {
        //instantiates z which tells other class if someone declared or not
        //hand.addCard(c);
        if(type.equals("Human"))
        {if(x.equals("false") && false)
                System.out.println("Would you like to declare");
            //System.out.println("Options:" +  );
            // Scanner statement here that does stuff (WIP)
        }
        //cpu logic here
        else if(x.equals("false"))
        {
            if(c.getRank().equals(trump))
            {
                x=c.getSuit();
                incontrol=true;
            }
        }
        return x;
    }
    public ArrayList<Card> getHand()
    {
        return hand.getHand();
    }
    }
