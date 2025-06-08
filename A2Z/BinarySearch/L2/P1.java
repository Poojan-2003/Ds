package L2;

public class P1 {
    public int mySqrt(int x) {
        int ans = 0;
        // linear search on the answer space
        for (long i = 1; i <= x; i++) {
            long val = i * i;
            if (val <= (long) x) {
                ans = (int) i;
            } else {
                break;
            }
        }
        return ans;
    }

    public int mySqrt1(int x) {
        long low = 1;
        long high = x;

        while(low<=high){
            long mid = low + (high-low)/2;

            if(mid * mid == x)return (int)mid;
            else if(mid*mid > x){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return (int)high;
    }
}
