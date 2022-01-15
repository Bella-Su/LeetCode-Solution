class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length; // number of rows
        int m = grid[0].length; // number of columns
        
        // i => row index for both robots
        // j1 => column index for 1st robot
        // j2 => column index for 2st robot
        Integer[][][] dp = new Integer[n][m][m];
        
        // 0, 0, m-1 is the initial position of two robots
        return dfs(grid, n, m, 0, 0, m-1, dp);
    }
    
    private int dfs(int[][] grid, int n, int m, int row, int col1, int col2, Integer[][][] dp){
        // base case (out of boundary)
        if(row<0 || row>=n || col1<0 || col1>=m || col2<0 || col2>=m)
            return 0;
        
        if(dp[row][col1][col2] != null)
            return dp[row][col1][col2];
        
        int maxCherries = 0;
        for(int i = -1; i <= 1; i++){
            for(int j = -1; j <= 1; j++){
                int newCol1 = col1 + i;
                int newCol2 = col2 + j;
                maxCherries = Math.max(maxCherries, dfs(grid, n, m, row+1, newCol1, newCol2, dp));
            }
        }
        int currCherry = 0;
        // if two robot are in the same position, add the cherry from robot1
        // otherwise, add from both
        if(col1 == col2)
            currCherry = grid[row][col1];
        else
            currCherry = grid[row][col1] + grid[row][col2];
        
        dp[row][col1][col2] = currCherry + maxCherries;
        return dp[row][col1][col2];
    }
}