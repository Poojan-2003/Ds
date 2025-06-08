public class P2 {
    public int dfs(int i,int j,int [][]grid){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j] != 1){
            return 0;
        }

        grid[i][j] = 0;
        int cnt = 1;

        cnt += dfs(i+1,j,grid);
        cnt += dfs(i,j+1,grid);
        cnt += dfs(i-1,j,grid);
        cnt += dfs(i,j-1,grid);

        return cnt;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    ans = Math.max(ans,dfs(i,j,grid));
                }
            }
        }
        return ans;
    }
}
