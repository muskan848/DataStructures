//O(m*n), where m and n are rows and columns, respectively
//https://practice.geeksforgeeks.org/problems/flood-fill-algorithm1856/1#
//https://leetcode.com/problems/flood-fill/submissions/

class Solution
{
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor)
    {
        boolean visit[][]=new boolean[image.length][image[0].length];
         flood(image,sr,sc,image[sr][sc],newColor,visit);
         return image;
    }
    
    public void flood(int[][] image,int r,int c,int i,int newColor,boolean visit[][])
    {
        if(r<0||c<0||r>=image.length||c>=image[0].length||image[r][c]!=i||visit[r][c]==true)
        {
            return;
        }
        
        if(image[r][c]==i)
        {
            image[r][c]=newColor;
        }
        
        visit[r][c]=true;
        
        flood(image,r-1,c,i,newColor,visit);
        flood(image,r,c-1,i,newColor,visit);
        flood(image,r+1,c,i,newColor,visit);
        flood(image,r,c+1,i,newColor,visit);
        
        visit[r][c]=false;
    }
}
