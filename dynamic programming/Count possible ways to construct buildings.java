https://practice.geeksforgeeks.org/problems/count-possible-ways-to-construct-buildings5007/1
class Solution
{
    public int TotalWays(int N)
    {
       long space = 1;
       long building = 1;
       
       for(int i=1;i<N;i++)
       {
         long nspace = (space+building) %1000000007 ;
         long nbuilding = space %1000000007; 
         
         space = nspace;
         building = nbuilding; 
       }
       long ans = (space+building) %1000000007;
       ans = (ans*ans) %1000000007;
       
       return (int)ans;
    }
}
