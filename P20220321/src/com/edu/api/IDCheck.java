package com.edu.api;

public class IDCheck {
	//주민번호 입력 -> 남자인지 여자인지 확인
	
	//풀이2 - replace 활용
	public String getGender2(String gender) {
		String newSno = gender.replace("-", "");
		newSno = newSno.replace(" ", "");
		
		char gen;
		String genn = null;
		if (newSno.length() == 13) {
			gen = newSno.charAt(6);
			if (gen == '1' || gen == '3') {
				genn = "남자입니다.";	
			} else if (gen == '2' || gen == '4') {
				genn = "여자입니다.";
			} else {
				genn = "주민번호를 확인하세요.";
			}
		} else {
			genn =  "주민번호를 확인하세요.";
		}
		return genn;
	}	
	
	//풀이1 - switch 구문 활용 (근데 이 구문은 숫자자체를 잘못입력했을 때 번호를 확인하라는 메세지 출력의 어려움이 있음
	public String getGender(String gender) {
		
		//구문 1 - switch 사용
//		char gen;
//		if (gender.length() == 14) {
//			gen = gender.charAt(7);
//		} else if(gender.length() == 13) {
//			gen = gender.charAt(6);
//		} else {
//			gen = '5';
//		}
//		
//		String genn = null;
//		switch (gen) {
//		case '1' : 
//		case '3' :
//			genn = "남자입니다.";
//			break;
//		case '2' :
//		case '4' :
//			genn = "여자입니다.";
//			break;
//		case '5' :
//			genn = "주민번호를 확인하세요.";
//			break;
//		}
//		return genn;
		
		//구문2 - if 구문사용
		char gen;
		String genn = null;
		if (gender.length() == 14) {
			gen = gender.charAt(7);
			if (gen == '1' || gen == '3') {
				genn = "남자입니다.";	
			} else if (gen == '2' || gen == '4') {
				genn = "여자입니다.";
			} else {
				genn = "주민번호를 확인하세요.";
			}
		} else if(gender.length() == 13) {
			gen = gender.charAt(6);
			if (gen == '1' || gen == '3') {
				genn = "남자입니다.";	
			} else if (gen == '2' || gen == '4') {
				genn = "여자입니다.";
			} else {
				genn = "주민번호를 확인하세요.";
			}
		} else {
			genn =  "주민번호를 확인하세요.";
		}
		return genn;
	}		
}
 