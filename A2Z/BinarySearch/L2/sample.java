public class sample {

    public static int func(int mid,int N){
        int ans =1;
        for(int i=1;i<=N;i++){
            ans *= mid;
        }
        return ans;
    }

    public static int NthRoot(int N, int M) {
        int low = 1;
        int high = M;

        while(low<=high){
            int mid = low + (high-low)/2;
            if(func(mid, N) == m)return mid;
            if(func(mid,N)>M){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return high;
        
    }
    public static void main(String[] args) {
        System.out.println("heello");
        System.out.println(NthRoot(4,69));
    }
}
