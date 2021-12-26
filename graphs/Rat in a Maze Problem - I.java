https://practice.geeksforgeeks.org/problems/rat-in-a-maze-problem/1

// m is the given matrix and n is the order of matrix

// time->  worst case = 4^(n*n) because 4 direction for every cell
// space-> O(L * X), L = length of the path, X = number of paths.

class Solution {
    public static ArrayList<String> findPath(int[][] m, int n)
    {
        ArrayList<String> arr=new ArrayList<>();
        boolean visit[][]=new boolean[n][n];
        String psf="";
        ratInMaze(n,m,0,0,psf,visit,arr);

       Collections.sort(arr);
       return arr;
    }
    
    public static void ratInMaze(int n,int m[][],int r,int c,String psf,boolean visit[][],ArrayList<String>arr)
    {
                   
        if(r<0||c<0||r>=n||c>=n||m[r][c]==0||visit[r][c]==true)
        {
            return;
        }


        if(r==n-1&&c==n-1)
        {  
           arr.add(psf); 
           return;
        }

        visit[r][c]=true;
        
        ratInMaze(n,m,r-1,c,psf+'U',visit,arr);
        ratInMaze(n,m,r+1,c,psf+'D',visit,arr);
        ratInMaze(n,m,r,c-1,psf+'L',visit,arr);
        ratInMaze(n,m,r,c+1,psf+'R',visit,arr);
        
        visit[r][c]=false;

    }
}
