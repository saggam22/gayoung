package com.prod;

public class Car {
	//필드 : 모델, 현재속도, 최고속도, 메소드: 가속(현재속도를 10km씩 증가시킴), 감속(10km씩 감소), 현재속도()
	
	private String model;
	private int speed;
	private int maxSpeed;
	
	public void setModel(String model) {
		this.model = model;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	//가속 메소드
	public void addSpeed() {
		if (this.speed + 10 > this.maxSpeed) {
			System.out.println("최고속도를 초과할 수 없습니다.");
			return; //메소드에서 return;구문을 만나면 메소드 종료
		}
		System.out.println("10km 가속합니다.");
		this.speed += 10;
	}
	
	public void breakSpeed() {
		if (this.speed -10 < 0) {
			System.out.println("0km 미만으로 주행할 수 없습니다.");
			return;
		}
		System.out.println("10km 감속합니다.");
		this.speed -= 10;
	}
	
	public int getSpeed() {
		return this.speed;
	}
}
