
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

    private String canDeclare="false";
    private String trumpsuit;
    private int trumpvalue;
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
        for(int i=h.size();i>0;i--)
        {
            if(h.get(i-1).getSuit().equals(suit) && h.get(i-1).getValue()==value)
            {
                h.get(i-1).setValue(26);
                trumps.add(h.remove(i-1));
            }
            else if(h.get(i-1).getValue()==value)
            {
                h.get(i-1).setValue(25);
                trumps.add(h.remove(i-1));
            }
            else if(h.get(i-1).getSuit().equals(suit) && h.get(i-1).getValue()>value)
            {
                h.get(i-1).setValue(h.get(i-1).getValue()+11);
            }
            else if(h.get(i-1).getSuit().equals(suit))
            {
                h.get(i-1).setValue(h.get(i-1).getValue()+12);
            }
            else if(h.get(i-1).getValue()>value && !(h.get(i-1).getValue()>26))
            {
                h.get(i-1).setValue(h.get(i-1).getValue()-1);
            }
        }
    }

    public void setTrumpStuff(String suit, int value)
    {
        trumpsuit=suit;
        trumpvalue=value;
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
    //sorts hands by suit and in order of increasing value after using the "set" command
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
        h.add(new Card(c.getSuit(),c.getValue(),c.getRank()));
        if(type.equals("Human"))
        {
            if(canDeclare.equals("false") && c.getRank().equals(trump))
            {
                canDeclare="true";
            }

            if(x.equals("false") && canDeclare.equals("true"))
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

    
    //sets the bottom cards for the player
    public int bottomCards(ArrayList<Card> eight)
    {
        if(incontrol)
        {
            for(int i=0;i<8;i++)
            {
                h.add(eight.remove(0));

            }
            int bottompilepoints=0;
            Card hold;
            if(type.equals("Human"))
            {
                set(trumpsuit,trumpvalue);
                handSort();
                System.out.println("----------------------------\n You need to put 8 cards back into the bottom pile, Here are all your cards:\n" + getHand());

                //while loop to throw away cards by cycling through the suits

                String a="";
                int suit=0;
                int counter=8;

                while(counter>0)
                {   int j=0;
                    if(suit==0)
                    {
                        System.out.println("----------------------------");
                        System.out.println("Here are the spades, what would you like to do?\n1:remove from spades  2: next suit");
                        for(Card c:spades)
                        {   
                            System.out.print(j + ": "+ c.getSuit()+"/"+ c.getRank() + " ");
                            j+=1;
                        }
                        int num=scan.nextInt();
                        if(num==1)
                        {
                            System.out.println("Input the number of a card you would like to remove\n");
                            hold=spades.remove(scan.nextInt());
                            counter-=1;
                            a=a + hold.getRank() + " ";
                            bottompilepoints=bottompilepoints + 2*hold.getPointValue();
                        }
                        else
                        {
                            suit=(suit+1) % 4;
                        }
                    }
                    else if(suit==1)
                    {
                        System.out.println("----------------------------");
                        System.out.println("Here are the clubs, what would you like to do?\n1:remove from clubs  2: next suit\n");
                        for(Card c:clubs)
                        {   
                            System.out.print(j + ": "+ c.getSuit()+"/"+ c.getRank() + " ");
                            j+=1;
                        }
                        int num=scan.nextInt();
                        if(num==1)
                        {
                            System.out.println("Input the number of a card you would like to remove\n");
                            hold=clubs.remove(scan.nextInt());
                            counter-=1;
                            a=a + hold.getRank() + " ";
                            bottompilepoints=bottompilepoints + 2*hold.getPointValue();
                        }
                        else
                        {
                            suit=(suit+1) % 4;
                        }
                    }
                    else if(suit==2)
                    {
                        System.out.println("----------------------------");
                        System.out.println("Here are the diamonds, what would you like to do?\n1:remove from diamonds  2: next suit\n");
                        for(Card c:diamonds)
                        {
                            System.out.print(j + ": "+ c.getSuit()+"/"+ c.getRank() + " ");
                            j+=1;
                        }
                        int num=scan.nextInt();
                        if(num==1)
                        {
                            System.out.println("Input the number of a card you would like to remove\n");
                            hold=diamonds.remove(scan.nextInt());
                            counter-=1;
                            a=a + hold.getRank() + " ";
                            bottompilepoints=bottompilepoints + 2*hold.getPointValue();
                        }
                        else
                        {
                            suit=(suit+1) % 4;
                        }
                    }
                    else if(suit==3)
                    {
                        System.out.println("----------------------------");
                        System.out.println("Here are the hearts, what would you like to do?\n1:remove from hearts  2: next suit\n");
                        for(Card c:hearts)
                        {  
                            System.out.print(j + ": "+ c.getSuit()+"/"+ c.getRank() + " ");
                            j+=1;
                        }
                        int num=scan.nextInt();
                        if(num==1)
                        {
                            System.out.println("Input the number of a card you would like to remove\n");
                            hold=hearts.remove(scan.nextInt());
                            counter-=1;
                            a=a + hold.getRank() + " ";
                            bottompilepoints=bottompilepoints + 2*hold.getPointValue();
                        }
                        else
                        {
                            suit=(suit+1) % 4;
                        }
                    }
                }
                System.out.println("You threw away: " + a);
                //get ride of the line below later cuz its just for checking
                System.out.println(bottompilepoints);
                return bottompilepoints;
            }

            //make the cpu logic here smarter to not throw away pairs or points sometime later
            else
            {
                set(trumpsuit,trumpvalue);
                // throw away cards to bottom pile here
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
 
                for(int i=8;i>0;i--)
                {
                    hold=h.remove(i-1);
                    bottompilepoints=hold.getPointValue()*2+bottompilepoints;
                }

                handSort();
                //get ride of the line below later cuz its just for checking
                System.out.println(bottompilepoints);
                return bottompilepoints;
            }
        }
        else
        {
            set(trumpsuit,trumpvalue);
            handSort();
            return 0;
        }

    }

}
