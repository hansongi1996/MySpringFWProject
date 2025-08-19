package mylab.notification.service.impl;

import mylab.notification.service.NotificationService;

public class EmailNotificationService implements NotificationService {

    private final String smtpServer;
    private final int port;

    public EmailNotificationService(String smtpServer, int port) {
        this.smtpServer = smtpServer;
        this.port = port;
    }

    public String getSmtpServer() { return smtpServer; }
    public int getPort() { return port; }

    @Override
    public void sendNotification(String message) {
        System.out.println("[EMAIL] to SMTP " + smtpServer + ":" + port + " - " + message);
    }
}
