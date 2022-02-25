https://practice.geeksforgeeks.org/problems/kth-largest-element-in-bst/1

class Node
{
    int data;
    Node left;
    Node right;
    Node(int data)
    {
        this.data = data;
        left=null;
        right=null;
    }
}
*/
class Solution
{
    // return the Kth largest element in the given BST rooted at 'root'
    int ans=-1;
    int c=0;


    public int kthLargest(Node root,int K)
    {
        if(root==null) return -1;
      
        solve(root,K);
       
        return ans;

    }
    
    private void solve(Node root,int K)
    {
       if(root==null)return ;
       
        solve(root.right,K);
    
        c++;
    
        if(K==c){ans=root.data;}

        solve(root.left,K);
        
    }
}
