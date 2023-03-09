/**
 * Challenge By: ChatGPT
 * 
 * Write a Java program that simulates a simple game of blackjack between a player and a computer dealer.
 * 
 * Since suits do not matter in Blackjack, they will not be used.
 * 
 * There are 52 playing cards:
 * 4 - 'A's
 * 4 - 2s through 10s
 * 10 - Face Cards that count as 10's 
 */

package Challenge;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Blackjack {
    public static void main(String[] args){
        ArrayList<String> cards = new ArrayList<String>();

        //Put the cards in the ArrayList 
        cards = CreateDeck(cards);

        //Players Hand
        ArrayList<String> PlayerCards = new ArrayList<String>();
        //Dealers Hand
        ArrayList<String> DealerCards = new ArrayList<String>();

        //Deal Player Hand
        for(int i = 0; i < 2; i++){
            int Random = ThreadLocalRandom.current().nextInt(0, cards.size() + 1);

            PlayerCards.add(cards.get(Random));//Adds card to Dealers Hand
            cards.remove(Random);//Removes Card from the Deck of Cards
        }

        //Deal Dealers Hand
        for(int i = 0; i < 2; i++){
            int Random = ThreadLocalRandom.current().nextInt(0, cards.size() + 1);

            DealerCards.add(cards.get(Random));//Adds card to Dealers Hand
            cards.remove(Random);//Removes Card from the Deck of Cards
        }

        int valuePlayer = CountValue(PlayerCards); //Value of all Cards in hand

        System.out.println("Players hand: " + PlayerCards.get(0) + ", " + PlayerCards.get(1));

        System.out.println("Value of cards in hand: " + valuePlayer);

        //Show Dealers Face-up card
        System.out.println("Dealers face-up card: " + DealerCards.get(0));

        Scanner HitStand = new Scanner(System.in);

        System.out.println("Hit or Stand: ");

        String s = HitStand.nextLine();
        s = s.toLowerCase();

        char choice = s.charAt(0); //Pick first char in the string, either 'h' for hit; or 's' for Stand


        /**
         * If player choose to hit, this loop will continue until:
         * A - They choose to stand
         * B - They hit Blackjack
         * C - They Bust (Value of all cards above 21) 
         */
        while(choice == 'h' && valuePlayer < 21){

            int Random = ThreadLocalRandom.current().nextInt(0, cards.size() + 1);

            PlayerCards.add(cards.get(Random));//Adds card to Dealers Hand
            cards.remove(Random);//Removes Card from the Deck of Cards

            valuePlayer = CountValue(PlayerCards);

            System.out.print("Player hand: " + PlayerCards.get(0));
            for(int i = 1; i < PlayerCards.size(); i++){
                System.out.print(", " + PlayerCards.get(i));
            }
            System.out.println("");
            System.out.println("Value of cards in hand: " + valuePlayer);
            if(valuePlayer > 21){
                System.out.println("Player Bust!");
                break;
            }else if(valuePlayer == 21){
                System.out.println("Blackjack!");
                break;
            }

            System.out.println("Hit or Stand: ");

            s = HitStand.nextLine();
            s = s.toLowerCase();
            choice = s.charAt(0);
        }

        HitStand.close();

        boolean DealerCanHit = true;
        int ValueDealer = CountValue(DealerCards);

        //Show Dealers hand
        System.out.println("Dealers cards: " + DealerCards.get(0) + ", " + DealerCards.get(1));


        //Check if Dealers hand is above the required 16 value
        if(ValueDealer > 16) DealerCanHit = false;

        /**
         * If the value of all cards in the dealers hand is below 17, they will hit until:
         * A - The value of all cards in the dealers hand is equal to, or above, 17
         * B - They hit Blackjack
         * C - They Bust (Value of all cards above 21) 
         */
        if(DealerCanHit){
            do{
                int Random = ThreadLocalRandom.current().nextInt(0, cards.size() + 1);

                DealerCards.add(cards.get(Random));//Adds card to Dealers Hand
                cards.remove(Random);//Removes Card from the Deck of Cards

                ValueDealer = CountValue(DealerCards);

                System.out.print("Dealers hand: " + DealerCards.get(0));
                for(int i = 1; i < DealerCards.size(); i++){
                    System.out.print(", " + DealerCards.get(i));
                }
                System.out.println("");
                System.out.println("Value of cards in hand: " + ValueDealer);
                if(ValueDealer > 21){
                    System.out.println("Dealer Bust!");
                    break;
                }else if(ValueDealer == 21){
                    System.out.println("Blackjack!");
                    break;
                }
            }while(ValueDealer < 17);
        }

        ChooseWinner(ValueDealer, valuePlayer);
        
    }

    /**
     * Method to create the deck of cards as well as shuffle them
    * @param cards an empty Arraylist
    * @return  the shuffled deck of cards
    */
    public static ArrayList<String> CreateDeck(ArrayList<String> cards){
        //Add the 'A's to the ArrayList
        for(int i = 0; i < 4; i++){
            cards.add("A");
        }

        //Add the 2s through 10s to the ArrayList
        for(int i = 0; i < 4; i++){
            for(int j = 2; j < 11; j++){
                cards.add(String.valueOf(j));
            }
        }

        //Add the Face Cards to the ArrayList
        for(int i = 0; i < 4; i++){
            cards.add("10");
        }

        //Shuffle the cards
        Collections.shuffle(cards);

        return cards;
    }

    /**
     * Method to count the value of all cards in dealers hand
     * @param cards The ArrayList of all the cards in the dealers hand
     * @return  The combined value of all cards in the dealers hand
     */
    public static int CountValue(ArrayList<String> cards){
        int value = 0;
        int a = 0;

        for(int i = 0; i < cards.size(); i++){
            if(cards.get(i) == "A"){
                a++;
            }
            else{
                value += Integer.valueOf(cards.get(i));
            }
        }

        if(a != 0){
            if(value + 11 > 21){
                return (value + 1);
            }
            else{
                return (value + 11);
            }
        }

        return value;
    }

    /**
     * Method to choose the winner of the match
     * @param Dealer the total value in the dealers deck
     * @param Player the total value in the players deck
     */
    public static void ChooseWinner(int Dealer, int Player){
        boolean PlayerWin = false;
        boolean DealerWin = false;
        
        //Case for when player is above 21
        if(Player > 21){
            if(Dealer <= 21){
                DealerWin = true;
            }
        }else{
            if(Dealer <= 21){
                if(Player > Dealer) PlayerWin = true;
                else if(Player < Dealer) DealerWin = true;
            }else{
                PlayerWin = true;
            }
        }

        if(PlayerWin) System.out.println("Player Wins!");
        else if (DealerWin) System.out.println("Dealer Wins!");
        else System.out.println("Game Tied!");
    }
}
