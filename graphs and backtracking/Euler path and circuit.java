//https://practice.geeksforgeeks.org/problems/euler-circuit-and-path/1


class Solution
{
    public int isEularCircuitExist(int V, ArrayList<ArrayList<Integer>> adj)
    {
        int o=0;

        for(int i=0;i<V;i++)
        {
            if(adj.get(i).size()%2 != 0)
            {
                o++;
            }
        }
        
        if(o==2)     //semi euler or Euler path  start!=end
          return 1;
        else if(o==0)   // euler or euler circuit start==end
          return 2;
        else
           return 0;
       
    }
}
