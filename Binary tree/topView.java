https://practice.geeksforgeeks.org/problems/top-view-of-binary-tree/1/#
// Given below is a binary tree. The task is to print the top view of binary tree. Top view of a binary tree is the set of nodes visible when the tree is viewed from the top. For the given below tree

//        1
//     /     \
//    2       3
//   /  \    /   \
// 4    5  6   7

// Top view will be: 4 2 1 3 7
// Note: Return nodes from leftmost node to rightmost node.

// Example 1:

// Input:
//       1
//    /    \
//   2      3
// Output: 2 1 3
// Example 2:

// Input:
//        10
//     /      \
//   20        30
//  /   \    /    \
// 40   60  90    100
// Output: 40 20 10 30 100
// Your Task:
// Since this is a function problem. You don't have to take input. Just complete the function topView() that takes root node as parameter and returns a list of nodes visible from the top view from left to right.

// Expected Time Complexity: O(N)
// Expected Auxiliary Space: O(N).



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
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root)
    {
      ArrayList<Integer> arr= new ArrayList<>();
    
      Map<Integer,Integer>map = new TreeMap<>();
      
      if(root==null)
      {
          return arr;
      }
      
      Queue<pair> q= new LinkedList<>();
      
      q.add(new pair(root,0));
      
      while(!q.isEmpty())
      {
        pair temp = q.remove();
        
        Node data = temp.data;
        
        int level = temp.level;
        
        if(!map.containsKey(level))
        {
            map.put(level,data.data);
        }
        
        if(data.left!=null)
        {
            q.add(new pair(data.left,level-1));
        }
        
        if(data.right!=null)
        {
            q.add(new pair(data.right,level+1));
        }
      }
      
      for(Map.Entry<Integer,Integer> m : map.entrySet())
      {
         arr.add(m.getValue()); 
      }
      
      return arr;
    }
}
