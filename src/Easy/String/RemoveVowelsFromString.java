package Easy.String;

import java.util.HashSet;
import java.util.Set;

/*
Given a string S, remove the vowels 'a', 'e', 'i', 'o', and 'u' from it, and return the new string.

Example 1:

Input: "leetcodeisacommunityforcoders"
Output: "ltcdscmmntyfrcdrs"
Example 2:

Input: "aeiou"
Output: ""
 */
public class RemoveVowelsFromString {

    public static void main(String args[]) {
        String str = "leetcodeisacommunityforcoders";
        System.out.println(replaceVowels(str));
        System.out.println(replaceVowelsRegex(str));
        System.out.println(replaceVowelsSet(str));
    }

    /*
        Using Character Array and String Buffer

        Time Complexity O(n)
     */
    public static String replaceVowels(String str) {
        char[] charArray = str.toCharArray();

        StringBuffer newStr = new StringBuffer();

        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] != 'a' && charArray[i] != 'e' &&
                    charArray[i] != 'i' && charArray[i] != 'o' && charArray[i] != 'u')
                newStr.append(charArray[i]);
        }
        return newStr.toString();
    }

    /*
        Using Regular Expressions
     */
    public static String replaceVowelsRegex(String str) {
        return str.replaceAll("[aeiou]","");
    }

    /*
      Using Set and StringBuffer
      Time Complexity : O(n)

     **/
    public static String replaceVowelsSet(String str) {
        if (str == null || str.length() == 0) return str;

        Set<Character> vowelsSet = new HashSet<>();
        vowelsSet.add('a');
        vowelsSet.add('e');
        vowelsSet.add('i');
        vowelsSet.add('o');
        vowelsSet.add('u');

        StringBuffer newStr = new StringBuffer();

        char[] charArray = str.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            if(!vowelsSet.contains(charArray[i])) {
                newStr.append(charArray[i]);
            }
        }
        return newStr.toString();

    }
}
