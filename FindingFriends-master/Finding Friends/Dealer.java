
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
    private ArrayList<Player> capture=new ArrayList<Player>();
    private ArrayList<Player> killing=new ArrayList<Player>();
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
        if(!o.equals("false") && counter==0)
        {
            x=o;
            System.out.println("Player one declared a "+ o + " " + trump);
            counter=1;
        }
        String t=two.drawCard(shoe.nextCard(),x,trump);
        if(!t.equals("false") && counter==0)
        {
            x=t;
            System.out.println("Player two declared a "+ t + " " + trump);
            counter=1;
        }
        String th=three.drawCard(shoe.nextCard(),x,trump);
        if(!th.equals("false") && counter==0)
        {
            x=th;
            System.out.println("Player three declared a "+ th + " " + trump);
            counter=1;
        }
        String f=four.drawCard(shoe.nextCard(),x,trump);
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
        ArrayList<Card> holder=new ArrayList<Card>();
        for(int i=0;i<8;i++)
        {
            holder.add(shoe.nextCard());
        }
        one.setTrumpStuff(ts,t);
        two.setTrumpStuff(ts,t);
        three.setTrumpStuff(ts,t);
        four.setTrumpStuff(ts,t);
        one.bottomCards(holder);
        two.bottomCards(holder);
        three.bottomCards(holder);
        four.bottomCards(holder);
        one.changeSuitToTrump();
        two.changeSuitToTrump();
        three.changeSuitToTrump();
        four.changeSuitToTrump();

    }

    //Entire method will probably be deleted later, used for testing (NOT IMPORTANT) 
    public String getAllhands()
    {
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
    //Creates a class that determines teams using logic
    public void teamSet()
    {
        if(control().equals("one"))
        {
            killing.add(one);
            killing.add(three);
            capture.add(two);
            capture.add(four);
        }
        else if (control().equals("two"))
        {
            killing.add(two);
            killing.add(four);
            capture.add(three);
            capture.add(one);
        }
        else if (control().equals("three"))
        {
            killing.add(three);
            killing.add(one);
            capture.add(four);
            capture.add(two);
        }
        else if (control().equals("four"))
        {
            killing.add(four);
            killing.add(two);
            capture.add(one);
            capture.add(three);
        }

    }
    //main class of the game rpf stands for redefined player number
    public int gameRound(int rpf)
    {
        int bottom=0;
        int newrpf=0;
        if(rpf==0)
        {
            //order should be capture 0 killing 1 capture 1 killing 0
            capture.get(0).getCard();
            killing.get(1).getCard(capture.get(0).gettypeOfPlay(),capture.get(0).getsuitOfPlay());
            capture.get(1).getCard(capture.get(0).gettypeOfPlay(),capture.get(0).getsuitOfPlay());
            killing.get(0).getCard(capture.get(0).gettypeOfPlay(),capture.get(0).getsuitOfPlay());

        }
        else if (rpf==1)
        {
            //order should be capture 1 killing 0 capture 0 killing 1 
            capture.get(1).getCard();
            killing.get(0).getCard(capture.get(1).gettypeOfPlay(),capture.get(1).getsuitOfPlay());
            capture.get(0).getCard(capture.get(1).gettypeOfPlay(),capture.get(1).getsuitOfPlay());
            killing.get(1).getCard(capture.get(1).gettypeOfPlay(),capture.get(1).getsuitOfPlay());
        }
        else if (rpf==2)
        {
            // Need to write the get card class first order should be killing 0 capture 0 
            // killing 1 capture 1
            killing.get(0).getCard();
            capture.get(0).getCard(killing.get(0).gettypeOfPlay(),killing.get(0).getsuitOfPlay());
            killing.get(1).getCard(killing.get(0).gettypeOfPlay(),killing.get(0).getsuitOfPlay());
            capture.get(1).getCard(killing.get(0).gettypeOfPlay(),killing.get(0).getsuitOfPlay());
        }
        else if (rpf==3)
        {
            //order should be killing 1 capture 1 killing 0 capture 0
            killing.get(1).getCard();
            capture.get(1).getCard(killing.get(1).gettypeOfPlay(),killing.get(1).getsuitOfPlay());
            killing.get(0).getCard(killing.get(1).gettypeOfPlay(),killing.get(1).getsuitOfPlay());
            capture.get(0).getCard(killing.get(1).gettypeOfPlay(),killing.get(1).getsuitOfPlay());
        }

        
        bottom=bottom+newrpf*1000;
        return bottom;
    }

}
