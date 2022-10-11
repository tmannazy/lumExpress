package africa.semicolon.lumexpress.services.notification;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmailNotificationRequest {
    private String userEmail;
    private String mailContent;
}
