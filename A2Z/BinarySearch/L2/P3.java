package L2;

import java.util.Arrays;

public class P3 {
    class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        long low = 1;
        long high = piles[piles.length-1];
        long mini = Long.MAX_VALUE;
        while(low<=high){
            long mid = low + (high-low)/2;
            long hours = 0;
            for(int i=0;i<piles.length;i++){
                hours = hours + (piles[i]% mid == 0 ? piles[i]/mid : (piles[i]/mid)+1);
                // System.out.println(i+" i "+piles[i]%mid + " mid "+mid);
            }
            // System.out.println(mid+"hours"+hours);
            if(hours>h){
                low = mid+1;
            }else{
                high = mid-1;
            }

            if(hours<=h)mini = Math.min(mini,mid);
        }
        return (int)mini;
    }
}
}
