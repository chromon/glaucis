/*
925. Long Pressed Name
Easy

Your friend is typing his name into a keyboard. Sometimes, when typing a character c, the key might get long pressed, and the character will be typed 1 or more times.

You examine the typed characters of the keyboard. Return True if it is possible that it was your friends name, with some characters (possibly none) being long pressed.

 

Example 1:

Input: name = "alex", typed = "aaleex"
Output: true
Explanation: 'a' and 'e' in 'alex' were long pressed.
Example 2:

Input: name = "saeed", typed = "ssaaedd"
Output: false
Explanation: 'e' must have been pressed twice, but it was not in the typed output.
 

Constraints:

1 <= name.length, typed.length <= 1000
name and typed consist of only lowercase English letters.
*/

class Solution {
    public boolean isLongPressedName(String name, String typed) {
        
        if (name.charAt(0) != typed.charAt(0)) {
            return false;
        }
        
        if (name.length() > typed.length()) {
            return false;
        }
        
        int i = 0;
        int j = 0;
        
        while (i < name.length() && j < typed.length()) {
            if (name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else if (name.charAt(i - 1) == typed.charAt(j)) {
                j++;
            } else {
                return false;
            }
        }
        
        if (i < name.length()) {
            return false;
        }
        
        for (int k = j;k < typed.length(); k++) {
            if (typed.charAt(j - 1) != typed.charAt(k)) {
                return false;
            }
        }
        
        return true;
    }
}