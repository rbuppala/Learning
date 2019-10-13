package Medium;

import java.util.HashSet;
import java.util.Set;

/*
    Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstrWithoutRepeat {

    public static void main(String args[]) {
        String str = "pwwkew";
        System.out.println(longestSubstr(str));
        System.out.println(longestSubstrSlidingTwoPointer(str));
    }

    /*
            Brute Force
            Time complexity : O(n^3)

            Iterate through all the possible substrings of the given string s
            and call the function allUnique to see if they are unique
     */
    public static int longestSubstr(String str) {

        int length = str.length();
        int ans = 0;

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j <= length; j++) {
                if(isAllUnique(str, i, j)) ans = Math.max(ans, (j - i));
            }
        }
        return ans;
    }

    private static boolean isAllUnique(String str, int i, int j) {
        char[] charArray = str.substring(i,j).toCharArray();
        Set<Character> charSet = new HashSet<>();

        for(Character ch: charArray) {
            if (charSet.contains(ch)) {
                return false;
            }
            charSet.add(ch);
        }
        return true;
    }

    /*
        Sliding Window Technique

        Two pointers

        Time Complexity O(n)
     */
    public static int longestSubstrSlidingTwoPointer(String str) {
        int n = str.length();
        int ans = 0, i = 0, j = 0;
        Set<Character> charSet = new HashSet<>();
        while (i < n && j <n) {
            if (!charSet.contains(str.charAt(j))) {
                charSet.add(str.charAt(j++));
                ans = Math.max(ans, (j - i));
            } else {
                charSet.remove(str.charAt(i++));
            }
        }
        return ans;
    }
}
