https://practice.geeksforgeeks.org/problems/boundary-traversal-of-binary-tree/1

class Solution
{
   static ArrayList<Integer> arr=new ArrayList<>();
	ArrayList <Integer> printBoundary(Node node)
	{

	    arr.add(node.data);
	    
	    if(node.left!=null)
	    {
	    left(node.left);
	    }
	    leaf(node);
	    if(node.right!=null)
	    {
	    right(node.right);
	    }
	    
	 	 ArrayList<Integer> b=new ArrayList<>(arr);
        arr.clear();
	     return b; 
	}
  
	public static void left(Node root)
	{
	  
	   if(root==null)
	   {
	       return;
	   }
	  
	      if(root.left!=null)
	      {
	          arr.add(root.data);
	          left(root.left);
	      }
	      else if(root.right!=null)
	      {
	          arr.add(root.data);
	          left(root.right);
	      }
	   
	  
	}
	
	public static void leaf(Node root)
	{
	    if(root==null)
	    return;
	    leaf(root.left);
	    if(root.left==null && root.right==null)
	    {
	        arr.add(root.data);
	        return;
	    }
	    
	    leaf(root.right);
	}
	
	public static void right(Node root)
	{
	    ArrayList<Integer> a=new ArrayList<>();
	    if(root==null)
	       {   
	           return;
	       }
	  
	      if(root.right!=null)
	      {
	          a.add(root.data);
	          right(root.right);
	      }
	      else if(root.left!=null)
	      {
	          a.add(root.data);
	          right(root.left);
	      }
	   
	   
	   Collections.reverse(a);
	   arr.addAll(a);
	}
}
