package africa.semicolon.lumexpress.services.notification;

import africa.semicolon.lumexpress.data.dtos.request.EmailNotificationRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@AllArgsConstructor
@Service
@Slf4j
public class GmailNotificationServiceImpl implements EmailNotificationService {
    private final JavaMailSender javaMailSender;

    @Override
    public String sendHtmlMail(EmailNotificationRequest emailDetails) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
        try {
            mimeMessageHelper.setFrom("no-reply@email.lumExpress.com.ng");
            mimeMessageHelper.setTo(emailDetails.getUserEmail());
            mimeMessageHelper.setText(emailDetails.getMailContent(),true);
            javaMailSender.send(mimeMessage);
            log.info("::: {}");
            return String.format("email sent to %s successfully", emailDetails.getUserEmail());
        } catch (MessagingException err) {
            err.printStackTrace();
        }
        return String.format("email not sent to %s", emailDetails.getUserEmail());
    }
}
