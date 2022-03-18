package com.dev;
// Account(class-계좌번호, 예금주, 잔액)
public class Account {
	
	private String accNo;
	private String accName;
	private int money;
	
	public static String bankName;
	static {
		bankName = "한일은행";
	}
	
	public static void showBankName() {
		System.out.println("한일은행입니다.");
	}
	
	//constructor
	public Account(String accNo, String accName, int money) {
		super();
		this.accNo = accNo;
		this.accName = accName;
		this.money = money;
	}
	
	//method
	public String getAccNo() {
		return accNo;
	}
	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}
	public String getAccName() {
		return accName;
	}
	public void setAccName(String accName) {
		this.accName = accName;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}

	@Override
	public String toString() {
		return "Account [accNo=" + accNo + ", accName=" + accName + ", money=" + money + "]";
	}
	
}
