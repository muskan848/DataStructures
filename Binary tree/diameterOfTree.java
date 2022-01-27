https://leetcode.com/problems/diameter-of-binary-tree/

class Solution {
    
    int m=0;
    
    public int diameterOfBinaryTree(TreeNode root) 
    {
        solve(root);
        return m;
    }
    
     public int solve(TreeNode root)
     {
       if(root==null)
        {
            return 0;
        }
        
        int lh=solve(root.left);
        int rh=solve(root.right);
        
        m=Math.max(m,lh+rh);
        return Math.max(lh,rh)+1;
     }
}
