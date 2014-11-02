package com.bfs;
/*
 * Adjacency Matrix as per input
 */
public class BFS {
	static int NO_OF_NODES = 5;
	static int[][] adjMatrix = null;
	static int[] visited = new int[NO_OF_NODES];
	static Queue<Integer> queue = new Queue<Integer>();
	
	public static void main(String[] args){
		createAdjacencyMatrix();
		bfs();
	}
	
	public static void bfs(){
		queue.push(1);//Inserting the first Node
		int count = 0;
		visited[count]=1;
		count +=1;
		while(!queue.isEmpty()){
			Integer pop  = queue.pop();
			System.out.println(pop);
			for(int i=0;i<=NO_OF_NODES;i++){
				if(adjMatrix[pop][i]==1){
					if(!isVisited(i)){
						visited[count] = i;
						count+=1;
						queue.push(i);
					}
				}
			}
			
		}
	}
	
	public static boolean isVisited(int input){
		for(int i=0;i<NO_OF_NODES;i++){
			if(visited[i]==input){
				return true;
			}
		}
		
		return false;
	}
	
	public static void createAdjacencyMatrix(){
		adjMatrix = new int[6][6];
		
		adjMatrix[0][0] = 0;
		adjMatrix[0][1] = 0;
		adjMatrix[0][2] = 0;
		adjMatrix[0][3] = 0;
		adjMatrix[0][4] = 0;
		adjMatrix[0][5] = 0;
		
		adjMatrix[1][0] = 0;
		adjMatrix[1][1] = 0;
		adjMatrix[1][2] = 1;
		adjMatrix[1][3] = 1;
		adjMatrix[1][4] = 0;
		adjMatrix[1][5] = 0;
		
		adjMatrix[2][0] = 0;
		adjMatrix[2][1] = 0;
		adjMatrix[2][2] = 0;
		adjMatrix[2][3] = 0;
		adjMatrix[2][4] = 1;
		adjMatrix[2][5] = 1;
		
		adjMatrix[3][0] = 0;
		adjMatrix[3][1] = 0;
		adjMatrix[3][2] = 0;
		adjMatrix[3][3] = 0;
		adjMatrix[3][4] = 1;
		adjMatrix[3][5] = 0;
		
		adjMatrix[4][0] = 0;
		adjMatrix[4][1] = 0;
		adjMatrix[4][2] = 0;
		adjMatrix[4][3] = 0;
		adjMatrix[4][4] = 0;
		adjMatrix[4][5] = 1;
		
		adjMatrix[5][0] = 0;
		adjMatrix[5][1] = 0;
		adjMatrix[5][2] = 0;
		adjMatrix[5][3] = 0;
		adjMatrix[5][4] = 0;
		adjMatrix[5][5] = 0;
		
		
	}
}
