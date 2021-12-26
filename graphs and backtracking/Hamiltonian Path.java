//https://practice.geeksforgeeks.org/problems/hamiltonian-path2522/1

class Solution 
{ 
    boolean check(int n, int m, ArrayList<ArrayList<Integer>> Edges) 
    { 
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        
        for(int i=0;i<=n;i++)
        {
            ArrayList<Integer> arr=new ArrayList<>();
            adj.add(i,arr);
        }
    
        for(int i=0;i<m;i++)
        {
          adj.get(Edges.get(i).get(0)).add(Edges.get(i).get(1));
          adj.get(Edges.get(i).get(1)).add(Edges.get(i).get(0));    
        }
        
        HashSet<Integer> visit=new HashSet<>();
        
       for(int i=0; i< n; i++)
        {
            boolean ans= dfs(adj,i,visit, n);
            if(ans)
            return true;
        }
        return false;
    }
    
    public boolean dfs(ArrayList<ArrayList<Integer>>adj,int srs,HashSet<Integer>visit,int n )
    {
          visit.add(srs);
          
        if(visit.size()==n)
        {
            return true;
        }
      // System.out.println(visit.size()+" "+n);

        for(int nbr : adj.get(srs))
        {
            if(visit.contains(nbr)==false)
            {
               boolean b =  dfs(adj,nbr,visit,n);
               if(b)
               {
                   return true;
               }
            }
            
        } 
           visit.remove(srs);
        return false;
    }
} 
