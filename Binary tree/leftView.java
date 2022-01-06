https://practice.geeksforgeeks.org/problems/left-view-of-binary-tree/1/#
// Given a Binary Tree, print Left view of it. Left view of a Binary Tree is set of nodes visible when tree is visited from Left side. The task is to complete the function leftView(), which accepts root of the tree as argument.

// Left view of following tree is 1 2 4 8.

//           1
//        /     \
//      2        3
//    /     \    /    \
//   4     5   6    7
//    \
//      8   

// Example 1:

// Input:
//    1
//  /  \
// 3    2
// Output: 1 3

// Example 2:

// Input:

// Output: 10 20 40
// Your Task:
// You just have to complete the function leftView() that prints the left view. The newline is automatically appended by the driver code.
// Expected Time Complexity: O(N).
// Expected Auxiliary Space: O(Height of the Tree).


class Tree
{
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root)
    {
      ArrayList<Integer> arr=new ArrayList<>();
        
     if(root==null)
     {
        return arr; 
     }
     
     Queue<Node> q=new LinkedList<>();
     q.add(root);
     
     while(!q.isEmpty())
     {
       int n=q.size();
       for(int i=0;i<n;i++)
       {
          
          Node temp = q.remove();
           if(i==0)
           {
               arr.add(temp.data);
           }
          if(temp.left!=null)
          {
              q.add(temp.left);
          }
          if(temp.right!=null)
          {
              q.add(temp.right);
          }
       }
     }
     return arr;
     }
}
