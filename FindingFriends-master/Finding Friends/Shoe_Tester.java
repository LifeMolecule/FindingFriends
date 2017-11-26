
/**
 * Write a description of class Shoe_Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shoe_Tester
{
 public static void main(String[] args)
 {
     Shoe s=new Shoe(3);
     System.out.println(s);
     s.shuffle();
     System.out.println("");
     System.out.println(s);
     
     
     System.out.println(s.nextCard().getRank());
     System.out.println(s.nextCard().getRank());
     System.out.println(s.nextCard().getRank());
     System.out.println(s);
    }
}
