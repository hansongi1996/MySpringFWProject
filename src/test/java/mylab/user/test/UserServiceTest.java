package mylab.user.test;

import mylab.user.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:mylab-user-di.xml")
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void userService_빈_주입_확인() {
        // 주입 받았는지 (Null 아님)
        assertNotNull(userService);
    }

    @Test
    public void repository_security_주입_및_값_검증() {
        assertNotNull(userService.getUserRepository());
        assertEquals("MySQL", userService.getUserRepository().getDbType()); // 과제 요구 사항
        assertNotNull(userService.getSecurityService());
    }

    @Test
    public void 사용자_등록_기능_검증() {
        boolean ok = userService.registerUser("kim", "pwd1234");
        assertTrue(ok);
    }
}