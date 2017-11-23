
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
    public Player(String t)
    {
     type=t;   
     Hand hand= new Hand();
    }
}
