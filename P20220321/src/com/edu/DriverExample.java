package com.edu;

public class DriverExample {
	public static void main(String[] args) {
		
		Vehicle v1 = new Vehicle();
		v1 = new Taxi();
		v1 = new Bus(); //Vehicle 상속이 아니면 사용할 수 없음
		
		Driver driver = new Driver();
		driver.drive(v1); //어떤 인스턴스냐에 따라 동일한 변수지만 결과값이 달라짐 => 매개변수의 다형성
		
		Vehicle vehicle = new Vehicle();
		Taxi taxi = new Taxi();
		Bus bus = new Bus();
		
		System.out.println("Vehicle의 최고속력 : " + vehicle.getMaxSpeed());
		System.out.println("Taxi의 최고속력 : " + taxi.getMaxSpeed());
		System.out.println("Bus의 최고속력 : " + bus.getMaxSpeed());
		
		Vehicle[] vehicles = new Vehicle[3];
		vehicles[0] = vehicle;
		vehicles[1] = taxi;
		vehicles[2] = bus;
		
		//속도가 제일 빠른 타는 것의 값부터 정렬해서 vehicles[0] = taxi, bus... 순
		for (int j = 0; j<vehicles.length-1; j++) {
			Vehicle temp = vehicles[0]; //배열선언을 Vehicle로 해줬으니 temp의 변수값도 Vehicle 배열로...
			for (int i = 0; i<vehicles.length-1; i++) {
				if( vehicles[i].getMaxSpeed() < vehicles[i+1].getMaxSpeed() ) {
					temp = vehicles[i];
					vehicles[i] = vehicles[i+1];
					vehicles[i+1] = temp;
				}
			}
		}
		System.out.println("제일 빠른 거 : " + vehicles[0].toString()); //택시의 최고속도는 120입니다.
		System.out.println("제일 느린 거 : " + vehicles[2].toString());
		
		for (int i = 0; i<vehicles.length; i++) {
			System.out.println(vehicles[i].getMaxSpeed());
		}
	}
}
