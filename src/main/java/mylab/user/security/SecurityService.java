package mylab.user.security;

import org.springframework.stereotype.Component;

@Component
public class SecurityService {
    public boolean authenticate(String id, String pw) {
        return id != null && !id.isEmpty() && pw != null && !pw.isEmpty();
    }
}