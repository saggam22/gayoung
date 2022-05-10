package co.edu.todo;

public class ToDoVO {
	private String todo;
	private String status;
	
	public ToDoVO() {
		super();
	}

	public ToDoVO(String todo) {
		super();
		this.todo = todo;
	}
	
	public ToDoVO(String todo, String status) {
		super();
		this.todo = todo;
		this.status = status;
	}

	public String getTodo() {
		return todo;
	}

	public void setTodo(String todo) {
		this.todo = todo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
