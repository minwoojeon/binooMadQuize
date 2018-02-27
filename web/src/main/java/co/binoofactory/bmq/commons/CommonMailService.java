package co.binoofactory.bmq.commons;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * @Class Name : CommonMailService
 * @Description : It is custom processing method to mail service. (javax.mail)
 * @author botbinoo@naver.com
 * @since 2018.02.28
 * @version 1
 *
 *  Copyright (C) by botbinoo's All right reserved.
 */

public class CommonMailService {
	
	public boolean sendMailTo ( 
			final int smtpv, 						/* SMTP type */
			final String meId, 						/* Transmission user id */
			final String mePw, 						/* Transmission user pw */
			final String toId, 						/* Receive user id */
			final String title, 					/* Mail title */
			final String contents 					/* Mail contents */
		) {
		
		/* smtpv values -> choose smtp type */
		String host;
		switch(smtpv) {
			case 0x01:
				host = "smtp.naver.com";			// send in naver
				break;
			case 0x02:
				host = "smtp.hanmail.net";			// send in daum
				break;
			case 0x03:
				host = "smtp.gmail.com";			// send in google
				break;
			default:
				return false;
		}

		// SMTP server state
		Properties props = System.getProperties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", 465);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.ssl.enable", "true");
		props.put("mail.smtp.ssl.trust", host);
		
		// Create session
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
				return new javax.mail.PasswordAuthentication(meId, mePw);
			}
		});
		session.setDebug(true); //for debug
		   
		try {
			Message mimeMessage = new MimeMessage(session);						// msg
			mimeMessage.setFrom(new InternetAddress(meId+"@naver.com"));		// set my email
			mimeMessage.setRecipient(
					Message.RecipientType.TO, new InternetAddress(toId));		// set user .CC (ÂüÁ¶)
			mimeMessage.setSubject(title);										// set title
			mimeMessage.setText(contents);										// set contents
			Transport.send(mimeMessage);										// javax.mail.Transport.send()
			
			return false;
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}
