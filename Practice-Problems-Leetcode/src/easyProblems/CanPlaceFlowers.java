package easyProblems;


public class CanPlaceFlowers {
	
	// leet-code :  https://leetcode.com/problems/can-place-flowers/
	// 605. Can Place Flowers

	 public boolean canPlaceFlowers(int[] flowerbed, int n) {
	        int count = 0;
	        if (count == n) return true;
	        if ((flowerbed.length == 1 && n == 1 && flowerbed[0] == 0)) return true;
	        for(int i = 0; i < flowerbed.length;i++) {
	            if (flowerbed[i] == 0) {
	                if (i == 0) {
	                    if ( flowerbed[i + 1] == 0) {
	                        flowerbed[i] = 1;
	                        count++;
	                        if (count == n) return true;
	                    }
	                } else if (i == flowerbed.length - 1) {
	                    if ( flowerbed[i - 1] == 0) {
	                        flowerbed[i] = 1;
	                        count++;
	                        if (count == n) return true;
	                    }     
	                }
	                 else if (flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
	                     flowerbed[i] = 1;
	                     count++;
	                     if (count == n) return true;
	                 }
	            }
	        }
	        return false;
	    }
	 
	    public static void main(String[] args) {
	    	int[] flowers_Array = {1,0,0,0,0,0,0,0,0,0,0,0,0,1};
	    	boolean answer = new CanPlaceFlowers().canPlaceFlowers(flowers_Array, 5);
	        System.out.println(answer);
	    }

}
