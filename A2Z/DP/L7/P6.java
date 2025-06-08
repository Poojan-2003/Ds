import java.util.Arrays;

public class P6 {

    public static int longestBitonicSequence(int[] arr, int n) {

        int dp_front[] = new int[n];
        int dp_back[] = new int[n];
        int maxi = Integer.MIN_VALUE;

        Arrays.fill(dp_front,1);
        Arrays.fill(dp_back,1);

        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j] && dp_front[j]+1>dp_front[i]){
                    dp_front[i] = dp_front[j]+1;
                }   
            }
        }

        // arr = Collections.reverse(Arrays.asList(arr));
             int start = 0, end = n-1;
    
     while(start<end){
        int temp = arr[start];
        arr[start]=arr[end];
        arr[end]=temp;
        start++;
        end--;
     }
        
        // System.out.printl n( Collections.reverse(Arrays.asList(arr)));
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j] && dp_back[j]+1>dp_back[i]){
                    dp_back[i] = dp_back[j]+1;
                }   
            }
        }
        start = 0;
        end = n-1;
        while(start<end){
        int temp = dp_back[start];
        dp_back[start]=dp_back[end];
        dp_back[end]=temp;
        start++;
        end--;
     }

        for(int i=0;i<dp_front.length;i++){
            maxi = Math.max(maxi,dp_front[i]+dp_back[i]-1);
        }
        // System.out.println(Arrays.toString(arr));
        // System.out.println(Arrays.toString(dp_back));
        // System.out.println(Arrays.toString(dp_front));
        return maxi;
    }
}

    
