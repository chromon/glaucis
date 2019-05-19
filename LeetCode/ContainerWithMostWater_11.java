class Solution {
    /*public int maxArea(int[] height) {
        
        int area = 0;
        
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int min = Math.min(height[i], height[j]);
                area = area < min * (j - i) ? min * (j - i) : area;
            }
        }
        
        return area;
    }*/
    
    public int maxArea(int[] height) {
    
        int i = 0, j = height.length - 1;
        int area = 0;
        
        while (i < j) {
            
            int min = Math.min(height[i], height[j]);
            area = area < min * (j - i) ? min * (j - i) : area;
            
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        
        return area;
    }
}