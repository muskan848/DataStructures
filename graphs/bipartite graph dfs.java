//https://leetcode.com/problems/is-graph-bipartite/

//dfs

class Solution {
    public boolean isBipartite(int[][] graph) 
    {
        ArrayList<Integer> adj[]= new ArrayList[graph.length];
           
        for(int i=0;i<graph.length;i++)
        {         
            ArrayList<Integer> arr=new ArrayList<>();
            adj[i]=arr;
        }
       
        for(int i=0;i<graph.length;i++)
        {
            for(int j=0;j<graph[i].length;j++)
            {
                adj[i].add(graph[i][j]);
            }
        }

        
		int color[]=new int[adj.length] ;
		Arrays.fill(color, -1);
		
		for(int i=0;i<adj.length;i++) 
		{
			if(color[i]==-1)
			{
				if(dfsCheck(i,adj,color)==false)
					return false;
			}
		}
		return true;

    }
    
	public static boolean dfsCheck(int node, ArrayList<Integer>[] adj, int[] color)
	{
		if(color[node]==-1) {color[node]=1;}
		
		for(int nbr:adj[node])
		{
			if(color[nbr]==-1)
			{
				color[nbr]=1-color[node];
				if(dfsCheck(nbr,adj,color)==false)
					return false;
			}
			else if(color[nbr]==color[node])
			{
				return false;
			}	
		}
		return true;
	}	

}
