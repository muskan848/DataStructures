//https://www.pepcoding.com/resources/online-java-foundation/graphs/perfect-friends-official/ojquestion

import java.io.*;
import java.util.*;

public class Main {
   

   public static void main(String[] args) throws Exception
   {
       Scanner sc=new Scanner(System.in);
       ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
     
       int n=sc.nextInt();
      
       int k=sc.nextInt();
       
       for(int i=0;i<n;i++)
       {
         ArrayList<Integer> arr=new ArrayList<>();
         adj.add(i,arr);  
       }

       while(k-->0)
       {
           int a=sc.nextInt();
           int b=sc.nextInt();
           
           adj.get(a).add(b);
           adj.get(b).add(a);
       }
       
       ArrayList<ArrayList<Integer>> comp=new ArrayList<>();
       
       boolean visit[]=new boolean[n];
       
       for(int i=0;i<n;i++)
       {
          if(visit[i]==false)
          {
              ArrayList<Integer> arr1=new ArrayList<>();
             dfs(adj,i,arr1,visit); 
             comp.add(arr1);
          }
       }
       int s=0;
       for(int i=0;i<comp.size();i++)
       {
           for(int j=i+1;j<comp.size();j++)
           {
              int temp = comp.get(i).size() * comp.get(j).size();
              s=s+temp;
           }
       }
       System.out.println(s);
   }
   
   public static void dfs(ArrayList<ArrayList<Integer>>adj,int srs ,ArrayList<Integer> arr ,boolean visit[])
   {
      visit[srs]=true;
      arr.add(srs);
      for(int neighbour : adj.get(srs))
      {
          if(visit[neighbour]==false)
          {
              dfs(adj,neighbour,arr,visit);
          }
      }
   }

}
