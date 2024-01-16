package sib.coursework.authenticator.services;


import org.springframework.stereotype.Service;
import sib.coursework.authenticator.data.User;

@Service
public class RegistrationService {
    private final RepositoryService repository;

    public RegistrationService(RepositoryService repository) {
        this.repository = repository;
    }

    public boolean registrateUser(String name, String email, String password) {
        User user = new User(name, email, password);
        if (repository.getUserByEmail(email) != null) {
            return false;
        } else {
            repository.addNewUser(user);
            return true;
        }
    }
}
