// e=edges , v=vertices

//worst case
// e log e ->for sorting ,e v->detecting cycle (in case of skewed tree)
// (e log e + e v) 

//we can improve by performing union by rank and path compression
//(e log e + e log v)  ->we try to avoid skewed tree by flattening it


package graphs;
import java.util.Arrays;
import java.util.Scanner;

class edge implements Comparable<edge>{
	int srs;
	int des;
	int weight;
	public edge(int srs,int des,int weight)
	{
		this.srs=srs;
		this.des=des;
		this.weight=weight;
	}
	
	public int compareTo(edge e)
	{
      return this.weight - e.weight;		
	}
}

public class kruskalsAlgo {
	
	public static int find(int node,int parent[])
	{
	  	if(node == parent[node])
	  	{
	  		return node;
	  	}
	  	return parent[node]=find(parent[node],parent);
	}
	
	public static void union(int u,int v,int parent[],int rank[])
	{
		if(rank[u]<rank[v])
		{
			parent[u]=v;
		}
		else if(rank[u]>rank[v])
		{
			parent[v]=u;
		}
		else
		{
			parent[v]=u;
			rank[u]++;
		}
	}
	
	public static void kruskal(edge input[],int v,int e)
	{
		int k=0;
		Arrays.sort(input);
		
		edge ans[]=new edge[v-1];
		
		int parent[]=new int[v];
		int rank[]=new int[v];
		
		for(int i=0;i<v;i++)
		{
			parent[i]=i;
			rank[i]=0;
		}

		
		for(int i=0;i<input.length;i++)
		{
		  edge temp = input[i];
		  int p1=find(temp.srs,parent);
		  int p2=find(temp.des,parent);
		  
		  if(p1!=p2)
		  {
			  ans[k++]=temp;
			  union(p1,p2,parent,rank);  
		  }	
		}
		
		for(int i=0;i<v-1;i++)
		{
		  if(ans[i].srs < ans[i].des)
		  {
			  System.out.println(ans[i].srs +" "+ ans[i].des +" "+ans[i].weight);
		  }
		  else
		  {
			  System.out.println(ans[i].des +" "+ ans[i].srs +" "+ans[i].weight);  
		  }
		}
		
	}
	
	public static void main(String[] args) 
	{
	 Scanner sc=new Scanner(System.in);
	 
	 System.out.println("Enter vertices");
	 int v=sc.nextInt();
	 
	 System.out.println("Enter no of edges");
	 int e=sc.nextInt();
	 
	 edge input[]=new edge[e];
	 
	 System.out.println("Enter "+ e +" edges");
	 
	 for(int i=0;i<e;i++)
	 {
		 int s=sc.nextInt();
		 int d=sc.nextInt();
		 int w=sc.nextInt();
		 
		 edge ed =new edge(s,d,w);
		 input[i]=ed;
	 }
	 
	 kruskal(input,v,e);
}
}
