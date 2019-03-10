class Solution {
    public String reverseVowels(String s) {
        
        Set<Character> set = new HashSet<>();
        char[] c = s.toCharArray();
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        
        int i = 0, j = s.length() - 1;
        
        while (i < j) {
            if (set.contains(c[i]) && set.contains(c[j])) {
                char tmp = c[i];
                c[i] = c[j];
                c[j] = tmp;
                i++;
                j--;
            } else if (!set.contains(c[i])) {
                i++;
            } else if (!set.contains(c[j])){
                j--;
            }
        }
        
        return new String(c);
    }
}