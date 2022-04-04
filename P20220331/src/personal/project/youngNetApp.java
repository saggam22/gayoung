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
				System.out.println("1.로그인 2.회원등록");
				input = scn.nextInt();
				if (input == 1) {
					System.out.println("회원번호를 입력하세요");
					int memId = scn.nextInt();
					System.out.println("비밀번호를 입력하세요");
					int password = scn.nextInt();
					if (memId == 100) {
						String messege = mService.logExecute(memId, password);
						System.out.println(messege);
						System.out.println("관리자모드를 실행합니다.");
						admin.adminExecute();

					} else {
						mService.logExecute(memId, password);
						System.out.println(memId + "님 환영합니다.");
						user.userExecute();
					}

					break;

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

				} else {
					System.out.println("1 또는 2 중에서 선택해주세요..");
				}
			} catch (InputMismatchException e) {
				System.out.println("번호를 입력해주세요..");
				scn.next();
			}
		}
	} // end of execute

}
