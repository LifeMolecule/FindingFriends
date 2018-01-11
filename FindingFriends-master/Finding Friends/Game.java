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
        //Make the intro better some other time.
        System.out.println("-------------------------------------------------\nHello and Welcome to Finding Friends, a complex game focused on winning points");
        
        //Change the following line when multiple players are introduced
        System.out.println("You are Player one and your partner is Player three(CPU): Good Luck\n-------------------------------------------------");
        
        
        
        
        
        
        //Start of SetUp of Game
        String trump="Two";
        int trumpnumvalue=1;
        String trumpsuit="false";
        int counter=0;
        int capturedPoints=0;
        Dealer d=new Dealer();
        for(int i=0;i<25;i++){
            trumpsuit=d.dealRound(trumpsuit,trump,counter);
            if(!trumpsuit.equals("false"))
            {
                counter+=1;
            }
        }
        System.out.println("--------------------------------------------\nSince player " + d.control() + " declared and this is the opening game \nhe recieves the bottom 8 cards and gets to lead in the opening round");
        d.setUp(trumpsuit, trumpnumvalue);
        d.teamSet();
        
        //get rid of this line later, its just for testing
        System.out.println(d.getAllhands());
        
        
        
        
        
        //for loop that runs the game
        int rpf=2;
        int output=0;
        for(int i=0;i<25;i++)
        {
            //method that takes in Last rounds winner; produces an amount of points and a new winner in the format 10##. If first digit is two or three
            //then the killing team wins, otherwise the capturing team wins
            output=d.gameRound(rpf);
            
            if(output>1999)
            {
                if(output>2999)
                {
                    rpf=3;
                }
                else
                {
                    rpf=2;
                }
            }
            else
            {
                //statement that tells who the winner is.
                if(output>999)
                {
                    rpf=1;
                }
                else
                {
                    rpf=0;
                }
                capturedPoints=capturedPoints+(output%1000);
                
            }
            
            
            
            
            
        }
        
        //method that adds the bottompilepoints of all members to the captured points if the capturing team wins the last round
        
        
        
        
        
        
        
    }
}
