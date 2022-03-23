package com.edu.generic;

//ArrayList<Integer>
public class Box<T> { //T : 어떤 타입인지 모르겠지만 파라메타 값이 들어오면 선언하는 시점에 타입을 맞춰서 변경된다.
	T obj;
	
	public void setObj(T obj) {
		this.obj = obj;
	}
	
	public T getObj() {
		return this.obj;
	}
}
