package Easy.Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/*
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].

 */
public class TwoSum {

    public static void main(String args[]) {
        int[] array = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(array,target)));
        System.out.println(Arrays.toString(twoSumHash(array,target)));
    }

    /*
        Iterate array with two loops
        Time complexity : O(n^2)
        Space Complexity: O(n)
     */
    public static int[] twoSum(int[] array, int target) {
       for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i]+ array[j] == target) {
                  return new int[] {i,j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }


    public static int[] twoSumHash(int[] array, int target) {
        Map<Integer, Integer> numsMap = new Hashtable<>();

        for (int i = 0; i < array.length; i++) {
            if(numsMap.containsKey(target - array[i])) {
                return new int[] {numsMap.get(target - array[i]), i};
            } else {
                numsMap.put(array[i], i);
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

}
