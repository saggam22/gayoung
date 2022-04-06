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
				System.out.println("\n1.문제관리 2.회원관리 9.로그아웃하기");
				System.out.println(">> ");
				input = scn.nextInt();
				if (input == 1) {
					System.out.println("1.문제리스트 2.문제등록 3.문제수정 4.문제삭제");
					System.out.println(">> ");
					input2 = scn.nextInt();

					if (input2 == 1) {
						List<Question> qlist = qService.qList();
						for (Question q : qlist) {
							System.out.println(q.toString());
						}
					} else if (input2 == 2) {
						System.out.println("문제번호를 입력하세요");
						int qId = scn.nextInt();
						if (qService.searchQ(qId) != null) {
							System.out.println("이미 등록된 문제번호입니다.");
						} else {
							System.out.println("문제내용을 입력하세요");
							scn.nextLine();
							String qContents = scn.nextLine();
							System.out.println("문제보기를 입력하세요(작성완료시 end 입력)");
							String qSelect = "";
							String select = "";
							while (scn.hasNext()) {
								if ((select = scn.nextLine()).equals("end")) {
									break;
								} else {
									qSelect += (" " + select + "\r\n");
								}
							}
							System.out.println("정답을 입력하세요");
							int answer = scn.nextInt();

							Question q = new Question(qId, qContents, qSelect, answer);
							qService.insetQ(q);
						}
					} else if (input2 == 3) {
						System.out.println("수정할 문제번호를 입력하세요");
						int qId = scn.nextInt();
						System.out.println("문제내용을 입력하세요");
						scn.nextLine();
						String qContents = scn.nextLine();
						System.out.println("문제보기를 입력하세요(작성완료시 end 입력)");
						String qSelect = "";
						String select = "";
						do {
							qSelect += ("   " + select + "\r\n");
						} while((select = scn.nextLine()).equals("end"));
						System.out.println("정답을 입력하세요");
						int answer = scn.nextInt();

						Question q = new Question(qId, qContents, qSelect, answer);
						qService.updateQ(q);

					} else if (input2 == 4) {
						System.out.println("삭제할 문제번호를 입력하세요");
						int qId = scn.nextInt();
						if (qService.searchQ(qId) == null) {
							System.out.println("문제번호를 확인하세요");
						} else {
							qService.deleteQ(qId);
							System.out.println("정상적으로 삭제되었습니다.");
						}
					}
				} else if (input == 2) {
					System.out.println("1.회원리스트 2.회원등록 3.회원정보수정 4.회원삭제 5.회원검색(회원번호) 6.회원검색(회원이름)");
					System.out.println(">> ");
					input2 = scn.nextInt();

					if (input2 == 1) {
						System.out.println("===========================================");
						System.out.println("회원번호\t|비밀번호\t|회원이름\t|회원연락처");
						System.out.println("-------------------------------------------");
						List<Member> memlist = mService.memberList();
						for (Member m : memlist) {
							System.out.println(m.toStringAdmin());
						}
						System.out.println("===========================================");

					} else if (input2 == 2) {
						System.out.println("회원번호를 입력하세요");
						int memId = scn.nextInt();
						if (mService.searchMember(memId) != null) {
							System.out.println("이미 등록된 회원번호입니다.");
						} else {
							System.out.println("비밀번호를 입력하세요");
							int password = scn.nextInt();
							System.out.println("회원이름을 입력하세요");
							String memName = scn.next();
							System.out.println("연락처를 입력하세요");
							String memPhone = scn.next();

							Member mem = new Member(memId, password, memName, memPhone);
							mService.insetMember(mem);
							System.out.println("정상적으로 등록되었습니다.");
						}
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
						if (mService.searchMember(memId) == null) {
							System.out.println("회원번호를 확인하세요");
						} else {
							mService.deleteMember(memId);
							System.out.println("정상적으로 삭제되었습니다.");
						}
					} else if (input2 == 5) {
						System.out.println("검색할 회원번호를 입력하세요");
						int memId = scn.nextInt();
						Member serchmem = mService.searchMember(memId);
						if (serchmem == null) {
							System.out.println("조회된 결과가 없습니다.");
						} else {
							System.out.println(serchmem.toString());
							System.out.println("정상적으로 조회되었습니다.");
						}
					} else if (input2 == 6) {
						System.out.println("조회할 회원이름을 입력하세요");
						String memName = scn.next();
						List<Member> searchName = mService.serchName(memName);
						if (searchName.size() == 0) {
							System.out.println("조회된 결과가 없습니다.");
						} else {
							System.out.println("===========================================");
							System.out.println("회원번호\t|비밀번호\t|회원이름\t|회원연락처");
							System.out.println("-------------------------------------------");
							for (Member m : searchName) {
								System.out.println(m.toString());
							}
							System.out.println("===========================================");
							System.out.println("정상적으로 조회되었습니다.");
						}
					}
				} else if (input == 9) {
					System.out.println("로그아웃되었습니다.");
					break;
				} else {
					System.out.println("메뉴 중에서 선택해주세요..");
				}
			} catch (InputMismatchException e) {
				System.out.println("번호를 입력해주세요..");
				scn.next();
			}
		}
		System.out.println("end of AdminExe");
	} // end of AdminExecute
}