/**
 * Merge Sort 
 * 
 * Merge Sort is a sorting algorithm that divides a given list into smaller sub-lists, sorts those sub-lists recursively, 
 * and then merges them back together to produce a sorted list.
 * 
 * The algorithm works by repeatedly dividing the input list in half until each sublist contains only one element, which is already sorted. 
 * The two smaller sorted sublists are then merged by comparing the elements in them and placing them in the correct order in a new list.
 * 
 * Time Complexity: O(n * log(n))
 * 
 * In this Exemple, I will create 3 different arrays, 
 * their sizes will be: 5, 10, 15 respectively.
 * then I shall create 4 different arrays, their sizes will be:
 * 1000, 10000, 100000, 1000000,
 * These Arrays will be used to test the efficiency of the Sorting method
 * Then I will put the numbers in those arrays in order by utilizing the Merge Sort Algorithm
 * 
 * Results of Test:
 * Hardware:
 * CPU: Intel Core i5 - 10400F 2.90 GHz
 * RAM: 16 GB, 2944 MHz
 * 
 * Time(Milliseconds):
 * Array 1.000 (One Thousand): 0 ms
 * Array 10.000 (Ten Thousand): 1 ms
 * Array 100.000 (One Houndred Thousand): 18 ms
 * Array 1.000.000 (One Million): 144 ms
 */

package Sorting_Algorithms;
import java.util.concurrent.ThreadLocalRandom;

public class MergeSort {
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


        System.out.println("Exemple of Merge Sort: ");

        System.out.println("The first array, before sorting: ");
        Print(Array1);

        //Sorting the first array with Merge Sort
        Sort(Array1);

        System.out.println("The first array, after sorting with Merge Sort: ");
        Print(Array1);

        System.out.println("*************************************************************************************");
        System.out.println("The second array, before sorting: ");
        Print(Array2);

        Sort(Array2);

        System.out.println("The second array, after sorting with Merge Sort: ");
        Print(Array2);
        
        System.out.println("*************************************************************************************");
        System.out.println("The third array, before sorting: ");
        Print(Array3);

        Sort(Array3);

        System.out.println("The third array, after sorting with Merge Sort: ");
        Print(Array3);

        System.out.println("*************************************************************************************");

        System.out.println("Now we will test the efficiency of Merge Sort with bigger arrays: ");
        System.out.println("This may take a while... ");

        System.out.println();

        long startTime = System.nanoTime();
        Sort(EfecientArray1k);
        long endTime = System.nanoTime();

        long duration = (endTime - startTime);

        duration = duration / 1000000;

        System.out.println("The time (in Milliseconds) for an array of size 1,000(1 thousand) is: " + duration + " ms");

        long startTime2 = System.nanoTime();
        Sort(EfecientArray10k);
        long endTime2 = System.nanoTime();

        long duration2 = (endTime2 - startTime2);

        duration2 = duration2 / 1000000;

        System.out.println("The time (in Milliseconds) for an array of size 10,000(10 thousand) is: " + duration2 + " ms");

        long startTime3 = System.nanoTime();
        Sort(EfecientArray100k);
        long endTime3 = System.nanoTime();

        long duration3 = (endTime3 - startTime3);

        duration3 = duration3 / 1000000;

        System.out.println("The time (in Milliseconds) for an array of size 100,000(100 thousand) is: " + duration3 + " ms");

        long startTime4 = System.nanoTime();
        Sort(EfecientArray1mil);
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
     * Method that will get the left and right point of the array
     * @param array Unsorted Array
     */
    public static void Sort(int[] array){
        int left = 0;
        int right = array.length - 1;

        Sort(array, left, right);
    }

    /**
     * Main function that sorts the array using Merge()
     * @param array Unsorted array
     * @param left left index in the array
     * @param right right index in the array
     */
    static void Sort(int[] array, int left, int right){
        if(left < right){
            int middle = (left + (right - 1)) / 2;

            Sort(array, left, middle);
            Sort(array, middle + 1, right);

            Merge(array, left, middle, right);
        }      
    }
    
    /**
     * The Merge Method
     * @param array Array with unsorted elements
     * @param left Left index
     * @param middle Middle index
     * @param right Right index
     */
    public static void Merge(int[] array, int left, int middle, int right){

        //Finds the size of the two subarrays
        int size1 = middle - left + 1;
        int size2 = right - middle;

        //Creates 2 temporary arrays
        int[] Left = new int[size1];
        int[] Right = new int[size2];

        //Copies the numbers in the arrays to the temporary arrays
        for(int i = 0; i < size1; i++){
            Left[i] = array[left + i];
        }

        for(int i = 0; i < size2; i++){
            Right[i] = array[middle + 1 + i];
        }

        //Merging the temporary arrays

        int i = 0; int j = 0;

        int k = left;

        while(i < size1 && j < size2){
            if(Left[i] <= Right[j]){
                array[k] = Left[i];
                i++;
            }else{
                array[k] = Right[j];
                j++;
            }
            k++;
        }

        //Adds the remaining elements if there are any
        while(i < size1){
            array[k] = Left[i];
            i++;
            k++;
        }

        while(j < size2){
            array[k] = Right[j];
            j++;
            k++;
        }
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
