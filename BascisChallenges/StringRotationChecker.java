/**
 * Challenge By: ChatGPT
 * 
 * Write a Java program that prompts the user to enter two strings and determines whether the second string is a rotation of the first string.
 * 
 * For example, the string "abcde" can be rotated to "cdeab" by moving the first two characters to the end of the string. 
 * The program should determine if the second string is a rotation of the first string by checking if it contains all of the same characters as the first string, 
 * in the same order, but starting from a different position.
 */

package BascisChallenges;
import java.util.*;

public class StringRotationChecker{
    public static void main(String[] args){
        Scanner Sentence = new Scanner(System.in);
        System.out.println("Please enter the first string: ");

        String s = Sentence.nextLine();

        System.out.println("Please enter the second string: ");

        String s2 = Sentence.nextLine();
        
        Sentence.close();
        boolean isSameString = true;

        if(s.length() != s2.length()){ //if they are not the same size, they cannot be the same string
            isSameString = false;
        }else{
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) != s2.charAt((s.length() - 1) - i)){
                    isSameString = false;
                    break;
                }
            }
        }

        if(isSameString) System.out.println("The second String is a rotation of the first String");
        else System.out.println("The second String is NOT a rotation of the first String");
        
    }
}