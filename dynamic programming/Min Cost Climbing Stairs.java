https://leetcode.com/problems/min-cost-climbing-stairs/

class Solution {
    public int minCostClimbingStairs(int[] cost) 
    { 
        int dp[]=new int[cost.length+1];
        
        dp[0]=0;
        dp[1]=cost[0];
        
        for(int i=2;i<=cost.length;i++)
        {
           int min = Math.min(dp[i-1],dp[i-2]);
           dp[i]=min+cost[i-1]; 
        }
        
        return Math.min(dp[cost.length] , dp[cost.length-1]);
    }
}
