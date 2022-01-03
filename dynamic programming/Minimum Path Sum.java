https://leetcode.com/problems/minimum-path-sum/

class Solution {
    public int minPathSum(int[][] grid) 
    {
        int min=0;
        
        int m=grid.length;
        int n=grid[0].length;
        
        int dp[][]=new int[m][n];
                
        for(int i=m-1;i>=0;i--)
        {
            for(int j=n-1;j>=0;j--)
            {
                if(i+1 >=m && j+1>=n)
                {
                    min=0;
                }
                else if(i+1>=m)
                {
                    min=dp[i][j+1];
                }
                else if(j+1>=n)
                {
                    min=dp[i+1][j];
                }
                else
                {
                     min = Math.min(dp[i][j+1],dp[i+1][j]);
                }  
                dp[i][j] = min + grid[i][j];
            }            
        }
        
        return dp[0][0];
        
    }
}
