https://practice.geeksforgeeks.org/problems/zigzag-tree-traversal/1/


public class zigzag 
{
	public void zigzag(Node root)
	{
		Stack<Node> s1=new Stack<>();
		Stack<Node> s2=new Stack<>();
        
		boolean flag=true;
		s1.add(root);
		
		while(!s1.isEmpty())
		{
			Node temp = s1.pop();
			System.out.print(temp.data+" ");
			
			if(flag)
			{
				if(temp.left!=null)s2.add(temp.left);
				if(temp.right!=null)s2.add(temp.right);
			}
			else
			{
			   if(temp.right!=null)s2.add(temp.right);
			   if(temp.left!=null)s2.add(temp.left);
			}
			
			if(s1.isEmpty())
			{
				flag = !flag;
				Stack<Node> s = s1;
				s1=s2;
				s2=s;
			}
			
		}
	}

}
