//Topological sort for a directed graph using DFS.
package topologicalsort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TopologicalSort {
    //Computes DFS for a node
    static void dfs(List<Integer>[]graph,boolean visited[],List<Integer> result,int v)
    {
        visited[v] = true;
        for(int u: graph[v])
        {
            if(!visited[u])
                dfs(graph,visited,result,u);
        }
        result.add(v);
    }
    //Computes the topological sort
    public static List<Integer> topologicalSort(List<Integer>[]graph)
    {
        int n = graph.length;
        boolean visited[] = new boolean[n];
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            if(!visited[i])
                dfs(graph,visited,result,i);
           // System.out.println("Result is (i is"+i+" )"+result);
        }
        Collections.reverse(result);
        return result;
    }
    
    public static void main(String[] args)
    {        
        int n = 6;
        List<Integer>[] graph = new List[n];
        for(int i =0;i<n;i++)
        {
            graph[i] = new ArrayList<>();
            
        }
        graph[2].add(3);
        graph[3].add(1);
        graph[5].add(0);
        graph[5].add(2);
        graph[4].add(0);
        graph[4].add(1);
        System.out.println("Input graph is ");
        for(int i =0;i<n;i++)
        {
            System.out.print("Node "+i+":");
            for(int j=0;j<graph[i].size();j++)
            {
                System.out.print(" "+graph[i].get(j));
            }
            System.out.println(""); 
       }
        List<Integer> result = topologicalSort(graph);
        System.out.println("The topological sort for the given graph is "+result);
    }
    
}
