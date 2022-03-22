package com.edu.interfaces;

public interface Dao extends RemoteControl, Run { //인터페이스끼리 다중상속을 받을 수 있고 이 인터페이스를 사용하는 클래스들은 다중상속된 메소드를 모두 사용하여야 오류가 생기지 않음

		public void select();
		public void insert();
		public void update();
		public void delete();
}
