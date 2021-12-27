//https://leetcode.com/problems/number-of-islands/
//https://practice.geeksforgeeks.org/problems/find-the-number-of-islands/1#
//application of get connected components
//proactive and reactive calls

//Time complexity : O(M×N) where M is the number of rows and N is the number of columns.

//Space complexity : worst case O(M×N) in case that the grid map is filled with lands where DFS goes by M×N deep

class Solution {
    public int numIslands(char[][] grid) 
    {
      boolean visit[][] = new boolean[grid.length][grid[0].length];
      int count=0;
        
      for(int i=0;i<grid.length;i++)
      {
          for(int j=0;j<grid[i].length;j++)
          {
             if(grid[i][j]=='1' && visit[i][j]==false)
             {
                 dfs(grid,i,j,visit);
                 count++;
             }
          }
      }
      
        return count;
    }
    
    public void dfs(char[][]grid ,int i,int j,boolean[][]visit)
    {
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || 
           visit[i][j]==true || grid[i][j]=='0')   // reactive call 
        {
            return;
        }
        
        visit[i][j]=true;
        
        dfs(grid,i,j-1,visit);
        dfs(grid,i-1,j,visit);
        dfs(grid,i+1,j,visit);
        dfs(grid,i,j+1,visit);
        dfs(grid,i-1,j-1,visit);
        dfs(grid,i+1,j+1,visit);
         dfs(grid,i+1,j-1,visit);
         dfs(grid,i-1,j+1,visit);

    }
}
