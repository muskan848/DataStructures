https://practice.geeksforgeeks.org/problems/consecutive-1s-not-allowed1912/1/

class Solution {
    long countStrings(int n)
    {
        // code here
        
        long zero = 1;
        long one  = 1;
        
        for(int i=1;i<n;i++)
        {
            long nzero = (zero + one)%1000000007;
            long none = zero %1000000007;
            
            zero = nzero;
            one = none;
        }
        
        return (zero+one)%1000000007;
    }
}
