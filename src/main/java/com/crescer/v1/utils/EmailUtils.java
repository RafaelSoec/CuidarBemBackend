package com.crescer.v1.utils;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.crescer.v1.exception.ResponseException;
import com.crescer.v1.model.dtos.EmailDTO;


@Component
public class EmailUtils {

	@Value("${spring.mail.username}")
	private String user;

	@Value("${spring.mail.password}")
	private String password;


	public Session config() {
		Properties props = new Properties();

		/** Parâmetros de conexão com servidor Gmail */
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		try {
			Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(user, password);
				}
			});
			session.setDebug(true);

			return session;
		} catch (Exception e) {
			throw new ResponseException("Falha ao tentar conectar no email de configuração. ");
		}
	}

	public void enviar(EmailDTO email) {
		String assunto = email.getAssunto();
		String mensagem = email.getMensagem();

		try {
			Session session = this.config();
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(user));

			Address[] toUser = InternetAddress.parse(email.getDestinatarios());
			message.setRecipients(Message.RecipientType.TO, toUser);
			message.setSubject(assunto);
			message.setText(mensagem);
			Transport.send(message);
		} catch (MessagingException e) {
			throw new ResponseException("Falha ao tentar enviar email.");
		}
	}

    
}