https://practice.geeksforgeeks.org/problems/coin-change2448/1#
https://leetcode.com/problems/coin-change-2/

//coin change combination
//2d
class Solution {
    public long count(int arr[], int m, int sum) 
    {
        long dp[][]=new long[m+1][sum+1];
        
        for(int i=0;i<dp.length;i++)
        {
            for(int j=0;j<dp[0].length;j++)
            {
                if(i==0&&j==0)
                {
                    dp[i][j]=1;
                }
                else if(i==0)
                {
                    dp[i][j]=0;
                }
                else if(j==0)
                {
                    dp[i][j]=1;
                }
                else
                {
                   int val=arr[i-1];
                  
                   dp[i][j]=dp[i-1][j];
                   
                   if(j>=val)
                   {
                     dp[i][j]=dp[i][j]+dp[i][j-val];     
                   }
                   
                }
                // System.out.print(dp[i][j]+" ");
            }
            // System.out.println();
        }
        return dp[m][sum];
    }
}

//1d
class Solution {
    public int change(int amount, int[] coins) {
             
           int dp[]=new int[amount+1];
           dp[0]=1;
            
            for(int i=0;i<coins.length;i++)
            {
                int val=coins[i];
                for(int j=0;j<dp.length;j++)
                {
                  if(j>=val)
                   {
                    dp[j]=dp[j]+dp[j-val];
                   }
                }
            }
                
            
        return dp[amount];

    }
}
