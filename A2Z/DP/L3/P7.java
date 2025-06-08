public class P7 {
	/* 
	*	2,3,1,2
	*	3,4,2,2
	*	5,6,3,5
	*/
	public static int Memoization(int i,int j,int grid[][],int dp[][]){
		if(i==grid.length){
			if(j==0){
				return grid[i][j]+Math.max(dp[i-1][j],dp[i-1][j+1]);
			}else if(j==grid[0].length-1){
				return grid[i][j]+Math.max(dp[i-1][j],dp[i-1][j-1]);
			}else{
				return grid[i][j]+Math.max(dp[i-1][j],Math.max(dp[i-1][j-1],dp[i-1][j+1]));
			}
		}

		int temp = grid[i][j];
		grid[i][j] = 0;
		if(j==0){
			int second = temp + Memoization(i+1, j, grid, dp);
			int third = temp + Memoization(i+1, j+1, grid, dp);
			return dp[i][j] = Math.max(second, third);
		}else if(j==grid[0].length){
			int first = temp + Memoization(i+1, j-1, grid, dp);
			int second = temp + Memoization(i+1, j, grid, dp);
			return dp[i][j] = Math.max(first,second);
		}else{
			int first = temp + Memoization(i+1, j-1, grid, dp);
			int second = temp + Memoization(i+1, j, grid, dp);
			int third = temp + Memoization(i+1, j+1, grid, dp);
			return dp[i][j] = Math.max(first,Math.max(second, third));
		}
		
	}
	
	
	// public static int Memoization1
	public static int maximumChocolates(int r, int c, int[][] grid) {
		int dp[][] = new int[r][c];
		for(int i=grid.length-2;i>=0;i--){
			for(int j=0;j<grid[0].length;j++){
				if(j==0 && j+1<grid[0].length){
					dp[i][j] = grid[i][j]+Math.max(dp[i+1][j],dp[i+1][j+1]);
					grid[i][j] = 0;
				}else if(j==grid[0].length-1 && j-1>=0){
					dp[i][j] = grid[i][j]+Math.max(dp[i+1][j],dp[i+1][j-1]);
					grid[i][j] = 0;
				}else{
					dp[i][j] = grid[i][j]+Math.max(dp[i+1][j],Math.max(dp[i+1][j-1],dp[i+1][j+1]));
					grid[i][j] = 0;
				}
			}
		}
		return dp[0][0];
		
	}
	return Memoization(0,0,grid)+Memoization(0,c-1,grid);
}

