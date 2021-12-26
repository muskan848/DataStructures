https://practice.geeksforgeeks.org/problems/n-queen-problem0315/1#

//Time complexity in this case will be O(N!) in the worst case,
// In the starting, the answer matrix (which we need to fill) looks like,

// X X X X
// X X X X
// X X X X
// X X X X
// Let us fill this row-wise, meaning will select one location in each row then move forward to the next row.

// For the first row, since none is filled in the matrix as a whole, we have 4 options. For the second row, we have 3 options as one row has already been taken off. Similarly, for the third row, we have 2 options and for the final row, we are left with just 1 option.

// Total options = 4*3*2*1 = 24 (4!)

// Now, this was the case had our queen were a rook but since we have more constraints in case of a queen. Complexity should be less than O(N!) in terms of the actual number of operations.



class Solution
{
   public static ArrayList<ArrayList<Integer>> nQueen(int n)
    {
        ArrayList<ArrayList<Integer>> arr=new ArrayList<>();
        
        int visit[][]=new int[n][n];
        
        Queen(n,0,visit,arr,new ArrayList<Integer>());
        
        return arr;
    }
    
    public static void Queen(int n,int r,int visit[][], ArrayList<ArrayList<Integer>> arr, ArrayList<Integer> a)
    {
        if(r==n)
        {
            arr.add(new ArrayList<>(a));
            return;
        }
        
       for(int i=0;i<n;i++)
       {
             if(isQueenSafe(n,i,r,visit)==true)
              {
               visit[r][i]=1;
               a.add(i+1);
               Queen(n,r+1,visit,arr,a);
               visit[r][i]=0;
               a.remove(a.size()-1);
              }
       }
       
    }
    
    public static boolean isQueenSafe(int n ,int c,int r,int visit[][])
    {
        
        for(int i=r-1;i>=0;i--)
        {
            if(visit[i][c]==1)
            {
                return false;
            }
        }
        
        for(int i=r-1,j=c-1; i>=0 && j>=0 ;i--,j--)
        {
           if(visit[i][j]==1)
            {
                return false;
            }
        }
        
        for(int i=r-1,j=c+1; i>=0 && j<n ;i--,j++)
        {
           if(visit[i][j]==1)
            {
                return false;
            }
        }
        
        return true;
    }
    
    
    
}
