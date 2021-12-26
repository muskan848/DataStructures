//detect cycle in directed graph with dfs
// tc = o(n+e)
// sc = o(2n) =>two boolean arrays

package graphs;

import java.util.LinkedList;
import java.util.Scanner;
 
class directedGraphImplement{
	
	LinkedList<Integer> adj[] ;
	
	public directedGraphImplement(int v)
	{
	   adj = new LinkedList[v];
	   
	   for(int i=0;i<v;i++)
	   {
		   adj[i] = new LinkedList<Integer>();
	   }
	}
	
	public void addEdges(int source ,int destination)
	{
	   adj[source].add(destination);
	}

}


public class detectCycleInDirectedGraph {
	
	public static boolean isCycle(int src,LinkedList<Integer> adj[],int visit[],int dfsvisit[])
	{
	  visit[src]=1;
	  dfsvisit[src]=1;
	  
	  for(int nbr: adj[src])
	  {
		if(visit[nbr]==0)
		{
			if(isCycle(nbr,adj,visit,dfsvisit)==true)
				return true;
		}
		else if(dfsvisit[nbr]==1)
		{
			return true;
		}
	  }
	  dfsvisit[src]=0;  
	  return false;
	}
	
	public static boolean detectCycle(LinkedList<Integer> adj[],int vertices )
	{
		int visit[]=new int[vertices];
		int dfsvisit[]=new int[vertices];
		
		for(int i=0;i<vertices;i++)
		{
			if(visit[i]==0)
			{
				if(isCycle(i,adj,visit,dfsvisit))
				{
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args)
	{
		   Scanner sc=new Scanner(System.in);
		   
		   System.out.println("Enter vertices :");
		   
		   int vertices = sc.nextInt();
		   
		   System.out.println("Enter edges :");
		   
		   int edges= sc.nextInt();
		   
		   directedGraphImplement graph = new directedGraphImplement(vertices);
		   
		   System.out.println("Enter "+ edges +" edges");
		   
		   for(int i=0;i<edges;i++)
		   {
			   int source = sc.nextInt();
			   int dest = sc.nextInt();
		
		       graph.addEdges(source,dest);
		   }
		   
		  System.out.println(detectCycle(graph.adj,vertices));

	}

}
