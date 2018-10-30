package springboor.email.service.impl;


import freemarker.template.Configuration;
import freemarker.template.Template;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.util.ResourceUtils;
import org.thymeleaf.spring5.SpringTemplateEngine;
import springboor.email.commont.dynamicQuery.DynamicQuery;
import springboor.email.commont.model.Email;
import springboor.email.commont.model.Result;
import springboor.email.commont.queue.MailQueue;
import springboor.email.commont.util.Constants;
import springboor.email.entity.OaEmail;
import springboor.email.repository.MailRepository;
import springboor.email.service.IMailService;

import javax.mail.internet.MimeMessage;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MailServiceImpl implements IMailService {
	private static final Logger logger = LoggerFactory.getLogger(MailServiceImpl.class);
	@Autowired
	private DynamicQuery dynamicQuery;
	@Autowired
	private MailRepository mailRepository;
	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	public Configuration configuration;
	@Autowired
	private SpringTemplateEngine templateEngine;
	@Value("1142931804@qq.com")
	public String USER_NAME;
	@Value("http://localhost:8080/springboot_mail")
	public String PATH;
	@Autowired
	private RedisTemplate<String,String>redisTemplate;
	static {
		System.setProperty("mail.mime.splitlongparameters","flase");
	}
	@Override
	public void send(Email email) throws Exception {
		logger.info("发送邮件：{}",email.getContent());
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(USER_NAME);
		message.setTo(email.getEmail());
		message.setSubject(email.getSubject());
		message.setText(email.getContent());
		mailSender.send(message);
	}

	@Override
	public void sendHtml(Email email) throws Exception {
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message,true);
		helper.setFrom(USER_NAME,"笨笨滚球");
		helper.setTo(email.getEmail());
		helper.setSubject(email.getSubject());
		helper.setText("<html><body><img src=\"cid:springcloud\"></body></html>",true);
		File file = ResourceUtils.getFile("classpath:static" +
				Constants.SF_FILE_SEPARATOR + "image"
		+ Constants.SF_FILE_SEPARATOR+"springcloud.png");
		helper.addInline("springcloud",file);
		file = ResourceUtils.getFile("classpath:static"+
		Constants.SF_FILE_SEPARATOR+"file"+
		Constants.SF_FILE_SEPARATOR);
		helper.addAttachment("",file);
		mailSender.send(message);
	}

	@Override
	public void sendFreemarker(Email email) throws Exception {
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message,true);
		helper.setFrom(USER_NAME,"笨笨滚球");
		helper.setTo(email.getEmail());
		helper.setSubject(email.getSubject());
		Map<String,Object> model = new HashMap<>();
		model.put("mail",email);
		model.put("path",PATH);
		Template template =  configuration.getTemplate(email.getTemplate());
		String text = FreeMarkerTemplateUtils.processTemplateIntoString(template,model);
		helper.setText(text,true);
		mailSender.send(message);
		email.setContent(text);
		OaEmail oaEmail = new OaEmail(email);
		mailRepository.save(oaEmail);

	}

	@Override
	public void sendThymeleaf(Email email) throws Exception {

	}

	@Override
	public void sendQueue(Email email) throws Exception {
		MailQueue.getMailQueue().product(email);
	}

	@Override
	public void sendRedisQueue(Email email) throws Exception {
		redisTemplate.convertAndSend("mail",email);
	}

	@Override
	public Result listMail(Email email) {
		List<OaEmail> list = mailRepository.findAll();
		return Result.ok(list);
	}
}
