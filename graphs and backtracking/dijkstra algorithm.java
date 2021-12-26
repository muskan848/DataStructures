https://practice.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1

class pair{
     
        int value;
        int weight;
        pair(int value,int weight)
        {
            this.value=value;
            this.weight=weight;
        }
}

class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int s)
    {
        boolean [] visit = new boolean[V];
        int ans[]=new int[V];
        
        Arrays.fill(ans,Integer.MAX_VALUE);

        PriorityQueue<pair> pq=new PriorityQueue<>(new Comparator<pair>(){
            
            public int compare(pair p1,pair p2)
            {
                return p1.weight-p2.weight;
            }
            
        });
        
        ans[s]=0;
        pq.add(new pair(s,0));
        
        while(pq.size()!=0)
        {
         pair temp = pq.poll();
         int src=temp.value;
         int w=temp.weight;
         
         if(visit[src]==true)
         {
             continue;
         }
         
         visit[src]=true;      
        
         for(ArrayList<Integer>nbr : adj.get(src))
         {
            int des= nbr.get(0);
            int weight=nbr.get(1);

             if(visit[nbr.get(0)] == false && ans[des] > w+weight )
             {
                 ans[des] = w+weight;
                 
                pq.add(new pair(des,w+weight));
             }
            
         }
        }
        
        return ans;
    }
}

