package com.bfs;

import java.util.ArrayList;
import java.util.List;

public class Queue<T> {
	List<T> input = new ArrayList<T>();
	
	public void push(T t){
		input.add(t);
	}
	
	public T pop(){
		return input.remove(0);
	}
	
	public boolean isEmpty(){
		return input.size()>0?false:true;
	}
	
}
