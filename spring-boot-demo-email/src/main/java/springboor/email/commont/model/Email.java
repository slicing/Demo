package springboor.email.commont.model;

import java.io.Serializable;
import java.util.HashMap;

public class Email implements Serializable {
	private static final long serialVersionUID = 1L;
	private String[] email;
	private String subject;
	private String content;
	private String template;
	private HashMap<String,String> kvMap;

	public Email() {
	}

	public Email(String[] email, String subject, String content, String template, HashMap<String, String> kvMap) {
		this.email = email;
		this.subject = subject;
		this.content = content;
		this.template = template;
		this.kvMap = kvMap;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String[] getEmail() {
		return email;
	}

	public void setEmail(String[] email) {
		this.email = email;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public HashMap<String, String> getKvMap() {
		return kvMap;
	}

	public void setKvMap(HashMap<String, String> kvMap) {
		this.kvMap = kvMap;
	}
}
