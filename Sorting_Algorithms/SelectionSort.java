/**
 * Selection Sort 
 * 
 * Selection sort is a simple, yet effective, sorting algorithm that works by repeatedly finding the minimum value in a list and swapping it with the first unsorted element in the list. 
 * This process is repeated for each unsorted element until the entire list is sorted.
 * 
 * The selection sort algorithm has a time complexity of O(n^2), where n is the number of elements. 
 * While it is not the most efficient sorting algorithm, it has the advantage of being simple to implement and requiring only a constant amount of additional memory space.
 * 
 * In this Exemple, I will create 3 different arrays, 
 * their sizes will be: 5, 10, 15 respectively.
 * then I shall create 4 different arrays, their sizes will be:
 * 1000, 10000, 100000, 1000000,
 * These Arrays will be used to test the efficiency of the Sorting method
 * Then I will put the numbers in those arrays in order by utilizing the Selection Sort Algorithm
 * 
 * Results of Test:
 * Hardware:
 * CPU: Intel Core i5 - 10400F 2.90 GHz
 * RAM: 16 GB, 2944 MHz
 * 
 * Time(Milliseconds):
 * Array 1.000 (One Thousand): 1 ms
 * Array 10.000 (Ten Thousand): 24 ms
 * Array 100.000 (One Houndred Thousand): 2240 ms
 * Array 1.000.000 (One Million): 221093 ms (3 Minutes 41 Seconds and 93 Milliseconds)
 */

package Sorting_Algorithms;
import java.util.concurrent.ThreadLocalRandom;

public class SelectionSort {
    public static void main(String[] args){
        //Creation of the arrays
        int[] Array1 = new int[5];
        int[] Array2 = new int[10];
        int[] Array3 = new int[15];

        //Creation of the eficiency test arrays
        int[] EfecientArray1k = new int[1000];
        int[] EfecientArray10k = new int[10000];
        int[] EfecientArray100k = new int[100000];
        int[] EfecientArray1mil = new int[1000000];

        //Filling the arrays with random integer numbers
        Array1 = GenArray(Array1);
        Array2 = GenArray(Array2);
        Array3 = GenArray(Array3);
        EfecientArray1k = GenArray(EfecientArray1k);
        EfecientArray10k = GenArray(EfecientArray10k);
        EfecientArray100k = GenArray(EfecientArray100k);
        EfecientArray1mil = GenArray(EfecientArray1mil);


        System.out.println("Exemple of Selection Sort: ");

        System.out.println("The first array, before sorting: ");
        Print(Array1);

        //Sorting the first array with Selection Sort
        Array1 = Sort(Array1);

        System.out.println("The first array, after sorting with Selection Sort: ");
        Print(Array1);

        System.out.println("*************************************************************************************");
        System.out.println("The second array, before sorting: ");
        Print(Array2);

        Array2 = Sort(Array2);

        System.out.println("The second array, after sorting with Selection Sort: ");
        Print(Array2);
        
        System.out.println("*************************************************************************************");
        System.out.println("The third array, before sorting: ");
        Print(Array3);

        Array3 = Sort(Array3);

        System.out.println("The third array, after sorting with Selection Sort: ");
        Print(Array3);

        System.out.println("*************************************************************************************");

        System.out.println("Now we will test the efficiency of Selection Sort with bigger arrays: ");
        System.out.println("This may take a while... ");

        System.out.println();

        long startTime = System.nanoTime();
        EfecientArray1k = Sort(EfecientArray1k);
        long endTime = System.nanoTime();

        long duration = (endTime - startTime);

        duration = duration / 1000000;

        System.out.println("The time (in Milliseconds) for an array of size 1,000(1 thousand) is: " + duration + " ms");

        long startTime2 = System.nanoTime();
        EfecientArray10k = Sort(EfecientArray10k);
        long endTime2 = System.nanoTime();

        long duration2 = (endTime2 - startTime2);

        duration2 = duration2 / 1000000;

        System.out.println("The time (in Milliseconds) for an array of size 10,000(10 thousand) is: " + duration2 + " ms");

        long startTime3 = System.nanoTime();
        EfecientArray100k = Sort(EfecientArray100k);
        long endTime3 = System.nanoTime();

        long duration3 = (endTime3 - startTime3);

        duration3 = duration3 / 1000000;

        System.out.println("The time (in Milliseconds) for an array of size 100,000(100 thousand) is: " + duration3 + " ms");

        long startTime4 = System.nanoTime();
        EfecientArray1mil = Sort(EfecientArray1mil);
        long endTime4 = System.nanoTime();

        long duration4 = (endTime4 - startTime4);

        duration4 = duration4 / 1000000;

        System.out.println("The time (in Milliseconds) for an array of size 1,000,000(1 million) is: " + duration4 + " ms");
    }

    /**
     * Method to generate the random numbers in the arrays
     * @param array the empty arrays
     * @return  Arrays with random numbers added into them
    */
    public static int[] GenArray(int[] array){

        for(int i = 0; i < array.length; i++){
            int Random = ThreadLocalRandom.current().nextInt(0, Integer.MAX_VALUE - 1);

            array[i] = Random;
        }

        return array;
    }


    /**
     * Selection Sort Algorithm
     * @param array Array with random numbers in random order
     * @return  Sorted Array
    */
    public static int[] Sort(int[] array){

        //Will move through the array, 1-by-1
        for(int i = 0; i < array.length - 1; i++){
            int IndexMin = i; 

            for(int j = i + 1; j < array.length; j++){
                if(array[IndexMin] > array[j]){
                    IndexMin = j;
                }
            }

            int temp = array[IndexMin];
            array[IndexMin] = array[i];
            array[i] = temp;
        }

        return array;
    }

    /**
     * Method to print out the arrays
     * @param array The array full of integers
    */
    public static void Print(int[] array){
        for(int i = 0; i < array.length; i++){
            System.out.println(array[i]);
        }
    }
}
