package africa.semicolon.lumexpress.services.notification;

import africa.semicolon.lumexpress.data.dtos.request.EmailNotificationRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.mail.MessagingException;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class GmailNotificationServiceImplTest {

    @Autowired
    private EmailNotificationService emailSender;

    @Test
    void sendHtmlMailTest() throws MessagingException {
        EmailNotificationRequest emailDetails = EmailNotificationRequest.builder()
//                .userEmail("augustineezekiel763@gmail.com")
                .userEmail("dorcasabang@gmail.com")
                .userEmail("adewehabang@gmail.com")
                .mailContent("Hi whimp Adeweleh!!!")
                .build();
        String response = emailSender.sendHtmlMail(emailDetails);
        assertThat(response.contains("successfully")).isTrue();

    }
}