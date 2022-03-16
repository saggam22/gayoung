package com.prod;

public class User {
	private String userId;
	private char userGrade;
	private String userPhone;
	private int userPoint;
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public void setUserGrade(char userGrade) {
		this.userGrade = userGrade;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public void setUserPoint(int userPoint) {
		this.userPoint = userPoint;
	}
	public String getUserId() {
		return userId;
	}
	public char getUserGrade() {
		return userGrade;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public int getUserPoint() {
		return userPoint;
	}
	
	public String getUserInfo() {
		String info = this.userId + "의 등급은 " + this.userGrade + "이고 연락처는 "
				+ this.userPhone + "이고 포인트는 " + this.userPoint + "점 입니다.";
		return info;
	}
}
