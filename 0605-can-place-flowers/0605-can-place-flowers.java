class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) return true;  
        if (flowerbed.length == 0) return false;
        
        if (flowerbed[0] == 0 && 
            (flowerbed.length == 1 || flowerbed[1] == 0)) {
            flowerbed[0] = 1;
            n--;
            if (n <= 0) return true;
        }
        
        for (int i = 1; i < flowerbed.length-1; i++) {
            if (flowerbed[i-1] != 1 && 
                flowerbed[i+1] != 1 && flowerbed[i] == 0) {
                flowerbed[i] = 1; 
                n--;
                if (n <= 0) return true;
                i++;
            }
        }
        
        if (flowerbed.length > 1 && 
            flowerbed[flowerbed.length-1] == 0 && 
            flowerbed[flowerbed.length-2] == 0) {
            n--;
            if (n <= 0) return true;
        }
        
        return n <= 0;
    }
}