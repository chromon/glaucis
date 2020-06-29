class Solution {
    public String toGoatLatin(String S) {
        
        Character[] c = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        Set<Character> set = new HashSet<>(Arrays.asList(c));
        
        String[] sa = S.split(" ");
        
        for (int i = 0; i < sa.length; i++) {
            
            if (set.contains(sa[i].charAt(0))) {
                sa[i] += "ma";
            } else {
                sa[i] = sa[i].substring(1) + Character.toString(sa[i].charAt(0)) + "ma";
            }
            
            for (int j = 0; j <= i; j++) {
                sa[i] += "a";
            }
        }
        
        String res = "";
        String tmp = "";
        for (int i = 0; i < sa.length; i++) {
            res = res + tmp + sa[i];
            tmp = " ";
        }
        
        return res;
    }
}