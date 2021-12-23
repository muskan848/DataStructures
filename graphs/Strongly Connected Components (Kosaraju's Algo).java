//https://practice.geeksforgeeks.org/problems/strongly-connected-components-kosarajus-algo/1#
// time o(n+e)
//space o(n+e)+o(n)+o(n)

class Solution
{
    public void topoSort(int src,ArrayList<ArrayList<Integer>> adj , boolean visit[],Stack<Integer>s)
    {
       visit[src]=true; 
       
       for(int nbr:adj.get(src))
       {
           if(visit[nbr]==false)
           {
               topoSort(nbr,adj,visit,s);
           }
       }
       s.push(src);
    }
    
  public void dfs(int src,ArrayList<ArrayList<Integer>> adj , boolean visit[])
    {
       visit[src]=true; 
       
       for(int nbr:adj.get(src))
       {
           if(visit[nbr]==false)
           {
               dfs(nbr,adj,visit);
           }
       }
      
    }

    
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        
        //step 1 topological sort
      Stack<Integer> stack=new Stack<>();
     
      boolean visit[]=new boolean[V];
     
      for(int i=0;i<V;i++)
      {
        if(visit[i]==false)
        {
            topoSort(i,adj,visit,stack);
        }
      }
      
      //step 2 transpose the graph
      ArrayList<ArrayList<Integer>> transpose=new ArrayList<ArrayList<Integer>>();
      
      for(int i=0;i<V;i++)
      {
          transpose.add(new ArrayList<Integer>());
      }
      
      for(int i=0;i<V;i++)
      {
          visit[i]=false;
          for(int nbr:adj.get(i))
          {
              transpose.get(nbr).add(i);
          }
      }
      
      int c=0;
      //step 3 again call dfs
      while(!stack.isEmpty())
      {
       int node = stack.pop();
       if(visit[node]==false)
       {
          dfs(node,transpose,visit);
           c++;
       }
      }
      return c;
    }
}
