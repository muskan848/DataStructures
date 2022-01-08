https://practice.geeksforgeeks.org/problems/painting-the-fence3727/1/#

class Solution
{
    long countWays(int n,int k)
    {
        if(n==1)
        {
            return k;
        }
        
      long same = k*1;
      long diff = k *(k-1);
      long total = same+diff;
      
      for(int i=3;i<=n;i++)
      {
          same = (diff*1)%1000000007 ;
          diff = (total * (k-1))%1000000007;
          total = (same+diff)%1000000007;
      }
      return total%1000000007;
    }
}
