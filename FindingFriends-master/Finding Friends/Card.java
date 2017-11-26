
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

/**
 * @return the suit of the card
 */
public String getSuit() {
    return suit;
}

}
