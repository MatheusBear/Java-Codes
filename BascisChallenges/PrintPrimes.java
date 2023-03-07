/**
 * Challenge By: ChatGPT
 * 
 * Write a program that prompts the user to enter a positive integer and then prints out all the
 * prime numbers up to and including that integer.
*/

package BascisChallenges;
import java.util.*;

public class PrintPrimes{
    public static void main(String[] args){
        int x; //User inputed integer

        Scanner Number = new Scanner(System.in);
        System.out.println("Please enter an integer greater than one: ");

        x = Number.nextInt();

        System.out.println("The Prime Numbers are: ");
        for(int i = 0; i <= x; i++){
            if((i % 2) == 1){
                System.out.println(i + " is Prime");
            }
        }

        Number.close();
    }

}