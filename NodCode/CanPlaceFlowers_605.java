class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        
        int[] arr = new int[flowerbed.length + 2];
        
        for (int i = 1; i < arr.length - 1; i++) {
            arr[i] = flowerbed[i - 1];
        }
        
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] == 0 && arr[i - 1] == 0 && arr[i + 1] == 0) {
                n--;
                arr[i] = 1;
            }
        }
        
        return n <= 0;
    }
}