/**
 * Challenge By: Leetcode
 * 
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 * 
 * The overall run time complexity should be O(log (m+n)).
 * 
 * 
 * Time: 2 ms
 */

 class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int sizeof = nums1.length + nums2.length;
        double result = 0;
        
        
        int[] NewArray = new int[sizeof];

        int a = 0, b = 0, i = 0;

        while(a < nums1.length && b < nums2.length){
            if(nums1[a] < nums2[b]){
                NewArray[i] = nums1[a];
                a++;
                i++;
            }else if(nums1[a] > nums2[b]){
                NewArray[i] = nums2[b];
                b++;
                i++;
            }else{
                NewArray[i] = nums1[a];
                a++;
                i++;
            }
        }

        while(a < nums1.length){
            NewArray[i] = nums1[a];
            a++;
            i++;
        }

        while(b < nums2.length){
            NewArray[i] = nums2[b];
            b++;
            i++;
        }
        
        if(sizeof % 2 == 0){
            result = (NewArray[sizeof / 2] + NewArray[(sizeof / 2) - 1]);
            result /= 2;
        }else{
            result = NewArray[sizeof / 2];
        }

        return result;
    }
}