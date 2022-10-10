package africa.semicolon.lumexpress.services.notification;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.mail.MessagingException;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class GmailEmailSenderImplTest {

    @Autowired
    private EmailSender emailSender;

    @Test
    void sendHtmlMailTest() throws MessagingException {
        EmailDetails emailDetails = EmailDetails.builder()
                .userEmail("augustineezekiel763@gmail.com")
                .mailContent("Hi whimp guys !!")
                .build();
        String response = emailSender.sendHtmlMail(emailDetails);
        assertThat(response.contains("successfully")).isTrue();

    }
}