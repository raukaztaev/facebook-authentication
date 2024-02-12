package sib.coursework.authenticator.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sib.coursework.authenticator.services.*;

import javax.mail.MessagingException;


@Controller
@Slf4j
@RequestMapping
public class MainController {

    private final RepositoryService repositoryService = new RepositoryService();
    private final AuthenticationService authentication = new AuthenticationService(repositoryService);
    private final RegistrationService registration = new RegistrationService(repositoryService);
    private final GenerateCodeService generateCode = new GenerateCodeService();
    private final EmailSenderService emailSender = new EmailSenderService();
    private static String generatedCode;

    @GetMapping("/index")
    public String login() {
        return "index";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @GetMapping("/authenticate")
    public String authenticate(@RequestParam String email) {
        generatedCode = generateCode.getCode();

        System.out.println("to send: " + email);
        try {
            emailSender.sendMessage(email, generatedCode);
        } catch (MessagingException e) {
            log.error("Код не отправлен");
            e.printStackTrace();
        }

        return "authenticate";
    }

    @PostMapping("/index")
    public String login(@RequestParam String email,
                        @RequestParam String password,
                        RedirectAttributes redirectAttributes) {
        if (authentication.authenticateUser(email, password)) {
            redirectAttributes.addAttribute("email", email);
            return "redirect:/authenticate";
        } else {
            return "index";
        }
    }

    @PostMapping("/register")
    public String register(@RequestParam String name,
                           @RequestParam String email,
                           @RequestParam String password,
                           @RequestParam String confirmPassword,
                           RedirectAttributes redirectAttributes) {
        if (!password.equals(confirmPassword)) {
            return "register";
        }

        if (registration.registrateUser(name, email, password)) {
            redirectAttributes.addAttribute("email", email);
            return "redirect:/authenticate";
        }

        return "register";
    }

    @PostMapping("/authenticate")
    public String authenticate(@RequestParam String code,
                               @RequestParam String email,
                               RedirectAttributes redirectAttributes) {
        if (code.equals(generatedCode)) {
            generatedCode = null;
            log.info("Пользователь {} вошел в аккаунт", email);
            return "redirect:/home";
        } else {
            redirectAttributes.addAttribute(email);
            return "authenticate";
        }
    }
}
