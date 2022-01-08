https://practice.geeksforgeeks.org/problems/count-the-number-of-ways-to-tile-the-floor-of-size-n-x-m-using-1-x-m-size-tiles0509/1/#
and this
https://practice.geeksforgeeks.org/problems/ways-to-tile-a-floor5836/1/

class Solution
{
    public int countWays(int n, int m)
    {
        // Code here
        long dp[]=new long[n+1];
        
        for(int i=1;i<=n;i++)
        {
            if(i<m)
            {
                dp[i]=(long)1;
            }
            else if(i==m)
            {
                dp[i]=(long)2;
            }
            else
            {
                dp[i]=(dp[i-1]+dp[i-m])%1000000007;
            }
        }
        return (int)dp[n]%1000000007;
    }
}
