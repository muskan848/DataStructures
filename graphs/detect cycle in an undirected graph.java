//https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1

class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj)
    {
        
       boolean visit[]=new boolean[V];
       int parent[]=new int[V];
        
        for(int i=0;i<V;i++)
        {
            if(visit[i]==false)
            {
                parent[i]=-1;
                if(dfs(adj,i,visit,parent))
                    return true;
            }
        }
   return false;
    }
    
    public boolean dfs(ArrayList<ArrayList<Integer>> adj,int srs,boolean visit[],int parent[])
    {
      
      visit[srs]=true;
    
      for(int e:adj.get(srs))
      {
          if(visit[e]==false)
          {
              parent[e]=srs;
           
             if( dfs(adj,e,visit,parent))
                 { 
                     return true;
                     
                 }
          }
          else if(e!=parent[srs])
          {
            return true;  
          }
      }
      return false;
    }
}


  //using bsf

 class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        boolean visit[]=new boolean[V];
        
        for(int i=0;i<V;i++)
        {
            if(visit[i]==false)
            {
                if(bfs(adj,i,visit))
                    return true;
            }
        }

        return false;
    }
    
    public boolean bfs(ArrayList<ArrayList<Integer>>adj , int srs,boolean visit[])
    {
      Queue<Integer> q=new LinkedList<>();
      
        q.add(srs);
        
        while(!q.isEmpty())
        {
            int temp=q.remove();
            
            if(visit[temp]==true)
            {
                return true;
            }
            
            visit[temp]=true;
            
            for(int e:adj.get(temp))
            {
                if(visit[e]==false)
                {
                    q.add(e);
                }
            }
        }
        return false;
    }
}
