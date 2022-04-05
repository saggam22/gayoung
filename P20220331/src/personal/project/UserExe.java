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
					List<Question> qlist = qService.aList(); //문제리스트 리턴 클래스타입
					List<Integer> alist = new ArrayList<Integer>(); //답리스트 답을 넣어준다
					List<Integer> mylist = new ArrayList<Integer>(); //입력하는 답 리스트
					int jumsu = 0;

					Collections.shuffle(qlist);
					qlist = qlist.subList(0, 2);
					for (Question q : qlist) {
						System.out.println(q.toQeustion());
						alist.add(q.getAnswer());
						System.out.println("답 입력 >> ");
						int answer = scn.nextInt();
						mylist.add(answer);
					}
					
					System.out.print("\n정답: ");
					for (int a : alist) {
						System.out.print(a);
					}
					System.out.print("\n답안: ");
					for (int my : mylist) {
						System.out.print(my);
					}
					System.out.print("\n정오: ");
					
					for(int i=0; i<alist.size(); i++) {
						if (alist.get(i) == mylist.get(i)) {
							System.out.print("O");
							jumsu++;
						} else {
							System.out.print("X");
						}	
					}
					System.out.println("\n" + "채점결과 점수 :" + jumsu);

				} else if (input == 2) {
					List<Question> qlist = qService.qList();
					for (Question q : qlist) {
						System.out.println(q.toString());
					}

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

				} else {
					System.out.println("메뉴 중에서 선택해주세요..");
				}
			} catch (
			InputMismatchException e) {
				System.out.println("번호를 입력해주세요..");
				scn.next();
			}
		}
	} // end of AdminExecute
}
