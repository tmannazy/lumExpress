package africa.semicolon.lumexpress.services.notification;

import javax.mail.MessagingException;

public interface EmailSender {
    String sendHtmlMail(EmailDetails emailDetails) throws MessagingException;
}
