https://leetcode.com/problems/climbing-stairs/
https://practice.geeksforgeeks.org/problems/count-ways-to-reach-the-nth-stair-1587115620/1#

//tabulation
class Solution
{
    int countWays(int n)
    {
        int dp[]=new int[n+1];
        dp[0]=1;
        
        for(int i=1;i<=n;i++)
        {
            if(i==1)
            {
                dp[i]=dp[i-1];
            }
            else
            {
                dp[i]=(dp[i-1]+dp[i-2])%1000000007;
            }
        }
        
       return dp[n];
    }
}

//memoization
class Solution {
    public int climbStairs(int n) 
    {
       int dp[]=new int[n+1]; 
       return climbStairsdp(n,dp);
          
    }
    
    public int climbStairsdp(int n ,int dp[])
    {
        if(n==0)
        {
            return 1;
        }
        if(n<0)
        {
            return 0;
        }
        
        if(dp[n]!=0)
        {
            return dp[n];
        }
        
       int a =  climbStairsdp(n-1,dp);
       int b = climbStairsdp(n-2,dp);
       int c = a+b;
        
        dp[n]=c;
        
        return c;
    }
}

