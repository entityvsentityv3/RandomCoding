package com.minimumspanningtree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/*
  A   B  C  D  E  F  G  H  I
A 00 04 00 00 00 00 00 08 00
B 04 00 08 00 00 00 00 11 00
C 00 08 00 07 00 04 00 00 02
D 00 00 07 00 09 14 00 00 00
E 00 00 00 09 00 10 00 00 00
F 00 00 04 14 10 00 02 00 00    
G 00 00 00 00 00 02 00 01 06
H 08 11 00 00 00 00 01 00 07
I 00 00 02 00 00 00 06 07 00

9
00 04 00 00 00 00 00 08 00
04 00 08 00 00 00 00 11 00
00 08 00 07 00 04 00 00 02
00 00 07 00 09 14 00 00 00
00 00 00 09 00 10 00 00 00
00 00 04 14 10 00 02 00 00    
00 00 00 00 00 02 00 01 06
08 11 00 00 00 00 01 00 07
00 00 02 00 00 00 06 07 00
*/

public class MinimumSpanningTree {
	static int size = -1;
	static List<Set<Integer>> nodeSet = new ArrayList<Set<Integer>>();
	static int sum = 0;
	static String edges = "";//startNode endNode,
	static Map<Integer,String> nodeMap = new HashMap<Integer,String>();
	
	public static void main(String[] args){

		minTree();
		
		System.out.println(nodeSet);
		System.out.println(sum);
		System.out.println(edges);
	}
	
	public static void minTree(){
		int[][] adjM = createAdjMatrix();
		createNodeSet();
		nodeMap();
		while(true){
			int size = minSpan(adjM);
			if(size==1){
				break;
			}
		}
	}
	
	public static void nodeMap(){
		for(int i=0;i<size;i++){
			switch(i){
				case 0:
					nodeMap.put(i,"a");
					break;
				case 1:
					nodeMap.put(i,"b");
					break;
				case 2:
					nodeMap.put(i,"c");
					break;
				case 3:
					nodeMap.put(i,"d");
					break;	
				case 4:
					nodeMap.put(i,"e");
					break;
				case 5:
					nodeMap.put(i,"f");
					break;
				case 6:
					nodeMap.put(i,"g");
					break;
				case 7:
					nodeMap.put(i,"h");
					break;	
				case 8:
					nodeMap.put(i,"i");
					break;						
					
			}
		}
	}
	public static void createNodeSet(){
		for(int i=0;i<size;i++){
			Set<Integer> set = new HashSet<Integer>();
			set.add(i);
			nodeSet.add(set);
			
		}
	}

	public static int minSpan(int[][] adjM){
		int min = Integer.MAX_VALUE;
		int startNode = -1;
		int endNode = -1;
		for(int i=0;i<size;i++){
			for(int j=0;j<size;j++){
				if(min>adjM[i][j] && adjM[i][j]!=0){
					min=adjM[i][j];
					startNode = i;
					endNode = j;
				}
			}
		}
		if(startNode!=-1 || endNode!=-1){
			adjM[startNode][endNode] =  0;
			adjM[endNode][startNode] =  0;
		}
		//Check which node has only one element
		int k = -1;
		//if start node and end node belong to the same set
		int startSet = -1;
		int endSet = -1;
		for(int i=0;i<nodeSet.size();i++){
			Set<Integer>set = nodeSet.get(i);

			if(set.contains(startNode)){
				startSet=i;
			}
			if(set.contains(endNode)){
				endSet=i;
			}
		}
		
		if(startSet==endSet){
			sum+=min;
			return nodeSet.size();
		}
		
		//end start node and end node belong to the same set
		Set<Integer>removedSet = null;
		for(int j=0;j<nodeSet.size();j++){
			Set<Integer>set = nodeSet.get(j);
			if(set.contains(startNode)){
				removedSet= nodeSet.remove(j);
				break;
			}
		}
		
		for(int j=0;j<nodeSet.size();j++){
			Set<Integer>set = nodeSet.get(j);
			if(set.contains(endNode)){
				set.addAll(removedSet);
				edges+=nodeMap.get(startNode)+" "+nodeMap.get(endNode)+",";
				break;
			}
		}
			
		if(min!=-1){
			sum+=min;
		}
		return nodeSet.size();
	}
	public static int[][] createAdjMatrix(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the dimensions:");
		size = sc.nextInt();
		int[][] adjM = new int[size][size];
		System.out.println("Enter Matrix Data");
		for(int i=0;i<size;i++){
			for(int j=0;j<size;j++){
				adjM[i][j] = sc.nextInt();
			}
		}
		return adjM;
	}
}



