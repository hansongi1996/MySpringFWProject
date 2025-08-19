package mylab.notification.core;

import mylab.notification.service.impl.EmailNotificationService;
import mylab.notification.service.impl.SmsNotificationService;

public class NotificationManager {

    private final EmailNotificationService emailService;
    private final SmsNotificationService smsService;

    public NotificationManager(EmailNotificationService emailService,
                               SmsNotificationService smsService) {
        this.emailService = emailService;
        this.smsService = smsService;
    }

    public EmailNotificationService getEmailService() { return emailService; }
    public SmsNotificationService getSmsService() { return smsService; }

    public void sendNotificationByEmail(String message) {
        emailService.sendNotification(message);
    }

    public void sendNotificationBySms(String message) {
        smsService.sendNotification(message);
    }
}
