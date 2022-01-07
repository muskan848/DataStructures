https://practice.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1/#

class pair
{
    Node data;
  
    int level;
    
    public pair(Node data,int level)
    {
        this.data=data;
       
        this.level=level;
    }
}


class Solution
{
    //Function to return a list containing the bottom view of the given tree.
    public ArrayList <Integer> bottomView(Node root)
    {
        ArrayList<Integer> arr = new ArrayList<>();
        
        Map<Integer,Integer> map = new TreeMap<>();
        
        Queue<pair> q= new LinkedList<>();
        
        q.add(new pair(root,0));
        
        while(!q.isEmpty())
        {
            pair temp = q.remove();
            
            Node val = temp.data;
            
            int level = temp.level;
            
            map.put(level,val.data);
            
            if(val.left!=null)
            {
               q.add(new pair(val.left,level-1)); 
            }
            if(val.right!=null)
            {
               q.add(new pair(val.right,level+1)); 
            }
        }
        
     for(Map.Entry<Integer,Integer> m : map.entrySet())
      {
         arr.add(m.getValue()); 
      }
      
      return arr;

    }
}
