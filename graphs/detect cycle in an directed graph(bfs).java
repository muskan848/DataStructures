//detect cycle in directed bfs or kahn's algo
// tc = o(n+e)
// sc = o(n) + o(n) for inDegree array and queue  

package graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class detectCycleDirected {
	
	public static boolean isCycle(LinkedList<Integer>adj[],int v)
	{
		int c=0;
		int inDegree[] =new int[v];
		
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

		while(!q.isEmpty())
		{
			int temp = q.remove();
			c++;
			for(int nbr : adj[temp])
			{
				inDegree[nbr]--;
				if(inDegree[nbr]==0)
				{
					q.add(nbr);
				}
			}
		}
		return (c==v)?false:true;
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
		   
		  System.out.println(isCycle(graph.adj,vertices));

	}

}
