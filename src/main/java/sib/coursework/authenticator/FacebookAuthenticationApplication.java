package sib.coursework.authenticator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mail.MailSenderValidatorAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration(exclude={MailSenderValidatorAutoConfiguration.class})
public class FacebookAuthenticationApplication {

	public static void main(String[] args) {
		SpringApplication.run(FacebookAuthenticationApplication.class, args);
	}

}
