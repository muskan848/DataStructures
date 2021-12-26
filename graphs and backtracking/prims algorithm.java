https://practice.geeksforgeeks.org/problems/minimum-spanning-tree/1

class pair{
    int value;
    int weight;
    
    public pair(int value,int weight)
    {
      this.value=value;
      this.weight=weight;
    }
}

class Solution
{
    //Function to find sum of weights of edges of the Minimum Spanning Tree.
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) 
    {
        int s=0;
        boolean visit[]=new boolean[V];
        PriorityQueue<pair>pq=new PriorityQueue<>(new Comparator<pair>(){
          
          public int compare(pair p1,pair p2)
          {
              return p1.weight-p2.weight;
          }
            
        });
        
        pq.add(new pair(0,0));
        
        while(!pq.isEmpty())
        {
            pair temp=pq.poll();
            
            int v=temp.value;
            int w=temp.weight;
            
            if(visit[v]==true)
            {
                continue;
            }
            
            visit[v]=true;
            
            s=s+w;
            
            for(ArrayList<Integer>nbr : adj.get(v))
            {
                if(visit[nbr.get(0)]==false)
                {
                    pq.add(new pair(nbr.get(0),nbr.get(1)));
                }
            }
        }
        return s;
    }
}


