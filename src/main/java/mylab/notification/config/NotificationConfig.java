package mylab.notification.config;

import mylab.notification.core.NotificationManager;
import mylab.notification.service.impl.EmailNotificationService;
import mylab.notification.service.impl.SmsNotificationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotificationConfig {

    @Bean
    public EmailNotificationService emailNotificationService() {
        return new EmailNotificationService("smtp.gmail.com", 587);
    }

    @Bean
    public SmsNotificationService smsNotificationService() {
        return new SmsNotificationService("SKT");
    }

    @Bean
    public NotificationManager notificationManager() {
        return new NotificationManager(emailNotificationService(), smsNotificationService());
    }
}
