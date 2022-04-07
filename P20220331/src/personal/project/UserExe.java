package personal.project;

import java.util.*;

public class UserExe {

	// 멤버로 로그인했을때
	Scanner scn = new Scanner(System.in);
	MemberService mService = new MemberServieQracle();
	QuestionService qService = new QuestionServiceOracle();

	public void userExecute(int logId) {

		int input, input2;
		while (true) {
			try {
				System.out.println("\n1.시험치기(채점O) 2.문제확인(채점X) 3.마이페이지 9.로그아웃하기");
				System.out.print(">> ");
				input = scn.nextInt();
				if (input == 1) { // 5문제 중 3문제 랜덤으로 출력
					List<Question> qlist = qService.aList(); // 문제리스트 리턴 클래스타입
					List<Integer> alist = new ArrayList<Integer>(); // 답리스트 답을 넣어준다
					List<Integer> mylist = new ArrayList<Integer>(); // 입력하는 답 리스트
					int jumsu = 0;

					System.out.println("\n시험을 시작합니다.");

					Collections.shuffle(qlist);
					qlist = qlist.subList(0, 5);
					for (Question q : qlist) {
						System.out.println(q.toQeustion());
						alist.add(q.getAnswer());
						System.out.print("답 입력 >> ");
						int answer = scn.nextInt();
						mylist.add(answer);
					}
					System.out.println("=============<성적표>===============");
					System.out.print("\n정답: ");
					for (int a : alist) {
						System.out.print(" " + a);
					}
					System.out.print("\n답안: ");
					for (int my : mylist) {
						System.out.print(" " + my);
					}
					System.out.print("\n정오: ");

					for (int i = 0; i < alist.size(); i++) {
						if (alist.get(i) == mylist.get(i)) {
							System.out.print(" O");
							jumsu++;
						} else {
							System.out.print(" X");
						}
					}
					int jumsuu = jumsu * 20;
					String result = "";
					if (jumsuu < 60) {
						result = "불합격";
						System.out.println("\n불합격입니다. 좀 더 공부하세요\n");
					} else {
						result = "합격";
						System.out.println("\n★★축하합니다! 합격입니다★★\n");
					}
					System.out.println("점수 : " + jumsuu);
					System.out.println("====================================");

					Exam ex = new Exam(logId, jumsuu, result);
					mService.insertExam(ex);

				} else if (input == 2) {
					List<Question> qlist = qService.qList();
					for (Question q : qlist) {
						System.out.println(q.toString());
					}

				} else if (input == 3) {
					System.out.println("\n1.내 시험결과 2.내정보수정 3.비밀번호변경 4.탈퇴하기");
					System.out.print(">> ");
					input2 = scn.nextInt();
					if (input2 == 1) {
						if (mService.searchMember(logId) == null) {
							System.out.println("회원번호를 확인하세요");
						} else {
							Member mem = new Member(logId);
							List<Exam> exList = mService.myExamList(mem);
							System.out.println("===========================================");
							System.out.println("응시날짜\t|점수\t|합격여부");
							System.out.println("-------------------------------------------");
							for (Exam e : exList) {
								System.out.println(e.myExamList());
							}
							System.out.println("===========================================");
						}
					} else if (input2 == 2) {
						System.out.println(logId + "님의 회원정보입니다.");
						Member serchmem = mService.searchMember(logId);

						System.out.println("==============================================");
						System.out.println("회원번호\t|회원이름\t|회원연락처");
						System.out.println("----------------------------------------------");
						System.out.println(serchmem.toString());

						System.out.println("\n회원정보를 수정하시겠습니까? (y/n)");
						System.out.print(">> ");
						String s = scn.next();
						
						if (s.equals("y") || s.equals("Y")) {
							System.out.println("회원이름을 입력하세요");
							String memName = scn.next();
							System.out.println("연락처를 입력하세요");
							String memPhone = scn.next();

							Member mem = new Member(logId, memName, memPhone);
							mService.updateMyInfo(mem);
							System.out.println("정상적으로 수정되었습니다.");
							break;
						} else if (s.equals("n") || s.equals("N")) {
							System.out.println("초기 메뉴로 돌아갑니다.");
							continue;
						} else {
							System.out.println("잘못된 입력입니다.");
						}
						
					} else if (input2 == 3) {
						System.out.println("비밀번호를 입력하세요");
						int password = scn.nextInt();

						Member mem = new Member(logId, password);
						mService.updateMyPs(mem);

					} else if (input2 == 4) {
						System.out.println("정말로 탈퇴하시겠습니까? (y/n)");
						System.out.print(">> ");
						String s = scn.next();
						if (s.equals("y") || s.equals("Y")) {
							mService.deleteMember(logId);
							System.out.println("정상적으로 탈퇴되었습니다.");
							break;
						} else if (s.equals("n") || s.equals("N")) {
							System.out.println("초기 메뉴로 돌아갑니다.");
							continue;
						} else {
							System.out.println("잘못된 입력입니다.");
						}
					}
				} else if (input == 9) {
					System.out.println("로그아웃되었습니다.");
					break;
				} else {
					System.out.println("메뉴 중에서 선택해주세요..");
				}
			} catch (InputMismatchException e) {
				System.out.println("번호를 입력하지 않아 메뉴로 돌아갑니다.");
				scn.next();
			}
		}
		System.out.println("end of UserExe");
	} // end of AdminExecute
}
