import java.util.*;

public class P2 {
    static int longestIncreasingSubsequence(int arr[], int n) {

        int dp[][] = new int[n + 1][n + 1];

        for (int ind = n - 1; ind >= 0; ind--) {
            for (int prev_index = ind - 1; prev_index >= -1; prev_index--) {

                int notTake = 0 + dp[ind + 1][prev_index + 1];

                int take = 0;

                if (prev_index == -1 || arr[ind] > arr[prev_index]) {

                    take = 1 + dp[ind + 1][ind + 1];
                }

                dp[ind][prev_index + 1] = Math.max(notTake, take);

            }
        }

        return dp[0][0];
    }

public static void main(String args[]) {
	
	int arr[] = {10,9,2,5,3,7,101,18};
	
	int n = arr.length;
	
	System.out.println("The length of the longest increasing subsequence is"+longestIncreasingSubsequence(arr,n));
	
}
}
// Output:

// The length of the longest increasing subsequence is 4

// Time Complexity: O(N*N)

// Reason: There are two nested loops

// Space Complexity: O(N*N)

// Reason: We are using an external array of size ‘(N+1)*(N+1)’. Stack Space is
// eliminated.

    static int longestIncreasingSubsequence1(int arr[], int n) {

        int dp[] = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 0; i <= n - 1; i++) {
            for (int prev_index = 0; prev_index <= i - 1; prev_index++) {

                if (arr[prev_index] < arr[i]) {
                    dp[i] = Math.max(dp[i], 1 + dp[prev_index]);
                }
            }
        }

        int ans = -1;

        for (int i = 0; i <= n - 1; i++) {
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }

    // Output:

    // The length of the longest increasing subsequence is 4

    // Time Complexity: O(N*N)

    // Reason: There are two nested loops.

    // Space Complexity: O(N)

    // Reason: We are only using two rows of size ‘N’.

    static int longestIncreasingSubsequence(int arr[], int n) {

        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int[] hash = new int[n];
        Arrays.fill(hash, 1);

        for (int i = 0; i <= n - 1; i++) {

            hash[i] = i; // initializing with current index
            for (int prev_index = 0; prev_index <= i - 1; prev_index++) {

                if (arr[prev_index] < arr[i] && 1 + dp[prev_index] > dp[i]) {
                    dp[i] = 1 + dp[prev_index];
                    hash[i] = prev_index;
                }
            }
        }

        int ans = -1;
        int lastIndex = -1;

        for (int i = 0; i <= n - 1; i++) {
            if (dp[i] > ans) {
                ans = dp[i];
                lastIndex = i;
            }
        }

        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(arr[lastIndex]);

        while (hash[lastIndex] != lastIndex) { // till not reach the initialization value
            lastIndex = hash[lastIndex];
            temp.add(arr[lastIndex]);
        }

        // reverse the array

        System.out.print("The subsequence elements are ");

        for (int i = temp.size() - 1; i >= 0; i--) {
            System.out.print(temp.get(i) + " ");
        }
        System.out.println();

        return ans;
    }

    public static void main(String args[]) {
        
        int arr[] = {10,9,2,5,3,7,101,18};
        
        int n = arr.length;
        longestIncreasingSubsequence(arr,n);
        
    }
// Output:

// The subsequence elements are 2 5 7 101

// Time Complexity: O(N*N)

// Reason: There are two nested loops.

// Space Complexity: O(N)

// Reason: We are only using two rows of size ‘N’.