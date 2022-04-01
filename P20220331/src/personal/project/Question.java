package personal.project;

public class Question {
	
	private int questionId;
	private String questionContents;
	private int answer;
	
	
	public Question() {
	}
	
	public Question(int questionId, String questionContents, int answer) {
		super();
		this.questionId = questionId;
		this.questionContents = questionContents;
		this.answer = answer;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getQuestionContents() {
		return questionContents;
	}

	public void setQuestionContents(String questionContents) {
		this.questionContents = questionContents;
	}

	public int getAnswer() {
		return answer;
	}

	public void setAnswer(int answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "문제리스트 [문제번호=" + questionId + ", 문제내용=" + questionContents + ", 정답=" + answer
				+ "]";
	}
	
	public String toQeustion() {
		return "[문제번호=" + questionId + ", 문제내용=" + questionContents + "]";
	}
	
	public int toAnswer() {
		int a = answer;
		return a;
	}
	
}
