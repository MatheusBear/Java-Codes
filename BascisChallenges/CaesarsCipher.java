/**
 * Challenge given by: Prof. Max do Val Machado; PUC-Minas; Ciência da Computação(Computer Science)
 * 
 * Julius Caesar was one of the main names of the Roman Empire. 
 * Among his contributions, we have a cryptography algorithm called "Caesar Cipher". 
 * According to historians, Caesar used this algorithm to encrypt messages he sent to his generals during battles. 
 * The basic idea is a simple shift of characters. 
 * 
 * So, for example, if the key used to encrypt messages is 3, all occurrences of the character 'a' are replaced by the character 'd', those of 'b' by 'e', and so on. 
 * Create an iterative method that takes a string as a parameter and returns another one containing the encrypted input. In this exercise, assume the encryption key is 3. 
 */

package BascisChallenges;
import java.util.*;

public class CaesarsCipher {
    public static void main(String[] args){
        Scanner Sentence = new Scanner(System.in);
        System.out.println("Please enter a sentence you wish to be encrypted: ");

        String s = Sentence.nextLine();
        Sentence.close();

        String Encrypted = Cipher(s);

        System.out.println("The encrypted sentence is: ");
        System.out.println(Encrypted);
    }

    /**
     * Caeser's Chipher Algorithm
     * @param a String that will be encrypted
     * @return  Encrypted String
     */
    public static String Cipher(String a)
	{
		String s = "";
        int cifra = 3;
		
        for(int i = 0; i < a.length(); i++) 
            s += (char)(a.charAt(i) + cifra);
        return s;
	}
}
