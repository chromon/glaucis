class Solution {
    public boolean detectCapitalUse(String word) {
        
        char c = word.charAt(0);
        
        if (c >= 'a' && c <= 'z') {
            for (int i = 1; i < word.length(); i++) {
                if (word.charAt(i) < 'a' || word.charAt(i) > 'z') {
                    return false;
                }
            }
        } else {
            if (word.length() > 1) {
                char c2 = word.charAt(1);
                if (c2 >= 'a' && c2 <= 'z') {
                    for (int i = 2; i < word.length(); i++) {
                        if (word.charAt(i) < 'a' || word.charAt(i) > 'z') {
                            return false;
                        }
                    }
                } else {
                    for (int i = 2; i < word.length(); i++) {
                        if (word.charAt(i) >= 'a' && word.charAt(i) <= 'z') {
                            return false;
                        }   
                    }
                }
            }
        }
        
        return true;
    }
}