package africa.semicolon.lumexpress.services.notification;

import africa.semicolon.lumexpress.data.dtos.request.EmailNotificationRequest;

import javax.mail.MessagingException;

public interface EmailNotificationService {
    String sendHtmlMail(EmailNotificationRequest emailDetails) throws MessagingException;
}
