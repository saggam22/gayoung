package personal.project;

public class Exam extends Member {
	
	private String examDate;
	private int jumsu;
	private String result;

	
	public Exam() {
	
	}
	
	public Exam(int memberId) {
		super(memberId);
	}

	public Exam(int memberId, int jumsu, String result) {
		super(memberId);
		this.jumsu = jumsu;
		this.result = result;
	}

	public String getExamDate() {
		return examDate;
	}

	public void setExamDate(String examDate) {
		this.examDate = examDate;
	}

	public int getJumsu() {
		return jumsu;
	}

	public void setJumsu(int jumsu) {
		this.jumsu = jumsu;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String myExamList() {
		return examDate.substring(0, 10) + "\t|" + jumsu  + "\t|" + result;
	}
}
