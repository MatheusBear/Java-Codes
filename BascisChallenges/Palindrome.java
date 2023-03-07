/**
 * Challenge By: ChatGPT
 * 
 * Write a Java program that reads in a string from the user and checks if it is a palindrome. 
 * A palindrome is a word, phrase, number, or other sequence of characters that reads the same forward and backward. 
 * For example, "racecar" and "level" are palindromes.
 * 
 * The program should ignore any spaces and punctuation marks in the input string.
 */

package BascisChallenges;
import java.util.*;

public class Palindrome {
    public static void main(String[] args){
        Scanner Sentence = new Scanner(System.in);
        System.out.println("Please enter a sentence: ");

        String s = Sentence.nextLine();

        Sentence.close();

        s = s.replaceAll("[^a-zA-Z]", "").toLowerCase(); //Removes everything that is not a character and makes the String lower case

        boolean isPalindrome = true;

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != s.charAt((s.length() - 1) - i)){
                isPalindrome = false;
                break;
            }
        }

        System.out.println("The string is a palindrome: " + isPalindrome);
        
    }
}
