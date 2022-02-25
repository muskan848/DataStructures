https://practice.geeksforgeeks.org/problems/median-of-bst/1/

class Tree
{
    public static float findMedian(Node root)
    {
      ArrayList<Integer> arr=new ArrayList<>();
     
      inorder(root,arr);
      
      float ans=0;
      int size = arr.size()-1;
      
      if(size%2==0)//even
      {
         ans = arr.get(size/2);
      }
      else //odd
      {
        int temp = size/2;
       
       ans = (arr.get(temp) + arr.get(temp+1));
       ans = ans/(float)2.0 ;
      }
      return ans;
    }
    
    private static void inorder(Node root,ArrayList<Integer> arr)
    {
        if(root==null)return;
        inorder(root.left,arr);
        arr.add(root.data);
        inorder(root.right,arr);
    }
}
