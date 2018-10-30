package springboor.email.entity;


import org.thymeleaf.standard.expression.Each;
import springboor.email.commont.model.Email;

import javax.persistence.*;
import javax.xml.crypto.Data;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Arrays;

@Entity
@Table(name="oa_email")
public class OaEmail implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id",unique = true,nullable = false)
	private Long id;
	@Column(name = "receive_email",nullable = false,length = 500)
	private String receiveEmail;//接收者
	@Column(name = "subject",nullable = false,length = 100)
	private String subject;//主题
	@Column(name = "content",nullable = false,length = 65535)
	private String content;//内容
	@Column(name = "template",nullable = false,length = 100)
	private String template;//模板
	@Column(name = "send_time",nullable = false,length = 19)
	private Timestamp sendTime;//发送时间

	public OaEmail() {
	}
	public OaEmail(Email email){
		this.receiveEmail = Arrays.toString(email.getEmail());
		this.subject = email.getSubject();
		this.content = email.getContent();
		this.template = email.getTemplate();
		this.sendTime = new Timestamp(System.currentTimeMillis());
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getReceiveEmail() {
		return receiveEmail;
	}

	public void setReceiveEmail(String receiveEmail) {
		this.receiveEmail = receiveEmail;
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

	public Timestamp getSendTime() {
		return sendTime;
	}

	public void setSendTime(Timestamp sendTime) {
		this.sendTime = sendTime;
	}
}
