//Program which implements BFS using queue 

package bfs;

import java.util.LinkedList;
import java.util.Queue;

class bfsHelper
{
    int inputMatrix[][];
    int root=0;
    int totalNodes;
    Boolean visited[];
    
    bfsHelper(int mat[][])
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
    void bfs()
    {
        Queue<Integer> bfsQueue = new LinkedList<Integer>();
        bfsQueue.add(root);
        printNode(root);
        visited[root] = true;
        while(!bfsQueue.isEmpty())
        {
            int currentTop = bfsQueue.peek();
            int child = nextUnvisitedNeighbour(currentTop);
            if(child!=-1)
            {
                visited[child] = true;
                bfsQueue.add(child);
                printNode(child);
            }
            else
            {
                bfsQueue.remove();
            }
        }
        
    }
}



public class BFS {

    public static void main(String[] args) {
    
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


      bfsHelper graph = new bfsHelper(input);
      graph.clearVisitedProperty();
      graph.bfs();    
        
    }
    
}
