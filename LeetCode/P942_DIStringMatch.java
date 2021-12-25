/*
942. DI String Match
Easy

A permutation perm of n + 1 integers of all the integers in the range [0, n] can be represented as a string s of length n where:

s[i] == 'I' if perm[i] < perm[i + 1], and
s[i] == 'D' if perm[i] > perm[i + 1].
Given a string s, reconstruct the permutation perm and return it. If there are multiple valid permutations perm, return any of them.

 

Example 1:

Input: s = "IDID"
Output: [0,4,1,3,2]
Example 2:

Input: s = "III"
Output: [0,1,2,3]
Example 3:

Input: s = "DDI"
Output: [3,2,0,1]
 

Constraints:

1 <= s.length <= 105
s[i] is either 'I' or 'D'.
*/

class Solution {
    /*
    public int[] diStringMatch(String s) {
        
        List<Integer> list = new ArrayList<>();
        int m = 0;
        int n = s.length();
        
        for (int i = 0, j = s.length(); i < s.length(); i++) {
            if (s.charAt(i) == 'I') {
                list.add(m++);
            } else {
                list.add(n--);
            }
        }
        
        list.add(n);
        
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }
    */

    public int[] diStringMatch(String s) {
        int[] res = new int[s.length() + 1];
        int m = 0;
        int n = s.length();
        int j = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'I') {
                res[j] = m++;
            } else {
                res[j] = n--;
            }
            j++;
        }
        
        res[j] = n;
        return res;
    }
}