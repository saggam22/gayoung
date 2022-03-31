package personal.project;

import java.sql.SQLException;
import java.util.*;

public class QuestionServiceOracle extends DAO implements QuestionService {

	@Override
	public void insetQ(Question q) {
		conn = getConn();
		try {
			psmt = conn.prepareStatement("INSERT INTO question (question_id, question_contents, answer) VALUES (?, ?, ?)");
			psmt.setInt(1, q.getQuestionId());
			psmt.setString(1, q.getQuestionContents());
			psmt.setInt(2, q.getAnswer());
			
			psmt.executeUpdate();
			
		} catch (SQLException e) {	
			e.printStackTrace();
		} finally {
			disConn();
		}
	} //end of insertQ

	@Override
	public List<Question> qList() {
		conn = getConn();
		List<Question> qlist = new ArrayList<Question>();
		Question q = new Question();
		try {
			psmt = conn.prepareStatement("SELECT * FROM question");
			rs = psmt.executeQuery();
			while (rs.next()) {
				q.setQuestionId(rs.getInt("question_id"));
				q.setQuestionContents(rs.getString("question_contents"));
				q.setAnswer(rs.getInt("answer"));
				
				qlist.add(q);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			disConn();
		}
		return qlist;
		
	}//end of qList

	@Override
	public Question searchQ(int qId) {
		conn = getConn();
		Question q = new Question();
		try {
			psmt = conn.prepareStatement("SELECT * FROM question WHERE question_id = ?");
			psmt.setInt(1, qId);
			rs = psmt.executeQuery();
			if (rs.next()) {
				q.setQuestionId(rs.getInt("question_id"));
				q.setQuestionContents(rs.getString("question_contents"));
				q.setAnswer(rs.getInt("answer"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConn();
		}
		return q;
	}

	@Override
	public void updateQ(Question q) {
		conn = getConn();
		try {
			psmt = conn.prepareStatement("UPDATE question SET question_contents = ?, answer = ? WHERE question_id = ?");
			psmt.setString(1, q.getQuestionContents());
			psmt.setInt(2, q.getAnswer());
			psmt.setInt(3, q.getQuestionId());
			
			psmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			disConn();
		}
	}//end of updateQ

	@Override
	public void deleteQ(int qId) {
		conn = getConn();
		try {
			psmt = conn.prepareStatement("DELETE FROM question WHERE question_id = ?");
			psmt.setInt(1, qId);
			psmt.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConn();
		}
	}//end of deleteQ

}//end of class
