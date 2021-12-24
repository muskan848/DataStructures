//https://practice.geeksforgeeks.org/problems/m-coloring-problem-1587115620/1#
//https://leetcode.com/problems/flower-planting-with-no-adjacent/
// time o(m^n)
// space o(n)

class solve 
{
    //Function to determine if graph can be coloured with at most M colours such
    //that no two adjacent vertices of graph are coloured with same colour.
    public static boolean graphColoring(List<Integer>[] G, int[] color, int i, int C) 
    {
        Arrays.fill(color,-1);
        if(GraphColor(0,G.length,G,color,C)==true)
        return true;
        else
        return false;
    }
    
    public static boolean GraphColor(int node,int vertices,List<Integer>[]adj,int color[],int tcolors)
    {
        if(node==vertices)
        {
            return true;
        }
        
        for(int i=0;i<tcolors;i++)
        {
            if(isSafe(adj,color,node,i))
            {
                color[node]=i;
               if(GraphColor(node+1,vertices,adj,color,tcolors)==true) 
               {
                   return true;
               }
               color[node]=-1;
            }
        }
        return false;
    }
    
    public static boolean isSafe(List<Integer>[]adj,int color[],int node,int i)
    {
       for(int nbr : adj[node])
       {
           if(color[nbr]==i)
           {
               return false;
           }
       }
       return true;
    }
}
