package sib.coursework.authenticator;

import sib.coursework.authenticator.services.AuthenticationService;
import sib.coursework.authenticator.services.EmailSenderService;
import sib.coursework.authenticator.services.GenerateCodeService;
import sib.coursework.authenticator.services.RepositoryService;
import sib.coursework.authenticator.data.User;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SomeTest {
    //    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, MessagingException {
//        RepositoryService repositoryService = new RepositoryService();
//        AuthenticationService authenticationService = new AuthenticationService(repositoryService);
//        System.out.println(authenticationService.authenticateUser("admin@face.book", "password"));
//    EmailSenderService emailSend = new EmailSenderService("iammafiozy@gmail.com", new GenerateCodeService().getCode());
//    }

//    public static void main(String[] args) throws MessagingException {
//
//        final String username = "rtishtyk@gmail.com";
//        final String password = "Askvklol457";
//
//        Properties properties = new Properties();
//        properties.put("mail.smtp.host", "smtp.gmail.com");
//        properties.put("mail.smtp.port", "465");
//        properties.put("mail.smtp.ssl.enable", "true");
//        properties.put("mail.smtp.auth", "true");
//
//        Session session = Session.getDefaultInstance(
//                properties,
//                new Authenticator() {
//                    @Override
//                    protected PasswordAuthentication getPasswordAuthentication() {
//                        return new PasswordAuthentication(username, "vubxapleluorjdwy");
//                    }
//                }
//        );
//        session.setDebug(true);
//        try {
//            MimeMessage message = new MimeMessage(session);
//            message.setFrom(new InternetAddress(username));
//            message.addRecipient(Message.RecipientType.TO, new InternetAddress("iammafiozy@mail.ru"));
//            message.setSubject("aaf");
//            message.setText("afafaf");
//            Transport.send(message);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
