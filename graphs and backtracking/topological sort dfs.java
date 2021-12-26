// tc = o(n+e)
// sc = o(n) + o(n) for visit array and stack  

package graphs;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class topological {
	
	public static void topoSort(int node,LinkedList<Integer> adj[],boolean visit[],Stack<Integer>st)
	{
		visit[node]=true;
		for(int nbr : adj[node])
		{
			if(visit[nbr]==false)
			{
				topoSort(nbr,adj,visit,st);
			}
		}
		st.push(node);
	}
	
	public static void topologic(LinkedList<Integer> adj[],int v)
	{
		boolean visit[]=new boolean[v];
		Stack<Integer> st=new Stack<>();
		
		for(int i=0;i<adj.length;i++)
		{
			if(visit[i]==false)
			{
				topoSort(i,adj,visit,st);
			}
		}
		// print
		while(!st.isEmpty())
		{
			System.out.print(st.pop() +" ");
		}
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
            
		   topologic(graph.adj,vertices);

	}

}
