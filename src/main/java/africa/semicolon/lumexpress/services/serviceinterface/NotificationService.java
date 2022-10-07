package africa.semicolon.lumexpress.services.serviceinterface;

import africa.semicolon.lumexpress.data.dtos.request.NotificationRequest;

public interface NotificationService {
     String send(NotificationRequest notificationRequest);
}
