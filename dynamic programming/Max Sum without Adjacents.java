https://practice.geeksforgeeks.org/problems/max-sum-without-adjacents2430/1/

class Solution {
    int findMaxSum(int arr[], int n)
    {
      int include = arr[0];
      int exclude = 0;
      
      for(int i=1;i<n;i++)
      {
          int ninclude = exclude + arr[i];
          int nexclude = Math.max(include,exclude);
          
          include=ninclude;
          exclude=nexclude;
      }
      
      return Math.max(include,exclude);
    }
}
