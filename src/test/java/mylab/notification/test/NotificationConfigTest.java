package mylab.notification.test;

import mylab.notification.config.NotificationConfig;
import mylab.notification.core.NotificationManager;
import mylab.notification.service.impl.EmailNotificationService;
import mylab.notification.service.impl.SmsNotificationService;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = NotificationConfig.class)
public class NotificationConfigTest {

    @Autowired
    private NotificationManager notificationManager;

    @Test
    public void 주입_값_메서드_검증() {
        assertNotNull(notificationManager);

        EmailNotificationService email = notificationManager.getEmailService();
        assertNotNull(email);
        assertEquals("smtp.gmail.com", email.getSmtpServer());
        assertEquals(587, email.getPort());

        SmsNotificationService sms = notificationManager.getSmsService();
        assertNotNull(sms);
        assertEquals("SKT", sms.getProvider());

        System.out.println("\n===== 실행 테스트 =====");
        notificationManager.sendNotificationByEmail("테스트 이메일");
        notificationManager.sendNotificationBySms("테스트 SMS");
        System.out.println("=====================\n");
    }
}
