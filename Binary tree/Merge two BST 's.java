https://practice.geeksforgeeks.org/problems/merge-two-bst-s/1/


/*
class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}
    
*/
class Solution
{
    //Function to return a list of integers denoting the node 
    //values of both the BST in a sorted order.
    public List<Integer> merge(Node root1,Node root2)
    {
        Stack<Node> s1=new Stack<>();
        Stack<Node> s2=new Stack<>();
        ArrayList<Integer> arr = new ArrayList<>();
        
        insert(root1,s1);
        insert(root2,s2);
        
        while(!s1.isEmpty() || !s2.isEmpty())
        {
            
          int a=Integer.MAX_VALUE;
          int b=Integer.MAX_VALUE;
    
            
          if(!s1.isEmpty())
          {
              a = s1.peek().data;
          }
          
          if(!s2.isEmpty())
          {
              b = s2.peek().data;
          }

          if(a>b)
          {
            arr.add(b);
            Node temp = s2.pop();
            insert(temp.right,s2);
          }
          else
          {
            arr.add(a);   
            Node temp = s1.pop();
            insert(temp.right,s1);
          }

          }
          
          return arr;
        }
        
    
    
    private void insert(Node root,Stack<Node> s)
    {
        while(root!=null)
        {
            s.push(root);
            root=root.left;
        }
    }

}
