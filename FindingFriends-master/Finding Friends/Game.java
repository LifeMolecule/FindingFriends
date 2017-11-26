
/**
 * Write a description of class Game here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Game
{
    public static void main(String args[]){
        //for loop that deals each round and prompts the player if he wants to declare if no cpu has declared yet
        //instantiates a dealer and a variable stating that nothing has been declared yet
        String trump="Two";
        String trumpsuit="false";
        int counter=0;
        Dealer d=new Dealer();
        for(int i=0;i<25;i++){
            trumpsuit=d.dealRound(trumpsuit,trump,counter);
            if(!trumpsuit.equals("false"))
            {
                counter+=1;
            }
        }
        System.out.println(trumpsuit);
        System.out.println(d.control());
        //for loop that runs the game by calling something else?
    }
}
