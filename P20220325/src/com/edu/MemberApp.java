package com.edu;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MemberApp {

	List<Member> members = new ArrayList<Member>();
	Scanner scn = new Scanner(System.in);

	// MemberService를 구현하는 구현클래스를 선언
	class MemberServiceImple implements MemberService {

		@Override
		public void addMember(Member member) {
			members.add(member);
		}

		@Override
		public void modifyMember(Member member) {
			for (int i = 0; i < members.size(); i++) {
				if (members.get(i).getMemberId() == member.getMemberId()) {
					members.get(i).setPhone(member.getPhone());
				}
			}
		}

		@Override
		public List<Member> memberList() {
			return members;
		}
	}

	public void execute() {
		// 메유: 1.등록 2.수정 3.전체리스트 9.종료
		// 도서반 => 기본정보 + 도서반장,강의실이름
		// 축구반 => 기본정보 + 코치이름, 락커룸이름
		// 수영반 => 기본정보 + 강사이름, 수영등급

		MemberService service = new MemberServiceImple();

		while (true) {
			int menu = 0;
			while (true) {
				try {
					System.out.println("메뉴>> 1.등록 2.수정(연락처) 3.전체리스트 9.종료");
					System.out.print("선택>> ");
					menu = scn.nextInt();
					break;
				} catch (InputMismatchException e) {
					System.out.println("숫자를 입력하지 않으셨네요..");
					scn.next();
				}
			}
			if (menu == 1) {
				System.out.println("등록>> 1.도서반 2.축구반 3.강습반(수영)");  //1,2 숫자 말고 축구반을 입력할때는 equals를 써서 if문을 나누어도된다
				System.out.print("선택>> ");

				int menu2 = scn.nextInt();

				System.out.print("회원번호를 입력하세요> ");
				int num = scn.nextInt();
				System.out.print("회원이름을 입력하세요> ");
				String name = scn.next();
				System.out.print("연락처를 입력하세요> ");
				String phone = scn.next();

				if (menu2 == 1) { // 도서반
					System.out.print("반장이름을 입력하세요> ");
					String bname = scn.next();
					System.out.print("강의실(지혜실, 지식실, 모험실)을 입력하세요> ");
					String broom = scn.next();

					Member book = new BookMember(num, name, phone, bname, broom);
					service.addMember(book);
					
					//따로 변수를 선언하지 않고, 메소드를 호출하지 않고 바로 리스트 추가도 가능 => members.add(new BookMember(num, name, phone, bname, broom));
					//변수를 선언하지 않고 리스트 추가 가능 => service.addMember(new BookMember(num, name, phone, bname, broom));

				} else if (menu2 == 2) { // 축구반
					System.out.print("코치이름을 입력하세요> ");
					String sname = scn.next();
					System.out.print("락커룸(A, B, C, D)을 입력하세요> ");
					String sroom = scn.next();

					Member soccer = new SoccerMember(num, name, phone, sname, sroom);
					service.addMember(soccer);

				} else if (menu2 == 3) { // 강습반
					System.out.print("강사이름을 입력하세요> ");
					String swname = scn.next();
					System.out.print("수영등급(A,B,C,D)을 입력하세요> ");
					String swgrade = scn.next();

					Member swim = new SwimMember(num, name, phone, swname, swgrade);
					service.addMember(swim);
				}

			} else if (menu == 2) {

				System.out.print("수정할 회원번호를 입력하세요> ");
				int num2 = scn.nextInt();
				System.out.print("핸드폰번호를 입력하세요> ");
				String phone2 = scn.next();

				Member m = new Member(num2, null, phone2);

				service.modifyMember(m);

			} else if (menu == 3) { // 전체리스트 조회
				List<Member> members = service.memberList();
				for (Member mem : members) {
					System.out.println(mem.toString());
				}

			} else if (menu == 9) {
				System.out.println("프로그램을 종료합니다.");
				break;
			} else {
				System.out.println("잘못된 메뉴를 선택했습니다.");
			}
		}
		System.out.println("end of prog");
	}
}
