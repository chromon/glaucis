class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        
        // rec1{x1, y1, x2, y2} rec2{x3, y3, x4, y4}
        //       0   1   2   3        0   1   2   3
        
        if (rec1[2] <= rec2[0] || rec1[0] >= rec2[2]) {
           return false; 
        } 
  
        if (rec1[3] <= rec2[1] || rec1[1] >= rec2[3]) {
            return false;
        }  
  
        return true;
    }
}