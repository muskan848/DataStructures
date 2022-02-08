https://practice.geeksforgeeks.org/problems/diagonal-traversal-of-binary-tree/1/#

class Tree
{
     public ArrayList<Integer> diagonal(Node root)
      {
        Queue<Node> q=new LinkedList<>();
        ArrayList<Integer> arr=new ArrayList<>();
        q.add(root);
        q.add(null);
        Node p=null;
    
        while(!q.isEmpty())
        {
           p=q.remove();

           while(p!=null)
           {
               arr.add(p.data);
               if(p.left!=null)
               {
                   q.add(p.left);
               }
               p=p.right;
           }
        }
        return arr;
    }
      
}
