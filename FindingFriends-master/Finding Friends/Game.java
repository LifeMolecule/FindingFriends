
/**
 * Write a description of class Game here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Game
{
    
    //Make the game work for only two's and later make the thing for loop to start each new game
    public static void main(String args[]){
        //for loop that deals each round and prompts the player if he wants to declare if no cpu has declared yet
        //instantiates a dealer and a variable stating that nothing has been declared yet
        String trump="Two";
        int trumpnumvalue=1;
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
        System.out.println("--------------------------------------------\nSince player " + d.control() + " declared and this is the opening game \nhe recieves the bottom 8 cards");
        d.setUp(trumpsuit, trumpnumvalue);
        
        //remove the line below later when testing and bugfixing is over
        //System.out.println(d.getAllhands());
        
        
        //for loop that runs the game by calling something else?
    }
}
