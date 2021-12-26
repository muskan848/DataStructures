https://practice.geeksforgeeks.org/problems/word-break1352/1#

class Sol
{
    public static int wordBreak(String A, ArrayList<String> B )
    {
        return solve(A,B);
    }
    
    public static int solve(String s,ArrayList<String> arr)
    {
        if(s.length()==0)
        {
            return 1;
        }
        
       for(int i=0;i<s.length();i++)
       {
           String ch = s.substring(0,i+1);
           
           if(arr.contains(ch))
           {
              String temp = s.substring(i+1); 
              if(solve(temp,arr)==1)
              {
                  return 1;
              }
           }
       }
       return 0;
    }
}
