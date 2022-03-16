package com.prod;

public class UserExample {
	public static void main(String[] args) {
		
		User u1 = new User();
		u1.setUserId("001");
		u1.setUserGrade('A');
		u1.setUserPhone("010-1111-2222");
		u1.setUserPoint(5000);
		
		User u2 = new User();
		u2.setUserId("002");
		u2.setUserGrade('C');
		u2.setUserPhone("010-3333-4444");
		u2.setUserPoint(1000);
		
		User u3 = new User();
		u3.setUserId("003");
		u3.setUserGrade('B');
		u3.setUserPhone("010-5555-6666");
		u3.setUserPoint(3000);
		
		User[] users = {u1, u2, u3};
		
		for (int i=0; i<users.length; i++) {
			if(users[i].getUserGrade() == 'A' && users[i].getUserPoint() >= 1000 ) {
				System.out.println(users[i].getUserInfo());
			}
		}
	}
}
