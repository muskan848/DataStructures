//https://practice.geeksforgeeks.org/problems/bipartite-graph/1
//bfs

class Solution
{
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        int color[]=new int[V];
      
        Arrays.fill(color,-1);
        
        for(int i=0;i<V;i++)
        {
            if(color[i]==-1)
            {
                if(bipartite(i,adj,color) == false)
                {
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean bipartite(int src,ArrayList<ArrayList<Integer>>adj,int color[])
    {
        Queue<Integer> q=new LinkedList<>();
        
        q.add(src);
         
        color[src]=1; 
        
        while(!q.isEmpty())
        {
          int temp = q.remove();
        
          for(int nbr:adj.get(temp))
          {
             if(color[nbr] == -1)
             {
                color[nbr]=1-color[temp];
                q.add(nbr);
             }
             else if(color[nbr]==color[temp])
             {
                 return false;
             }
          }
          
        }
        return true;
    }
}

