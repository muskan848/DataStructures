package graphs;

import java.util.*;

public class implementGraph {

	 LinkedList<Integer> adj[] ;
	
	public implementGraph(int v)
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
	   adj[destination].add(source);
	}
	
	//bfs return minimum length between source to destination
	public int bfs(int source,int dest)
	{
	  	boolean visit[]=new boolean[adj.length];
	  	int parent[] = new int[adj.length];
	  	
	  	Queue<Integer> q = new LinkedList<>();
	  	
	  	q.add(source);
	  	parent[source]=-1;
	  	visit[source] =true;
	  	
	  	while(!q.isEmpty())
	  	{
	  		int current = q.poll();
	  		if(current==dest)
	  		{
	  			break;
	  		}
	  		
	  		for(int neighbour : adj[current])
	  		{
	  			if(visit[neighbour] == false)
	  			{
	  				visit[neighbour] = true;
	  				q.add(neighbour);
	  				parent[neighbour] = current; 
	  			}
	  		}
	  	}
	  	int curr = dest;
	  	int distance=0;
	  	
	  	while(parent[curr] != -1)
	  	{
	  		System.out.print(curr +"->");
	  		curr = parent[curr];
	  		distance++;
	  	}
	  	return distance;
 	}
	
	
	//dfs
	//1. stack
	public boolean dfsStack(int source,int dest)
	{
	   boolean visit[] = new boolean[adj.length];
	   Stack<Integer> s=new Stack<>();
	   
	   s.push(source);
	   visit[source]=true;
	   
	   while(!s.isEmpty())
	   {
		   int current = s.pop();
		   if(current == dest)
		   {
			   return true;
		   }
		   for(int neighbour : adj[current])
		   {
			   if(visit[neighbour]==false)
			   {
				   s.push(neighbour);
				   visit[neighbour]=true;
				   
			   }
		   }
	   }
	   return false;  
	}
	
	//dfs 
	//2. recursion
	public boolean dfsRecursive(int source,int dest,boolean visit[])
	{
        if(source==dest)
        {
        	return true;
        }
        
        for(int neighbour : adj[source])
        {
        	if(!visit[neighbour])
        	{
        		visit[neighbour]=true;
        		boolean isConnected = dfsRecursive(neighbour,dest,visit);
        		if(isConnected)return true;
        	}
        }
        return false;
	}
	
	public boolean dfs(int source,int dest)
	{
		boolean visit[]=new boolean[adj.length];
		visit[source]=true;
		
		return dfsRecursive(source,dest,visit);
	}
	
	public static void main(String[] args) 
	{
	   Scanner sc=new Scanner(System.in);
	   
	   System.out.println("Enter vertices :");
	   
	   int vertices = sc.nextInt();
	   
	   System.out.println("Enter edges :");
	   
	   int edges= sc.nextInt();
	   
	   implementGraph graph = new implementGraph(vertices);
	   
	   System.out.println("Enter "+ edges +" edges");
	   
	   for(int i=0;i<edges;i++)
	   {
		   int source = sc.nextInt();
		   int dest = sc.nextInt();
	
	       graph.addEdges(source,dest);
	   }
	   
	   System.out.print("Enter Source and destination :");
	   
	   int s = sc.nextInt();
	   int d = sc.nextInt();
	   
//		int distance = graph.bfs(s, d);
//		System.out.println("min distance is " + distance);

	   
	   System.out.print("Possible "+graph.dfs(s,d));
	   

	}

}
