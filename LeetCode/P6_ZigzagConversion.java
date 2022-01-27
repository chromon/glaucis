/*
6. Zigzag Conversion
Medium

The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);
 

Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:
P     I    N
A   L S  I G
Y A   H R
P     I
Example 3:

Input: s = "A", numRows = 1
Output: "A"
 

Constraints:

1 <= s.length <= 1000
s consists of English letters (lower-case and upper-case), ',' and '.'.
1 <= numRows <= 1000
*/

class Solution {
    /*
        字符串 s 是以 Z 字形为顺序存储的字符串，设 numRows 行字符串分别为 s_1, s_2,..., s_n，
        
        则易发现：按顺序遍历字符串 s 时，每个字符 c 在 Z 字形中对应的 行索引 先从 s_1 
        增大至 s_n，再从 s_n 减小至 s_1 …… 如此反复。

        模拟这个行索引的变化，在遍历 s 中把每个字符填到正确的行 res[i]，从 0 到 numRows - 1，再到 0，如此反复
        
        s = "abcdefg", numRows = 3;
        
        a   e   res[0]: a e
        b d f   res[1]: bdf
        c   g   res[2]: c g
    */
    public String convert(String s, int numRows) {
        
        if (numRows < 2) {
            return s;
        }
        
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }
        
        int t = 0;
        int flag = -1;
        for (int i = 0; i < s.length(); i++) {
            list.get(t).append(s.charAt(i));
            if (t == 0 || t == numRows - 1) {
                flag *= -1; 
            }
            t += flag;
        }
        
        StringBuilder res = new StringBuilder();
        for (StringBuilder sb: list) {
            res.append(sb);
        }
        return res.toString();
    }
}