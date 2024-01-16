package sib.coursework.authenticator.services;

import org.springframework.stereotype.Service;

import java.util.Random;
@Service
public class GenerateCodeService {
    private final Random random;

    public GenerateCodeService() {
        this.random = new Random();
    }

    public String getCode() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            sb.append(random.nextInt(0,10));
        }

        return sb.toString();
    }
}
