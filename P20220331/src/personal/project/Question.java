package personal.project;

public class Question {
	
	private int questionId;
	private String questionContents;
	private String questionSelect;
	private int answer;
	
	
	public Question() {
	}
	
	public Question(int questionId, String questionContents, String questionSelect, int answer) {
		super();
		this.questionId = questionId;
		this.questionContents = questionContents;
		this.questionSelect = questionSelect;
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
	
	public String getQuestionSelect() {
		return questionSelect;
	}

	public void setQuestionSelect(String questionSelect) {
		this.questionSelect = questionSelect;
	}

	public int getAnswer() {
		return answer;
	}

	public void setAnswer(int answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		
		String str = "=========================================================================\n" //
				+ " 문제번호 " + questionId + "\t | \t 정답 " + answer  + "\n" 
				+"-------------------------------------------------------------------------\n"
				+ questionContents
				+ "\n"
				+ questionSelect
				+"\n=========================================================================";

		return str;
	}
	
	public String toQeustion() {
		String str = "-------------------------------------------------------------------------\n" //
				+ questionId + ". " + questionContents  + "\n" 
				+ questionSelect
				+"\n-------------------------------------------------------------------------";

		return str;
	}
	
	public int toAnswer() {
		int a = answer;
		return a;
	}
	
}
