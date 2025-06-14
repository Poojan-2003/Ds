import java.util.Arrays;

public class P1 {

    public static int Memoize(int idx, int last, int dp[][], int points[][]) {
        // Base case
        if (idx == 0) {
            int ans = 0;
            for (int i = 0; i < 3; i++) {
                if (i != last) {
                    ans = Math.max(ans, points[0][i]);
                }
            }
            return ans;
        }

        // If already computed, return the stored value
        if (dp[idx][last] != -1) return dp[idx][last];

        int maxi = 0;
        for (int i = 0; i < 3; i++) {
            if (i != last) {
                int point = points[idx][i] + Memoize(idx - 1, i, dp, points);
                maxi = Math.max(maxi, point);
            }
        }

        return dp[idx][last] = maxi;
    }

    public static int ninjaTraining(int n, int points[][]) {
        int dp[][] = new int[n][4];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        return Memoize(n - 1, 3, dp, points);
    }


    // Function to find the maximum points for ninja training
    static int Tabulation(int n, int[][] points) {
        // Initialize a 2D array 'dp' to store the maximum points
        int[][] dp = new int[n][4];
        
        // Initialize the first day's maximum points based on the available choices
        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][0], points[0][1]);
        dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        // Iterate through each day and each activity
        for (int day = 1; day < n; day++) {
            for (int last = 0; last < 4; last++) {
                dp[day][last] = 0; // Initialize the maximum points for the current day and last activity
                // Consider each possible task for the current day
                for (int task = 0; task <= 2; task++) {
                    if (task != last) { // Ensure that the current task is different from the last
                        // Calculate the points for the current activity and add it to the maximum points from the previous day
                        int activity = points[day][task] + dp[day - 1][task];
                        // Update the maximum points for the current day and last activity
                        dp[day][last] = Math.max(dp[day][last], activity);
                    }
                }
            }
        }

        // Return the maximum points achievable after all days (last activity is 3)
        return dp[n - 1][3];
    }

    public static void main(String args[]) {
        // Define the points for each activity on each day
        int[][] points = {{10, 40, 70},
                          {20, 50, 80},
                          {30, 60, 90}};

        int n = points.length; // Get the number of days
        System.out.println(ninjaTraining(n, points)); // Calculate and print the maximum points
    }
}


    

   

