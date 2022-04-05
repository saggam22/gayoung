package personal.project;

import java.util.*;

public class youngNetApp {

	Scanner scn = new Scanner(System.in);
	MemberService mService = new MemberServieQracle();
	AdminExe admin = new AdminExe();
	UserExe user = new UserExe();

	public void execute() {
		// 로그인
		int input;
		while (true) {
			try {
				System.out.println("1.로그인 2.회원등록 9.프로그램종료");
				input = scn.nextInt();
				if (input == 1) {
					System.out.println("회원번호를 입력하세요");
					int memId = scn.nextInt();
					System.out.println("비밀번호를 입력하세요");
					int password = scn.nextInt();

					Member mem = mService.logExecute(memId, password);

					if (mem != null && memId == 100) {
						System.out.println("관리자 로그인 성공! \n관리자모드를 실행합니다.");
						admin.adminExecute();

					} else if (mem != null && memId != 100) {
						System.out.println("로그인 성공\n" + memId + "님 환영합니다.");
						user.userExecute();

					} else if (mem == null) {
						System.out.println("회원번호 또는 비밀번호를 확인하세요..");
					}

					// break;

				} else if (input == 2) {
					System.out.println("회원번호를 입력하세요");
					int memId = scn.nextInt();
					System.out.println("비밀번호를 입력하세요");
					int password = scn.nextInt();
					System.out.println("이름을 입력하세요");
					String memName = scn.next();
					System.out.println("핸드폰번호를 입력하세요");
					String memPhone = scn.next();

					Member mem = new Member(memId, password, memName, memPhone);
					mService.insetMember(mem);

					break;

				} else if (input == 9) {
					System.out.println("프로그램을 종료합니다.");
					break;
				} else {
					System.out.println("1 또는 2 중에서 선택해주세요..");
				}
			} catch (InputMismatchException e) {
				System.out.println("번호를 입력해주세요..");
				scn.next();
			}
		}
		System.out.println("end of prog");
	} // end of execute

}
