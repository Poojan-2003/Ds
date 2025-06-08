public class P1{
    public void dfs(int i,int j,char[][]grid,boolean[][]vis){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j] == '0' || vis[i][j])return;
        
        // if(grid[i][j] == '1'){
            vis[i][j] = true;
        // }

        dfs(i+1,j,grid,vis);
        dfs(i,j+1,grid,vis);
        dfs(i-1,j,grid,vis);
        dfs(i,j-1,grid,vis);
    }
    public int numIslands(char[][] grid) {
        int ans =0;
        boolean vis[][] = new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == '1' && !vis[i][j]){
                    ans++;
                    dfs(i,j,grid,vis);
                }
            }
        }
        return ans;
    }
}