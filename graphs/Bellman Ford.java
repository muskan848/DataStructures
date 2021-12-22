//https://practice.geeksforgeeks.org/problems/negative-weight-cycle3504/1

//o(E V)
// o(n^2)
class pair{
    int s;
    int d;
    int w;
    public pair(int s,int d,int w)
    {
        this.s=s;
        this.d=d;
        this.w=w;
    }
}

class Solution
{
    public int isNegativeWeightCycle(int n, int[][] edges)
    {
       ArrayList<pair> adj = new ArrayList<>();
     
       int dis[]=new int[n];
       
       Arrays.fill(dis,Integer.MAX_VALUE);
       
       for(int i=0;i<edges.length;i++)
       {
           int s=edges[i][0];
           int d=edges[i][1];
           int w=edges[i][2];
           adj.add(new pair(s,d,w));  
       }
      
       dis[0]=0;
     
       for(int i=0;i<n;i++)
       {
         if( bellmanFord(edges.length,adj,dis,i,n) == 1)
         return 1;
       }
      
       return 0;
       
    }
    
    public int bellmanFord(int e,ArrayList<pair> adj ,int dis[],int k,int v)
    {
        for(int i=0;i<e;i++)
        {
            pair temp = adj.get(i);
            int s=temp.s;
            int d=temp.d;
            int w=temp.w;
            
            //relaxation
            if(dis[s]!=Integer.MAX_VALUE && dis[s]+w<dis[d])
            {
                dis[d]=dis[s]+w;
                if(k==v-1)return 1;
            }
        }
        return 0;
    }
}
