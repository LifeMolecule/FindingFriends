
/**
 * Write a description of class turnCalc here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
import java.util.ArrayList;
public class turnCalc
{
    // instance variables - replace the example below with your own
    private int x;
    private String currentSuit;
    private int win1 = 1;
    private int win2 = 1;
    private int win3 = 1;
    private int win4 = 1;
    private int highValue = 0;

    public String turnCalculator(ArrayList<Card> p1, ArrayList<Card> p2, ArrayList<Card> p3, ArrayList<Card> p4)
    {
        if(p1.size() == 1) //master plays 1 card
        {
            if(p1.get(0).getSuit().equals(trumpsuit)) //master plays trump
            {
                if(! (p2.get(0).equals(trumpsuit)) && (!(p3.get(0).equals(trumpsuit))) && (!(p4.get(0).equals(trumpsuit)))) //other players no trump = lose
                {
                    win2 = 0;
                    win3 = 0;
                    win4 = 0;
                 
                }
  
                
                else // at least 1 other player plays trump
                {
                    if(p1.get(0).getRank().equals("RJoker")) // red joker = auto win
                    {
                        win2 = 0;
                        win3 = 0;
                        win4 = 0;
                    }
                    
                    else if((p1.get(0).getRank().equals("BJoker")) && (p2.get(0).getRank().equals("RJoker")))
                    {
                        win1 = 0;
                        win3 = 0;
                        win4 = 0;
                    }
                    
                    else if((p1.get(0).getRank().equals("BJoker")) && (p3.get(0).getRank().equals("RJoker")))
                    {
                        win1 = 0;
                        win2 = 0;
                        win4 = 0;
                    }
                    
                    else if((p1.get(0).getRank().equals("BJoker")) && (p4.get(0).getRank().equals("RJoker")))
                    {
                        win1 = 0;
                        win2 = 0;
                        win3 = 0;
                    }
                    
                    else // no red joker played
                    {
                        if(p1.get(0).getRank().equals("BJoker")) //black joker = auto win when no redjoker played
                        {
                            win1 = 0;
                            win2 = 0;
                            win3 = 0;
                        }
                        
                        else if((p2.get(0).getRank().equals("BJoker")))
                        {
                            win1 = 0;
                            win3 = 0;
                            win4 = 0;
                        }
                        
                        else if((p3.get(0).getRank().equals("BJoker")))
                        {
                            win1 = 0;
                            win2 = 0;
                            win4 = 0;
                        }
                        
                        else if((p4.get(0).getRank().equals("BJoker")))
                        {
                            win1 = 0;
                            win2 = 0;
                            win3 = 0;
                        }
                        else //no black joker nor red joker played
                        {
                            highValue = p1.get(0).getValue();
                            
                            if(p2.get(0).getValue() > highValue)
                            {
                                win1 = 0;
                                highValue = p2.get(0).getValue();
                                if(p3.get(0).getValue() > highValue)
                                {
                                    win2 = 0;
                                    highValue = p3.get(0).getValue();
                                }
                                else if(p4.get(0).getValue() > highValue)
                                {
                                    win3 = 0;
                                    highValue = p4.get(0).getValue();
                                }
                                else
                                {
                                    win1 = 0;
                                    win2 = 0;
                                    win3 = 0;
                                }
                            }
                            
                            else if(p3.get(0).getValue() > highValue)
                            {
                                win1 = 0;
                                win2 = 0;
                                highValue = p3.get(0).getValue();
                                if(p4.get(0).getValue() > highValue)
                                {
                                    win3 = 0;
                                    highValue = p4.get(0).getValue();
                                }
                                 
                            }
                            
                            else if(p4.get(0).getValue() > highValue)
                            {
                                win1 = 0;
                                win2 = 0;
                                win3 = 0;
                                highValue = p4.get(0).getValue();
                            }
                            
                            else
                            {
                                win1 = 1;
                                win2 = 0;
                                win3 = 0;
                                win4 = 0;
                            }
                            
                        
                                
                            
                         
                                
                         
                            
                        }
                        
                            
                    }
                        
                    
                    
                    
                    
                    
                    
                  
                }
            }
        }
        
        if(win1 == 1)
        {
            return "first player wins!";
        }
        else if(win2 == 1)
        {
            return "second player wins!";
        }
        
        else if(win3 == 1)
        {
            return "third player wins!";
        }
        else
        {
            return "fourth player wins!";
        }
                
    }
}
