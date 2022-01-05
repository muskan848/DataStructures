https://practice.geeksforgeeks.org/problems/number-of-coins1824/1#
https://leetcode.com/problems/coin-change/

//minimum no of coins of the given sum 
class Solution{

	public int minCoins(int coins[], int n, int sum) 
	{ 
	    int dp[]=new int[sum+1];
	Arrays.fill(dp,Integer.MAX_VALUE);
	
	dp[0]=1;
	
	for(int i=0;i<coins.length;i++)
	{
	    int val = coins[i];
	    
	    for(int j=0;j<dp.length;j++)
	    {
	        if(j-val==0)
	        {
	            dp[j]=1;
	        }
	        
	        else if(j>=val && dp[j-val]!=Integer.MAX_VALUE)
	        {
	          dp[j]=Math.min(dp[j],dp[j-val]+1);
	        }
	    }
	}
	  return dp[sum]==Integer.MAX_VALUE ? -1 : dp[sum];  
	}
}


//2d
class Solution {
    public int coinChange(int[] coins, int amount) 
    {
        if(amount==0)return 0;
        
        int dp[][]=new int[coins.length+1][amount+1];
        
        for(int i=0;i<dp.length;i++)
        {
            for(int j=0;j<dp[0].length;j++)
            {
                if(i==0 && j==0)
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
                    int val = coins[i-1];
                    dp[i][j]=dp[i-1][j];
                    if(j-val==0)
                    {
                        dp[i][j]=1;
                    }
                    else if(j>=val&& dp[i][j-val]!=0)
                    { 
                        if(dp[i-1][j]==0)
                        {
                          dp[i][j]=dp[i][j-val]+1;  
                        }
                        else
                        dp[i][j] = Math.min(dp[i][j-val]+1,dp[i-1][j]); 
                    }
                }
               // System.out.print(dp[i][j]+" ");
            }
           // System.out.println();
        }
        return dp[coins.length][amount]==0?-1:dp[coins.length][amount];
    }
}
