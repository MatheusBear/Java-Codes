/**
 * Challenge By: ChatGPT
 * 
 * Write a Java program that reads a sentence from the user, and then prints out the longest word in the sentence.
 * 
 * The program should ignore any punctuation marks and spaces, and treat any consecutive sequence of letters as a single word. 
 * For example, the word "don't" should be treated as a single word, and not as two separate words.
 * 
 * If there are multiple longest words in the sentence, the program should print out all of them, separated by commas.
 */

package BascisChallenges;
import java.util.*;

public class LongestWord {
    public static void main(String[] args){
        Scanner Sentence = new Scanner(System.in);
        System.out.println("Please enter a sentence: ");

        String s = Sentence.nextLine();

        //Checks if the sentence end with a ., !, or ?
        if(s.charAt(s.length() - 1) == '.' || s.charAt(s.length() - 1) == '!' || s.charAt(s.length() - 1) == '?'){
            s = s.substring(0, s.length() - 1); //Removes the dot/Exclamation at the end of the sentence
        }

        s = s + " "; //adding space to get the last word


        String[] NewS = s.split(" "); //to split each word in the sentence

        int Size = 0; // to count the size of the word

        //Loop to find the longest word in the sentence
        for(int i = 0; i < NewS.length; i++){
            if(NewS[i].length() > Size){
                Size = NewS[i].length();
            }
        }

        System.out.println("Longest Word(s): ");

        int Num = 0; // To see if there is more then one word with same length(size)

        for(int i = 0; i < NewS.length; i++){
            if(NewS[i].length() == Size){
                if(Num == 0){
                    System.out.print(NewS[i]);
                    Num++;
                }else{
                    System.out.print(", " + NewS[i]);
                }
            }
        }

        Sentence.close();
    }
}
