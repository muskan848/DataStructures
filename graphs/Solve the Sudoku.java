https://practice.geeksforgeeks.org/problems/solve-the-sudoku-1587115621/1#

//Time complexity: O(9^(n*n)). 
//For every unassigned index, 
//there are 9 possible options so the time complexity is O(9^(n*n))

//Space Complexity: O(n*n). 
//To store the output array a matrix is needed.


class Solution
{
    //Function to find a solved Sudoku. 
    static boolean SolveSudoku(int grid[][])
    {
        return solve(0,0,grid);
    }
    
    public static boolean solve(int r,int c,int grid[][])
    {
        int nc=0,nr=0;
        
        if(r==grid.length)
        {
            return true;
        }
        if(c==grid[0].length-1)
        {
            nc=0;
            nr=r+1;
        }
        else
        {
            nr=r;
            nc=c+1;
        }
       
         if(grid[r][c]!=0)
         {
            if(solve(nr,nc,grid))
            return true;
         }
         else
         {
         for(int i=1;i<=9;i++)
         {
           if(isSafe(r,c,i,grid)==true)
           {
               grid[r][c]=i;
               if(solve(nr,nc,grid)){return true;}
               grid[r][c]=0;
           }
         }
         }
         return false;
    }
    
    public static boolean isSafe(int r,int c,int i,int grid[][])
    {
        //row check
        for(int j=0;j<grid[0].length;j++)
        {
            if(grid[r][j]==i)
            {
                return false;
            }
        }
        
        //coloum check
         for(int j=0;j<grid.length;j++)
        {
            if(grid[j][c]==i)
            {
                return false;
            }
        }
        
        //for sub box
        int subr = (r/3)*3;
        int subc = (c/3)*3;
        
        for(int j=0;j<3;j++)
        {
            for(int k=0;k<3;k++)
            {
                if(grid[subr+j][subc+k]==i)
                {
                    return false;
                }
            }
        }
        return true;
    }
    
    //Function to print grids of the Sudoku.
    static void printGrid (int grid[][])
    {
        for(int i=0;i<grid.length;i++)
        {
            for(int j =0;j<grid[0].length;j++)
            {
                System.out.print(grid[i][j]+" ");
            }
        }
    }
}
