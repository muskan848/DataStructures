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


// with level
// class pair
// {
//     int vertex;
//     int level;
    
//     public pair(int vertex,int level)
//     {
//         this.vertex=vertex;
//         this.level=level;
//     }
// }

// class Solution
// {
//     public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
//     {
//         int level[]=new int[V];
      
//         Arrays.fill(level,-1);
        
//         for(int i=0;i<V;i++)
//         {
//             if(level[i]==-1)
//             {
//                 if(bipartite(i,adj,level) == false)
//                 {
//                     return false;
//                 }
//             }
//         }
//         return true;
//     }
    
//     public boolean bipartite(int src,ArrayList<ArrayList<Integer>>adj,int level[])
//     {
//         Queue<pair> q=new LinkedList<>();
        
//         q.add(new pair(src,0));
        
//         while(!q.isEmpty())
//         {
//           pair temp = q.remove();
        
//           if(level[temp.vertex]!=-1)
//           {
//               //cycle
//               if(level[temp.vertex] != temp.level)
//               {
//                   return false;
//               }
//           }
           
//            else
//            {
//              level[temp.vertex]=temp.level;
//            }
          
//           for(int nbr:adj.get(temp.vertex))
//           {
//              if(level[nbr] == -1)
//              {
//                 q.add(new pair(nbr,temp.level+1));  
//              }
//           }
          
//         }
//         return true;
//     }
// }
