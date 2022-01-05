https://practice.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1/?category[]=Dynamic%20Programming&category[]=Dynamic%20Programming&page=4&query=category[]Dynamic%20Programmingpage4category[]Dynamic%20Programming

class Solution{


    static Boolean isSubsetSum(int n, int arr[], int sum)
    {
        boolean dp[][] = new boolean[n+1][sum+1];
        
        for(int i=0;i<dp.length;i++)
        {
            for(int j=0;j<dp[0].length;j++)
            {
                if(i==0 && j==0)
                {
                  dp[i][j]=true;  
                }
                else if(i==0)
                {
                    dp[i][j]=false;
                }
                else if(j==0)
                {
                    dp[i][j]=true;
                }
                else
                {
                    //not bating
                    if(dp[i-1][j]==true)
                    {
                        dp[i][j]=true;
                    }
                    else
                    {
                        
                        int val = arr[i-1];
                        //bating possible
                        if(j>=val)
                        {
                           if(dp[i-1][j-val]==true)
                           {
                               dp[i][j]=true;
                           }
                        }
                    }
                }
            }
        }
        
        return dp[n][sum];
    }
}
