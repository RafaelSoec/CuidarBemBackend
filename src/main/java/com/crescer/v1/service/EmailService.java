package com.crescer.v1.service;

import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.crescer.v1.exception.ResponseException;
import com.crescer.v1.model.dtos.EmailDTO;

@Service
public class EmailService {
	@Value("${spring.mail.username}")
	private String user;

	@Autowired
	private MailSender mailSender;

	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	private TemplateEngine templateEngine;

	public void enviarEmail(EmailDTO email) {
		try {
			SimpleMailMessage sm = new SimpleMailMessage();
			sm.setSentDate(new Date(System.currentTimeMillis()));
			sm.setTo(email.getDestinatarios());
			sm.setSubject(email.getAssunto());
			sm.setText(email.getMensagem());
			sm.setFrom(user);

			mailSender.send(sm);
		} catch (Exception e) {
			throw new ResponseException("Falha ao enviar email. ");

		}
	}

	public void enviarHtmlEmail(EmailDTO email, String pathHTML, Map<String, Object> variaveis) {
		try {
			String mensagem = criarMensagemEmailPorHtml(pathHTML, variaveis);
			this.enviarHtmlEmail(email, mensagem);
		} catch (Exception e) {
			throw new ResponseException(e.getMessage());

		}
	}
	
	public void enviarHtmlEmail(EmailDTO email, String mensagem) {
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mmh;
		try {
			mmh = new MimeMessageHelper(mimeMessage, true);
			mmh.setSentDate(new Date(System.currentTimeMillis()));
			mmh.setTo(email.getDestinatarios());
			mmh.setSubject(email.getAssunto());
			mmh.setText(mensagem, true);
			mmh.setFrom(user);
			javaMailSender.send(mimeMessage);
		} catch (MessagingException e) {
			throw new ResponseException(e.getMessage());

		}
	}

	private String criarMensagemEmailPorHtml(String pathHTML, Map<String, Object> variaveis) {
		Context context = new Context();
		for (Entry<String, Object> entry : variaveis.entrySet()) {
			context.setVariable(entry.getKey(), entry.getValue());
		}

		return templateEngine.process(pathHTML, context);

	}
}