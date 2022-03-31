package personal.project;

import java.util.List;

public interface MemberService {

		public String logExecute(int memID, int password); //회원 로그인
		public void insetMember(Member mem); //회원등록
		public List<Member> memberList(); //회원전체리스트
		public Member searchMember(int memId); //회원검색
		public List<Member> serchName(String memName); //회원이름검색
		public void updateMember(Member mem); //회원정보수정
		public void deleteMember(int memberId); //회원삭제
		
}
