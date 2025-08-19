package mylab.notification.service.impl;

import mylab.notification.service.NotificationService;

public class SmsNotificationService implements NotificationService {

    private final String provider;

    public SmsNotificationService(String provider) {
        this.provider = provider;
    }

    public String getProvider() { return provider; }

    @Override
    public void sendNotification(String message) {
        System.out.println("[SMS] via " + provider + " - " + message);
    }
}
