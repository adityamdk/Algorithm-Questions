//Program which performs DFS using Stack

package dfs;

import java.util.Stack;

class dfsHelper
{
    int inputMatrix[][];
    int root=0;
    int totalNodes;
    Boolean visited[];
    
    dfsHelper(int mat[][])
    {
        totalNodes = mat.length;
        visited = new Boolean[totalNodes];
        inputMatrix = new int[totalNodes][totalNodes];
        for(int i=0;i<totalNodes;i++)
        {
            for(int j=0;j<totalNodes;j++)
            {
                inputMatrix[i][j] = mat[i][j];
            }
        }
    }
    void clearVisitedProperty()
    {
        for(int i=0;i<totalNodes;i++)
        {
            visited[i] = false;
        }
    }
    void printNode(int i)
    {
        System.out.println(i);
    }
    int nextUnvisitedNeighbour(int node)
    {
       
            for(int j=0;j<totalNodes;j++)
            {
                if(inputMatrix[node][j]>0)
                {
                    if(!visited[j])
                    return j;
                }
            }
        return -1;
    }
    void dfs()
    {
        Stack<Integer> dfsStack = new Stack<Integer>();
        dfsStack.push(root);
        printNode(root);
        visited[root] = true;
        while(!dfsStack.isEmpty())
        {
            int currentTop = dfsStack.peek();
            int neighbour = nextUnvisitedNeighbour(currentTop);
            if(neighbour!=-1)
            {
                visited[neighbour] = true;
                dfsStack.push(neighbour);
                printNode(neighbour);
            }
            else
            {
                dfsStack.pop();
            }
        }
        
    }
}
public class DFS {
    public static void main(String[] args) 
    {
        //                        0  1  2  3  4  5  6  7  8
// ===================================================
      int[][] input = {  { 0, 1, 0, 1, 0, 0, 0, 0, 1 },  // 0
			{ 1, 0, 0, 0, 0, 0, 0, 1, 0 },  // 1
			{ 0, 0, 0, 1, 0, 1, 0, 1, 0 },  // 2
			{ 1, 0, 1, 0, 1, 0, 0, 0, 0 },  // 3
			{ 0, 0, 0, 1, 0, 0, 0, 0, 1 },  // 4
			{ 0, 0, 1, 0, 0, 0, 1, 0, 0 },  // 5
			{ 0, 0, 0, 0, 0, 1, 0, 0, 0 },  // 6
			{ 0, 1, 1, 0, 0, 0, 0, 0, 0 },  // 7
			{ 1, 0, 0, 0, 1, 0, 0, 0, 0 } };// 8


      dfsHelper graph = new dfsHelper(input);

      graph.clearVisitedProperty();
      graph.dfs();

    }
    
}
