package personal.project;

import java.util.List;

public interface QuestionService {

	public void insetQ(Question q); //문제등록
	public List<Question> qList(); //문제리스트
	public Question searchQ(int qId); //문제검색
	public void updateQ(Question q); //문제수정
	public void deleteQ(int qId); //문제삭제
	public List<Question> aList(); //문제풀기
	
}
