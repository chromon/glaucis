class Solution {
    public boolean judgeCircle(String moves) {
        
        if (moves.length() == 0) {
            return true;
        }
        
        int h = 0;
        int v = 0;
        
        for (int i = 0; i < moves.length(); i++) {
            if (moves.charAt(i) == 'R') {
                h += 1;
            } else if (moves.charAt(i) == 'L') {
                h -= 1;
            }
            
            if (moves.charAt(i) == 'U') {
                v += 1;
            } else if (moves.charAt(i) == 'D') {
                v -= 1;
            } 
        }
        
        return h == 0 && v == 0;
    }
}