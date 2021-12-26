https://practice.geeksforgeeks.org/problems/steps-by-knight5927/1#

// We have to use BFS here because BFS works in parallel for all the approachable path
//and so whenever we reach the destination with any path then that first
//path will always be minimum.
//And this is why we have to use BFS as it works in parallel.
// And we can not use DFS here because with DFS we will keep on 
//moving in depth till we either reach the destination 
//or we visit all the cells and no more cells to visit. 
//And so then we will backtrack and then we will try another path
//and with that another path suppose we are able to reach then we can not be sure that this is path is minimum path only. 
//Because DFS does not work in parallel. And so if we are using DFS 
//then we have to use traverse all the possible paths and then only we can select minimum out of all of them.
// But with BFS first path with which we reach destination is always be the minimum path.


//dfs
// class Solution
// {
//     //Function to find out minimum steps Knight needs to reach target position.
//     public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N)
//     {
//         int moves[][]=new int[N+1][N+1];
//         knight(KnightPos[0],KnightPos[1],KnightPos,TargetPos,N,moves,0);
//         return moves[TargetPos[0]][TargetPos[1]];
//     }
   
//     public static void knight(int c,int r,int knightpos[],int targetpos[],int n,int moves[][],int count)
//     {
//         if(c<1||r<1||c>n||r>n||moves[c][r]>0)
//         {
//             return;
//         }
        
//         if(c==targetpos[0] && r==targetpos[1])
//         {
//           moves[targetpos[0]][targetpos[1]] = Math.min(moves[targetpos[0]][targetpos[1]],moves[c][r]);
//           return;
//         }
            
//         moves[c][r]=count;
       
//         knight(c+2,r+1,knightpos,targetpos,n,moves,count++);
//         knight(c+2,r-1,knightpos,targetpos,n,moves,count++);
//         knight(c+1,r-2,knightpos,targetpos,n,moves,count++);
//         knight(c-1,r-2,knightpos,targetpos,n,moves,count++);
//         knight(c-2,r-1,knightpos,targetpos,n,moves,count++);
//         knight(c-2,r+1,knightpos,targetpos,n,moves,count++);
//         knight(c-1,r+2,knightpos,targetpos,n,moves,count++);
//         knight(c+1,r+2,knightpos,targetpos,n,moves,count++);
        
//         moves[c][r]=0;
//     }
// }


//bfs
class pair{
    
    int x;
    int y;
    int dis;
    
    public pair(int x,int y,int dis)
    {
        this.x=x;
        this.y=y;
        this.dis=dis;
    }
}

class Solution
{
        public boolean isSafe(int x,int y,int n)
        {
        return x>=1&&x<=n&&y>=1&&y<=n;
          }

   
    //Function to find out minimum steps Knight needs to reach target position.
    public int minStepToReachTarget(int knightPos[], int targetPos[], int N)
    {
        boolean visit[][]=new boolean[N+1][N+1];
        
         int dx[]={-2,-2,-1,-1,1,1,2,2};
         int dy[]={-1,1,-2,2,-2,2,-1,1};
         
         if(knightPos[0]==targetPos[0] && knightPos[1]==targetPos[1])
        {
            return 0;
        }

         Queue<pair> q=new LinkedList<>();

         q.add(new pair(knightPos[0],knightPos[1],0));
         
         while(!q.isEmpty())
         {
             pair p = q.remove();
             
            if(p.x==targetPos[0]&&p.y==targetPos[1])
              {
                return p.dis;
              }
             
         
             for(int i=0;i<8;i++)
             {
                 int x=p.x+dx[i];
                 int y=p.y+dy[i];
                 
                 if(isSafe(x,y,N) &&  (!visit[x][y]))
                 {
                    visit[x][y]=true;
                    q.add(new pair(x,y,p.dis+1));
                 }
             }
         }
         
       return Integer.MAX_VALUE;
         
    }
}

