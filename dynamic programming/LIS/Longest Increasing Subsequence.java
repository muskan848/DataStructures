https://practice.geeksforgeeks.org/problems/longest-increasing-subsequence-1587115620/1#

class Solution 
{
    //Function to find length of longest increasing subsequence.
    static int longestSubsequence(int size, int a[])
    {
        if(size==1)return 1;
        
        int dp[]=new int[size];
        int ans=0;
       
        dp[0]=1;
        
        for(int i=1;i<size;i++)
        {
            int max=0;
            
            for(int j=0;j<i;j++)
            {
                if(a[i]>a[j])
                {
                    if(max<dp[j])
                    {
                        max=dp[j];
                    }
                }
                dp[i]=max+1;
            }
            
            if(dp[i]>ans)
            {
                ans=dp[i];
            }
        }
        return ans;
    }
} 
