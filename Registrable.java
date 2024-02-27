import java.util.List;

public interface Registrable {
    // Register a visit. Includes time of visit and ownerId for the visitor's
    // target.
    void registerVisit(String time, String ownerId);

    // Approve or reject a visitor's registration request.
    void approveVisit(String visitorId, boolean isApproved);

    // List pending visit registrations for review by an admin or the targeted
    // owner.
    void listPendingVisits();

    // Cancel a previously registered visit.
    void cancelVisit(String visitorId);
}

interface Reservable {
    void reserveService(String serviceType, String timeSlot);

    void cancelService(String serviceType, String timeSlot);

    List<ServiceReservation> getCurrentReservations(String userId);

    ServiceReservationStatus getReservationStatus(String reservationId);

    boolean updateReservation(String reservationId, String newTimeSlot);
}

interface Payable {
    void submitFee(String feeType, double amount);

    void viewPaymentHistory();

    void generatePaymentReminder(String feeType);
}

interface Notifiable {
    void sendNotification(String userId, String message);

    void viewNotifications(String userId);
}

interface Mappable {
    void useMap();
    void getDirections(String destination);
    void findNearbyServices(String serviceType);
}
