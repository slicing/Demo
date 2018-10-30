package springboor.email.commont.queue;

import org.apache.tomcat.jni.Poll;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import springboor.email.commont.model.Email;
import springboor.email.service.IMailService;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class ConsumMailQueue {
	private static final Logger logger = LoggerFactory.getLogger(ConsumMailQueue.class);
	@Autowired
	IMailService mailService;
	@PostConstruct
	public void startThread(){
		ExecutorService e = Executors.newFixedThreadPool(2);
		e.submit(new PollMail(mailService));
		e.submit(new PollMail(mailService));
	}
	class PollMail implements Runnable{
		IMailService mailService;
		public PollMail(IMailService mailService){
			this.mailService = mailService;
		}
		@Override
		public void run() {
			while (true) {
				try {
					Email mail = MailQueue.getMailQueue().consume();
					if (mail != null) {
						logger.info("剩余邮件总数:{}", MailQueue.getMailQueue().size());
						mailService.send(mail);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	@PreDestroy
	public void stopThread(){
		logger.info("destroy");
	}
}
