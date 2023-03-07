/**
 * Challenge By: ChatGPT
 * 
 * Write a Java program that generates a random password of a specified length. 
 * The program should prompt the user to enter the desired length of the password, 
 * and then generate a random password that contains a mix of uppercase and lowercase letters, 
 * numbers, and symbols.
 */

package BascisChallenges;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class PasswordGenerator {
    public static void main(String[] args){
        Scanner Number = new Scanner(System.in);
        System.out.println("Please enter the password size: ");

        int min = 33;
        int max = 126;

        int x = Number.nextInt();
        Number.close();

        String password = "";

        for(int i = 0; i < x; i++){
            int Random = ThreadLocalRandom.current().nextInt(min, max + 1);

            char letter = (char)Random;
            password += letter;
        }

        System.out.println("Password: " + password);
        
    }
}
