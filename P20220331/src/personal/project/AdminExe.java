package personal.project;

import java.util.*;

public class AdminExe {
	Scanner scn = new Scanner(System.in);
	MemberService mService = new MemberServieQracle();
	QuestionService qService = new QuestionServiceOracle();

	public void adminExecute() {

		int input, input2;

		while (true) {
			try {
				System.out.println("1.문제관리 2.회원관리");
				input = scn.nextInt();
				if (input == 1) {
					System.out.println("1.문제리스트 2.문제등록 3.문제수정 4.문제삭제");
					input2 = scn.nextInt();

					if (input2 == 1) {
						List<Question> qlist = qService.qList();
						for (Question q : qlist) {
							System.out.println(q.toString());
						}

					} else if (input2 == 2) {
						System.out.println("문제번호를 입력하세요");
						int qId = scn.nextInt();
						System.out.println("문제내용을 입력하세요");
						String qContents = scn.next();
						System.out.println("정답을 입력하세요");
						int answer = scn.nextInt();

						Question q = new Question(qId, qContents, answer);
						qService.insetQ(q);

					} else if (input2 == 3) {
						System.out.println("수정할 문제번호를 입력하세요");
						int qId = scn.nextInt();
						System.out.println("문제내용을 입력하세요");
						String qContents = scn.next();
						System.out.println("정답을 입력하세요");
						int answer = scn.nextInt();

						Question q = new Question(qId, qContents, answer);
						qService.updateQ(q);

					} else if (input2 == 4) {
						System.out.println("삭제할 문제번호를 입력하세요");
						int qId = scn.nextInt();
						qService.deleteQ(qId);
					}
				} else if (input == 2) {
					System.out.println("1.회원리스트 2.회원등록 3.회원정보수정 4.회원삭제");
					input2 = scn.nextInt();

					if (input2 == 1) {
						List<Member> memlist = mService.memberList();
						for (Member m : memlist) {
							System.out.println(m.toStringAdmin());
						}

					} else if (input2 == 2) {
						System.out.println("회원번호를 입력하세요");
						int memId = scn.nextInt();
						System.out.println("비밀번호를 입력하세요");
						int password = scn.nextInt();
						System.out.println("회원이름을 입력하세요");
						String memName = scn.next();
						System.out.println("연락처를 입력하세요");
						String memPhone = scn.next();

						Member mem = new Member(memId, password, memName, memPhone);
						mService.insetMember(mem);

					} else if (input2 == 3) {
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

					} else if (input2 == 4) {
						System.out.println("삭제할 회원번호를 입력하세요");
						int memId = scn.nextInt();
						mService.deleteMember(memId);
					}
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