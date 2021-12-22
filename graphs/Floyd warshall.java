//https://practice.geeksforgeeks.org/problems/implementing-floyd-warshall2042/1

 //It is a dynamic programming algorithm with O(|V|3) time complexity and O(|V|2) space complexity

class Solution
{
    public void shortest_distance(int[][] matrix)
    {
       for(int k=0;k<matrix.length;k++)
       {
         for(int i=0;i<matrix.length;i++)
         {
             for(int j=0;j<matrix[i].length;j++)
             {
                 if(i==k || j==k || i==j){continue;}
                
                 if(matrix[i][k]==-1 || matrix[k][j]==-1){continue;}
                 
                 if(matrix[i][j]==-1){matrix[i][j] = matrix[i][k]+matrix[k][j];}
               
                 matrix[i][j]=Math.min(matrix[i][j],matrix[i][k]+matrix[k][j]);
             }
         }
       }
    }
}

