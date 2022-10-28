package week43;

//https://leetcode.com/problems/split-array-largest-sum/
public class SplitArray {
 public static void main(String[] args) {
/*
 * Example 1:

Input: nums = [7,2,5,10,8], k = 2
Output: 18
Explanation: There are four ways to split nums into two subarrays.
The best way is to split it into [7,2,5] and [10,8], where the largest sum among the two subarrays is only 18.

Example 2:

Input: nums = [1,2,3,4,5], k = 2
Output: 9
Explanation: There are four ways to split nums into two subarrays.
The best way is to split it into [1,2,3] and [4,5], where the largest sum among the two subarrays is only 9.

 */
	 int[] nums= {7,2,5,10,8};
	 int k=2;
	 SplitArray sa=new SplitArray();
	 System.out.println(sa.splitArray(nums, k));
 }

 public int splitArray(int[] nums, int m) {
     int start = 0;
     int end = 0;

     for (int i = 0; i < nums.length; i++) {
         start = Math.max(start, nums[i]); // in the end of the loop this will contain the max item of the array
         end += nums[i];
     }

     // binary search
     while (start < end) {
         // try for the middle as potential ans
         int mid = start + (end - start) / 2;

         // calculate how many pieces you can divide this in with this max sum
         int sum = 0;
         int pieces = 1;
         for(int num : nums) {
             if (sum + num > mid) {
                 // you cannot add this in this subarray, make new one
                 // say you add this num in new subarray, then sum = num
                 sum = num;
                 pieces++;
             } else {
                 sum += num;
             }
         }

         if (pieces > m) {
             start = mid + 1;
         } else {
             end = mid;
         }

     }
     return end; // here start == end
 }
}