package mylab.user.service;

import mylab.user.repository.UserRepository;
import mylab.user.security.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired private UserRepository userRepository;
    @Autowired private SecurityService securityService;

    // ✅ 테스트와 동일한 시그니처(인자 2개)
    public boolean registerUser(String id, String pw) {
        // 간단 인증: 둘 다 비어있지 않으면 OK
        if (!securityService.authenticate(id, pw)) return false;
        userRepository.save(id);
        return true;
    }

    // 테스트에서 사용하는 getter들
    public UserRepository getUserRepository() { return userRepository; }
    public SecurityService getSecurityService() { return securityService; }
}
