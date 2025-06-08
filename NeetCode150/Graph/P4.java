public class P4 {
    // [[INF,  -1,   0, INF],
    // [INF, INF, INF,  -1],
    // [INF,  -1, INF,  -1],
    // [  0,  -1, INF, INF]]

    // Output (after running your function):
    // [[  3,  -1,   0,   1],
    // [  2,   2,   1,  -1],
    // [  1,  -1,   2,  -1],
    // [  0,  -1,   3,   4]]

    public void dfs(int [][] grid,int i,int j,int dis){
        if(i<0 || j<0 || i>=grid.length || j>= grid[0].length || grid[i][j] == 0 || grid[i][j] == -1)return ;

        if(dis<grid[i][j]){
            grid[i][j] = dis;
            dfs(grid, i+1, j, dis+1);
            dfs(grid, i, j+1, dis+1);
            dfs(grid, i-1, j, dis+1);
            dfs(grid, i, j-1, dis+1);
        }
    }
    public int[][] wallsAndGate(int [][]grid){
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 0){
                    dfs(grid,i,j+1,1);
                    dfs(grid,i+1,j,1);
                    dfs(grid,i-1,j,1);
                    dfs(grid,i,j-1,1);
                }
            }
        }
        return grid;
    }
}
