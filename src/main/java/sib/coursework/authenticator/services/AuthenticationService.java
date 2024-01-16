package sib.coursework.authenticator.services;

import org.springframework.stereotype.Service;
import sib.coursework.authenticator.data.User;

@Service
public class AuthenticationService {

    private final RepositoryService repositoryService;

    public AuthenticationService(RepositoryService repositoryService) {
        this.repositoryService = repositoryService;
    }

    public boolean authenticateUser(String email, String password) {
        User user = repositoryService.getUserByEmail(email);
        return user != null && user.getPassword().equals(Hashing.hash(password));
    }
}