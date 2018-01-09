
/**
 * Card.java  
 *
 * @author:
 * Assignment #:
 * 
 * 
 */
public class Card
{
private String suit;
private String rank;
private int value;
private int pointValue;
/**
 * Constructor for Card class which instantiates a card. The card always starts face up.
 * @param A string for suit, string for rank
 * 
 */
public Card(String s,int v,String r)
{
    suit=s;
    rank=r;
    value=v;
    if(r.equals("Five"))
    {
        pointValue=5;
    }
    else if(r.equals("King") || r.equals("Ten"))
    {
        pointValue=10;
    }
    else
    {
        pointValue=0;
    }
}
/**
 * A getter for the Rank
 * @return rank
 */
public String getRank()
{
    return rank;
}
public int getValue(){
    return value;
}

public void setValue(int v){
    value=v;
}
public int getPointValue()
{
    return pointValue;
}
/**
 * @return the suit of the card
 */
public String getSuit() {
    return suit;
}
}
