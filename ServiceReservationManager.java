import java.util.HashMap;
import java.util.Map;

public class ServiceReservationManager {
    private Map<String, ServiceReservation> reservations;

    public ServiceReservationManager() {
        this.reservations = new HashMap<>();
    }

    public void checkAvailability(String serviceType, String timeSlot) {
        // Simulate checking availability
        boolean isAvailable = true; // Placeholder for actual availability logic
        if (isAvailable) {
            SystemLog.getInstance().info(serviceType + " at " + timeSlot + " is available.");
        } else {
            SystemLog.getInstance().info(serviceType + " at " + timeSlot + " is not available.");
        }
    }

    public boolean addReservation(ServiceReservation reservation) {
        if (reservations.containsKey(reservation.getReservationId())) {
            SystemLog.getInstance().info("Reservation " + reservation.getReservationId() + " already exists.");
            return false;
        } else {
            reservations.put(reservation.getReservationId(), reservation);
            SystemLog.getInstance().info("Added reservation: " + reservation.getReservationId());
            return true;
        }
    }

    public boolean cancelReservation(String reservationId) {
        if (reservations.containsKey(reservationId)) {
            reservations.remove(reservationId);
            SystemLog.getInstance().info("Cancelled reservation: " + reservationId);
            return true;
        } else {
            SystemLog.getInstance().info("Reservation " + reservationId + " does not exist.");
            return false;
        }
    }

    public void confirmReservation(String reservationId) {
        ServiceReservation reservation = reservations.get(reservationId);
        if (reservation != null) {
            // Placeholder for confirmation logic
            SystemLog.getInstance().info("Confirmed reservation: " + reservationId);
        } else {
            SystemLog.getInstance().info("Reservation " + reservationId + " does not exist.");
        }
    }
}
