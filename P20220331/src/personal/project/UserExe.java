package personal.project;

import java.util.*;

public class UserExe {

	// 멤버로 로그인했을때
	Scanner scn = new Scanner(System.in);
	MemberService mService = new MemberServieQracle();
	QuestionService qService = new QuestionServiceOracle();

	public void userExecute() {

		int input;
		while (true) {
			try {
				System.out.println("1.시험치기(채점O) 2.문제확인(채점X) 3.내정보수정");
				input = scn.nextInt();
				if (input == 1) {
					List<Question> qlist = qService.aList();
					List<Question> alist = qService.qAnswer();
					List<Integer> mylist = new ArrayList<Integer>();
					int jumsu = 0;

					for (Question q : qlist) {
						System.out.println(q.toQeustion());
						System.out.println("답 입력 >> ");
						int answer = scn.nextInt();
						mylist.add(answer);
					}
					System.out.print("\n정답: ");
					for (Question q : alist) {
						System.out.print(q.toAnswer());
					}

					System.out.print("\n답안: ");
					for (int my : mylist) {
						System.out.print(my);
					}
					System.out.print("\n정오: ");
					for (Question q : alist) {
						for (int my : mylist) {
							if (q.toAnswer() == my) {
								System.out.print(" O");
								jumsu++;
							} else
								System.out.print(" X");
						}
					}
					System.out.println("\n" + "채점결과 점수 :" + jumsu);

					continue;

				} else if (input == 2) {
					List<Question> qlist = qService.qList();
					for (Question q : qlist) {
						System.out.println(q.toString());
					}
					continue;
				} else if (input == 3) {
					System.out.println("수정할 회원번호를 입력하세요");
					int memId = scn.nextInt();
					System.out.println("비밀번호를 입력하세요");
					int password = scn.nextInt();
					System.out.println("회원이름을 입력하세요");
					String memName = scn.next();
					System.out.println("연락처를 입력하세요");
					String memPhone = scn.next();

					Member mem = new Member(memId, password, memName, memPhone);
					mService.updateMember(mem);
					continue;

				} else {
					System.out.println("메뉴 중에서 선택해주세요..");
				}

			} catch (InputMismatchException e) {
				System.out.println("번호를 입력해주세요..");
				scn.next();
			}
		}
	} // end of AdminExecute
}
