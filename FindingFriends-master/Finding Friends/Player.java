
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
    private ArrayList<Card> h=new ArrayList<Card>();
    private ArrayList<Card> spades=new ArrayList<Card>();
    private ArrayList<Card> hearts=new ArrayList<Card>();
    private ArrayList<Card> diamonds=new ArrayList<Card>();
    private ArrayList<Card> clubs=new ArrayList<Card>();
    private ArrayList<Card> trumps=new ArrayList<Card>();

    private String type;
    private Scanner scan=new Scanner(System.in);
    private boolean incontrol=false;
    public Player(String t)
    {
        type=t;   
    }

     //class which makes all the trumps increase in value and changes the trump card to the "trump suit"
    public void set(String suit, int value)
    {
        for(Card c: spades)
        {
            if(c.getSuit().equals(suit) && c.getValue()==value)
            {
                c.setValue(26);
            }
            else if(c.getValue()==value)
            {
                c.setValue(25);
            }
            else if(c.getSuit().equals(suit) && c.getValue()>value)
            {
                c.setValue(c.getValue()+11);
            }
             else if(c.getSuit().equals(suit))
            {
                c.setValue(c.getValue()+12);
            }
             else if(c.getValue()>value)
            {
                c.setValue(c.getValue()-1);
            }
        }
         for(Card c: clubs)
        {
            if(c.getSuit().equals(suit) && c.getValue()==value)
            {
                c.setValue(26);
            }
            else if(c.getValue()==value)
            {
                c.setValue(25);
            }
            else if(c.getSuit().equals(suit) && c.getValue()>value)
            {
                c.setValue(c.getValue()+11);
            }
             else if(c.getSuit().equals(suit))
            {
                c.setValue(c.getValue()+12);
            }
             else if(c.getValue()>value)
            {
                c.setValue(c.getValue()-1);
            }
        }
         for(Card c: diamonds)
        {
            if(c.getSuit().equals(suit) && c.getValue()==value)
            {
                c.setValue(26);
            }
            else if(c.getValue()==value)
            {
                c.setValue(25);
            }
            else if(c.getSuit().equals(suit) && c.getValue()>value)
            {
                c.setValue(c.getValue()+11);
            }
             else if(c.getSuit().equals(suit))
            {
                c.setValue(c.getValue()+12);
            }
             else if(c.getValue()>value)
            {
                c.setValue(c.getValue()-1);
            }
        }
         for(Card c: hearts)
        {
            if(c.getSuit().equals(suit) && c.getValue()==value)
            {
                c.setValue(26);
            }
            else if(c.getValue()==value)
            {
                c.setValue(25);
            }
            else if(c.getSuit().equals(suit) && c.getValue()>value)
            {
                c.setValue(c.getValue()+11);
            }
             else if(c.getSuit().equals(suit))
            {
                c.setValue(c.getValue()+12);
            }
             else if(c.getValue()>value)
            {
                c.setValue(c.getValue()-1);
            }
        }
    }
    
    //used to see the hand
    public String getHand()
    {
        String a="Spades: ";
        for(Card c:spades)
        {
            a=a + c.getSuit() + "/" + c.getRank() + " ";
        }
        a=a+"\n";
        a=a + "Diamonds: ";
        for(Card c:diamonds)
        {
            a=a + c.getSuit() + "/" + c.getRank() + " ";
        }
        a=a+"\n";
        a=a+ "Clubs: ";
        for(Card c:clubs)
        {
            a=a + c.getSuit() + "/" + c.getRank() + " ";
        }
        a=a+"\n";
        a=a+ "Hearts: ";
        for(Card c:hearts)
        {
            a=a + c.getSuit() + "/" + c.getRank() + " ";
        }
        a=a+"\n";
        a= a+ "Trumps: ";
        for(Card c:trumps)
        {
            a=a + c.getSuit() + "/" + c.getRank() + " ";
        }

        return a;
    }
    //used to debug program and make sure values work, never actually called in program
        public String getHandvalues()
    {
        String a="Spades: ";
        for(Card c:spades)
        {
            a=a + c.getSuit() + "/" + c.getRank() + c.getValue() + " ";
        }
        a=a+"\n";
        a=a + "Diamonds: ";
        for(Card c:diamonds)
        {
            a=a + c.getSuit() + "/" + c.getRank() + c.getValue() +" ";
        }
        a=a+"\n";
        a=a+ "Clubs: ";
        for(Card c:clubs)
        {
            a=a + c.getSuit() + "/" + c.getRank() + c.getValue() +" ";
        }
        a=a+"\n";
        a=a+ "Hearts: ";
        for(Card c:hearts)
        {
            a=a + c.getSuit() + "/" + c.getRank() + c.getValue() +" ";
        }
        a=a+"\n";
        a= a+ "Trumps: ";
        for(Card c:trumps)
        {
            a=a + c.getSuit() + "/" + c.getRank() + c.getValue() +" ";
        }

        return a;
    }
    public void handSort()
    {
        ArrayList<Card> holder=new ArrayList<Card>();
        holder.add(h.get(h.size()-1));
        for(int i=h.size()-1;i>0;i--)
        {
            Card d=(h.remove(i-1));
            int counter=0;
            for(int j=0;j<holder.size();j++)
            {
                if(holder.get(j).getValue()<d.getValue())
                {
                    counter++;
                }
            }
            holder.add(counter,d);
        }
        h=holder;
        for(Card c:h)
        {
            if(c.getSuit().equals("Spades"))
            {
                spades.add(c);
            }
            else if(c.getSuit().equals("Clubs"))
            {
                clubs.add(c);
            }
            else if(c.getSuit().equals("Hearts"))
            {
                hearts.add(c);
            }
            else if(c.getSuit().equals("Diamonds"))
            {
                diamonds.add(c);
            }
            else
            {
                trumps.add(c);
            }
        }
    }

    public boolean getIncontrol()
    {
        return incontrol;
    }

    public String drawCard(Card c,String x,String trump)
    {
        //instantiates z which tells if player has a declarable card or not
        String z="false";
        h.add(new Card(c.getSuit(),c.getValue(),c.getRank()));
        if(type.equals("Human"))
        {
            if(z.equals("false") && c.getRank().equals(trump))
            {
                z="true";
            }

            if(x.equals("false") && z.equals("true"))
            {    System.out.println("Would you like to declare");
                System.out.println("Options: 1).Yes, 2).No ");
                // Scanner statement here that does stuff
                int i=scan.nextInt();
                if(i==1)
                {
                    System.out.println("Below are the suits you can declare");
                    int a=1;
                    ArrayList<Card> holder=new ArrayList<Card>();
                    for(Card d:h)
                    {
                        if(d.getRank().equals(trump))
                        {
                            System.out.print(a + " " + d.getSuit());
                            a+=1;
                            holder.add(d);
                        }
                    }
                    System.out.println("\n Insert the number of the suit you would like to declare");
                    i=scan.nextInt();
                    x=holder.get(i-1).getSuit();
                    incontrol=true;

                }
            }
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

}
