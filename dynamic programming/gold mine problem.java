https://practice.geeksforgeeks.org/problems/gold-mine-problem2608/1#
https://practice.geeksforgeeks.org/problems/path-in-matrix3805/1#
https://leetcode.com/problems/path-with-maximum-gold/

class Solution{
    static int maxGold(int n, int m, int M[][])
    {
        int max=0;
        
       int dp[][] = new int[n+1][m+1];
       
       for(int j=m-1;j>=0;j--)
       {
           for(int i=0;i<n;i++)
           {
               if(j+1>=m)
               {
                   max=0;
               }
               else if(i-1<0 && i+1>=n)
               {
                   max=dp[i][j+1];
               }
               else if(i-1<0)
               {
                   max=Math.max(dp[i][j+1],dp[i+1][j+1]);
               }
               else if(i+1>=n)
               {
                 max=Math.max(dp[i][j+1],dp[i-1][j+1]);  
               }
               else
               {
               max=Math.max(dp[i-1][j+1],Math.max(dp[i][j+1],dp[i+1][j+1]));
               }
               dp[i][j]=max+M[i][j];
               
           }
       }
       int ans=0;
       
       for(int i=0;i<n;i++)
       {
           if(ans<dp[i][0])
           {
               ans=dp[i][0];
           }
       }
       
       return ans;
    }
}
