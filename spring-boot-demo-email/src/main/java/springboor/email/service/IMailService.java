package springboor.email.service;


import springboor.email.commont.model.Email;

public interface IMailService {
	void send(Email email)throws Exception;
	void sendHtml(Email email)throws Exception;
	void sendFreemarker(Email email)throws Exception;
	void sendThymeleaf(Email email)throws Exception;
	void sendQueue(Email email)throws Exception;
	void sendRedisQueue(Email email)throws Exception;
	springboor.email.commont.model.Result listMail(Email email);
}
