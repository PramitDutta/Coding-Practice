
import java.util.Scanner;

public class Problem
{ 
  static int expectoLength(String input){
	      int i;
	      for(i=input.length();i>=0;i--){
	          if(checkPalindrome(input.substring(0,i))){
	              break;
	          }
	      }
	      return 2*input.length()-1;
  }
  static  boolean checkPalindrome(String input){
      for(int i=0,j=input.length()-1;i<=(input.length()/2)-1;i++,j--){
          if(input.charAt(i)!=input.charAt(j)){
              return false;
          }
      }
      return true;
  }
  
  public static void main(String[] args)
  {
     String input;
     Scanner stdin = new Scanner(System.in);
     input=stdin.nextLine();
     stdin.close();
     System.out.println(expectoLength(input));
  }
}