https://practice.geeksforgeeks.org/problems/permutations-of-a-given-string2041/1#

//For any given string of length n there are n! possible permutations, and we need to print all of them so Time complexity is O(n * n!).
//The function will be called recursively and will be stored in call stack for all n! permutations, so Space complexity is O(n!).

class Solution 
{
    public List<String> find_permutation(String S)
    {
        ArrayList<String>arr=new ArrayList<>();
         permutation(S,"",S.length(),arr);
        Collections.sort(arr);
        return arr;
        
    }
    
    public void permutation(String s, String op,int length ,ArrayList<String>arr)
    {
        if(op.length()==length)
        {
            arr.add(op);
            return;
        }
        
        for(int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            String left=s.substring(0,i);
            String right=s.substring(i+1);
            permutation(left+right,op+ch,length,arr);
        }
    }
    
}
