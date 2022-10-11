package africa.semicolon.lumexpress.services.notification;

import javax.mail.MessagingException;

public interface EmailSender {
    String sendHtmlMail(EmailNotificationRequest emailDetails) throws MessagingException;
}
