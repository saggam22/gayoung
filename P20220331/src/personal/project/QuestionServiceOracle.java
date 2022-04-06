package personal.project;

import java.sql.*;
import java.util.*;

public class QuestionServiceOracle extends DAO implements QuestionService {

	@Override
	public void insetQ(Question q) {
		conn = getConn();
		try {
			psmt = conn.prepareStatement("INSERT INTO question (question_id, question_contents, answer, question_select) VALUES (?, ?, ?, ?)");
			psmt.setInt(1, q.getQuestionId());
			psmt.setString(2, q.getQuestionContents());
			psmt.setInt(3, q.getAnswer());
			psmt.setString(4, q.getQuestionSelect());
			
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
		try {
			psmt = conn.prepareStatement("SELECT * FROM question ORDER BY question_id");
			rs = psmt.executeQuery();
			while (rs.next()) {
				Question q = new Question();
				q.setQuestionId(rs.getInt("question_id"));
				q.setQuestionContents(rs.getString("question_contents"));
				q.setAnswer(rs.getInt("answer"));
				q.setQuestionSelect(rs.getString("question_select"));
				
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
		Question q = null;
		try {
			psmt = conn.prepareStatement("SELECT * FROM question WHERE question_id = ?");
			psmt.setInt(1, qId);
			rs = psmt.executeQuery();
			if (rs.next()) {
				q = new Question();
				q.setQuestionId(rs.getInt("question_id"));
				q.setQuestionContents(rs.getString("question_contents"));
				q.setAnswer(rs.getInt("answer"));
				q.setQuestionSelect(rs.getString("question_select"));
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
			psmt = conn.prepareStatement("UPDATE question SET question_contents = ?, answer = ?, question_select = ? WHERE question_id = ?");
			psmt.setString(1, q.getQuestionContents());
			psmt.setInt(2, q.getAnswer());
			psmt.setString(3, q.getQuestionSelect());
			psmt.setInt(4, q.getQuestionId());
			
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

	@Override
	public List<Question> aList() {
		conn = getConn();
		List<Question> qlist = new ArrayList<Question>();
		Question q = null;
		try {
			psmt = conn.prepareStatement("SELECT * FROM question ORDER BY question_id");
			rs = psmt.executeQuery();
			while(rs.next()) {
				q = new Question();
				q.setQuestionId(rs.getInt("question_id"));
				q.setQuestionContents(rs.getString("question_contents"));
				q.setAnswer(rs.getInt("answer"));
				q.setQuestionSelect(rs.getString("question_select"));
				qlist.add(q);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConn();
		}
		return qlist;
	}

}//end of class
