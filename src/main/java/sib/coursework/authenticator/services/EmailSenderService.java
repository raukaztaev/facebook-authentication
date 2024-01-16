package sib.coursework.authenticator.services;

import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
public class EmailSenderService {
    private static final String EMAILSENSER = "rtishtyk@gmail.com";
    private static final String PASSWORD = "vubxapleluorjdwy";
    private Properties properties;
    private Session session;


    public EmailSenderService() {
        properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        session = Session.getDefaultInstance(
                properties,
                new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(EMAILSENSER, PASSWORD);
                    }
                }
        );
        session.setDebug(true);
    }

    public void sendMessage(String sendTo, String message) throws MessagingException {
        MimeMessage mimeMessage = new MimeMessage(session);
        mimeMessage.setFrom(new InternetAddress(EMAILSENSER));
        mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(sendTo));
        mimeMessage.setSubject("Никому не сообщайте свой код");
        mimeMessage.setText(message);
        Transport.send(mimeMessage);
    }
}
