package piotr.kedra.receiptreminder.core.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.NotFoundException;
import java.util.Optional;

@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Boolean authenticate(String email, String password){
        Optional<User> user = userRepository.getUserByEmail(email);
        return user.map(u -> u.getPassword().equals(password))
                .orElseThrow(() -> new NotFoundException("There is no user with email: " + email));
    }
}
