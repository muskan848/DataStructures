//detect cycle in undirected graph with disjoint set data structure
//find(a,b) ->if a,b belong to same set or not ..if yes then there appears a cycle
// if not then perform union operation
//union(a,b) -->join two sets in which a ,b presents 
// only used for undirected graphs ,not able to detect direction decisions

package graphs;

import java.util.LinkedList;
import java.util.Scanner;

class graph{
	
	private LinkedList<Integer> adj[] ;
	
	public graph(int v)
	{
		adj = new LinkedList[v];
		for(int i=0;i<v;i++)
		{
			adj[i]=new LinkedList<Integer>();
		}
		
	}
	
	public void addEdges(int a,int b)
	{
	  adj[a].add(b);
	  adj[b].add(a);
	}
	
	public boolean disjointSets()
	{  
	  int parent[]=new int[adj.length];
      int rank[]=new int[adj.length];
	  boolean visit[]=new boolean[adj.length];
		
	  for(int i=0;i<adj.length;i++)
	  {
		  parent[i]=i;
		  rank[i]=0;		  
	  }
	  
	  for(int i=0;i<adj.length;i++)
	  {
	    visit[i]=true;
		 
		int p1=findParent(i,parent);
		
		for(int nbr : adj[i])
		{
			if(visit[nbr]==false)
			{
				int p2=findParent(nbr,parent);
				if(p1==p2) return true;
				else union(p1,p2,parent,rank);
			}
		}
	  }
	  return false;	
	}
	
	
	// The idea of path compression is to make the found root as parent of x so that we don’t have to traverse all intermediate nodes again. 
	int findParent(int node,int parent[]){
		
		if(node==parent[node])
		{
			return node;
		}
		return parent[node] = findParent(parent[node],parent);
	}
	
	//The idea is to always attach smaller depth tree under the root of the deeper tree.
	//This technique is called union by rank
	void union(int u,int v,int parent[],int rank[])
	{
//		u=findParent(u);
//		v=findParent(v);
		
		if(rank[u]<rank[v])
		{
			parent[u]=v;
		}
		else if(rank[v]<rank[u])
		{
			parent[v]=u;
		}
		else
		{
			parent[v]=u;
			rank[u]++;
		}
	}
	//The two techniques complement each other. The time complexity of each operation becomes even smaller than O(Logn). In fact, amortized time complexity effectively becomes small constant. 
	//worst case time complexity as O(Logn)
}

public class detectCycle {

	public static void main(String[] args) 
	{
	 Scanner sc=new Scanner(System.in);
	 
	 System.out.println("Enter vertices");
	 int v=sc.nextInt();
	 
	 System.out.println("Enter no of edges");
	 int e=sc.nextInt();
	 
	 graph g =new graph(v);
	 
	 System.out.println("Enter "+ e +" edges");
	 
	 for(int i=0;i<e;i++)
	 {
		 int e1=sc.nextInt();
		 int e2=sc.nextInt();
		 
		 g.addEdges(e1, e2);
	 }
	 
	     System.out.println(g.disjointSets());
	 }

}


