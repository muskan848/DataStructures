https://practice.geeksforgeeks.org/problems/nth-fibonacci-number1335/1#

//memoization
class Solution 
{
    static long nthFibonacci(long n)
    {
        long dp[]=new long[(int)n+1];
        return fibbo(n,dp)%1000000007;
    }
    
    public static long fibbo(long n,long dp[])
    {
        if(n==1||n==0)
        {
            return n;
        }
        
        if(dp[(int)n]!=0)
        {
            return dp[(int)n];
        }
        
        long a = fibbo(n-1,dp);
        long b = fibbo(n-2,dp);
        
        long fib= a+b;
        dp[(int)n]= fib%1000000007;
      
        return fib;
    }
}
