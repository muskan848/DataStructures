//kahn's algorithm
// tc = o(n+e)
// sc = o(n) + o(n) for inDegree array and queue  


package graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class topologicalBfs {
	
	public static int[] topoSortBfs(LinkedList<Integer> adj[] ,int v)
	{
		int ans[]=new int[v];
		int inDegree[] =new int[v];
		
	    //calculating indegree(no of nodes directed to the given node)
		for(int i=0;i<v;i++)
		{
			for(int nbr : adj[i])
			{
				inDegree[nbr]++;
			}
		}
		
		Queue<Integer> q=new LinkedList<Integer>();
		for(int i=0;i<v;i++)
		{
			if(inDegree[i]==0)
			{
				q.add(i);
			}
		}
		int k=0;
		while(!q.isEmpty())
		{
			int temp = q.remove();
			ans[k++]=temp;
			for(int nbr : adj[temp])
			{
				inDegree[nbr]--;
				if(inDegree[nbr]==0)
				{
					q.add(nbr);
				}
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		
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
         
		   int ans[]=new int[vertices];
		   ans = topoSortBfs(graph.adj,vertices);
		   for(int i=0;i<vertices;i++)
		   {
			   System.out.print(ans[i]+" ");
		   }
	}

}
