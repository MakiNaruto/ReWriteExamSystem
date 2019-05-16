package com.suda.excel;

/**
 * @author Javen
 * @Email zyw205@gmail.com
 * 
 */
public class TestSetGetAll {
	private int id;
	private String question ;
	private String answer ;
	private String knowledge;
	private String subject;
	
	
	
	public TestSetGetAll() {
	}
	public TestSetGetAll(int id,String question,String answer,String knowledge,String subject) {
		this.id = id;
		this.question = question;
		this.answer = answer;
		this.knowledge = knowledge;
		this.subject = subject;
	}
	@Override
	public String toString() {
		return "StuEntity [id=" + id + ", question=" + question + ", answer=" + answer + ", knowledge=" + knowledge
				+ ", subject=" + subject + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getKnowledge() {
		return knowledge;
	}
	public void setKnowledge(String knowledge) {
		this.knowledge = knowledge;
	}

	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	
	
	
	
	
}
