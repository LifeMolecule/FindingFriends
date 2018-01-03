
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
    private Player one;
    private Player two;
    private Player three;
    private Player four;
    private ArrayList<Card> dump=new ArrayList<Card>();
    private String trumpsuit;
    private int trump;
    //maybe instantiate 4 players and 4 hands here as well
    public Dealer()
    {
        shoe=new Shoe(2);
        shoe.shuffle();
        one=new Player("Human");
        two=new Player("Robot");
        three=new Player("Robot");
        four=new Player("Robot");
    }
    //deals a round
    public String dealRound(String x,String trump,int counter) { 
        //determines if a trump has been declared yet
        String o=one.drawCard(shoe.nextCard(),x,trump);
        String t=two.drawCard(shoe.nextCard(),x,trump);
        String th=three.drawCard(shoe.nextCard(),x,trump);
        String f=four.drawCard(shoe.nextCard(),x,trump);
        if(!o.equals("false") && counter==0)
        {
            x=o;
            System.out.println("Player one declared a "+ o + " " + trump);
            counter=1;
        }
        if(!t.equals("false") && counter==0)
        {
            x=t;
            System.out.println("Player two declared a "+ t + " " + trump);
            counter=1;
        }
        if(!th.equals("false") && counter==0)
        {
            x=th;
            System.out.println("Player three declared a "+ th + " " + trump);
            counter=1;
        }
        if(!f.equals("false") && counter==0)
        {
            x=f;
            System.out.println("Player four declared a "+ f + " " + trump);
            counter=1;
        }
        return x;
    }
    
    //tells dealer what the trump suit and number are
    //deals bottom 8 and has cpu automatically choose the lowest cards that arnt doubles and dumps,
    //otherwise lets player choose 8 cards to dump
    public void setUp(String ts, int t)
    {
        trumpsuit=ts;
        trump=t;
    }
    
    //sorts and sets hands, last line will be removed and changed to voide later(WIP) 
    public String getAllhands()
    {
        one.handSort();
        one.set(trumpsuit,trump);
        two.handSort();
        two.set(trumpsuit,trump);
        three.handSort();
        three.set(trumpsuit,trump);
        four.handSort();
        four.set(trumpsuit,trump);
        return "1: " + one.getHandvalues() + "\n \n 2: " + two.getHandvalues() + "\n \n 3: " + three.getHandvalues() + "\n \n 4: " + four.getHandvalues();
    }
    //determines who is in control
    public String control()
    {
        if(one.getIncontrol())
        {
            return "one";
        }
        else if(two.getIncontrol())
        {
            return "two";
        }
        else if(three.getIncontrol())
        {
            return "three";
        }
        else
        {
            return "four";
        }
    }
    
    
    //looks at the 4 arraylists and compares them to the lead to see who is the highest/who wins the points
    public String turnCalculator(ArrayList<Card> p1,ArrayList<Card> p2, ArrayList<Card> p3, ArrayList<Card> p4,int lead)
    {
        return "WIP";
    }
    
    //Creates a class that determines teams using logic
    
}
