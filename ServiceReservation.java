public class ServiceReservation {
    private String serviceType;
    private String timeSlot;
    private String ownerId;
    private boolean isActive;
    private String reservationId; // 假设添加

    // Constructor
    public ServiceReservation(String serviceType, String timeSlot, String ownerId) {
        this.serviceType = serviceType;
        this.timeSlot = timeSlot;
        this.ownerId = ownerId;
        this.isActive = true; // Initially, all reservations are active
    }

    // Getters and Setters
    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public boolean isActive() {
        return isActive;
    }

    public String getReservationId() {
        return reservationId;
    }

    // Method to cancel the reservation, marking it as inactive
    public void cancelReservation() {
        this.isActive = false;
        System.out.println("Reservation for " + serviceType + " at " + timeSlot + " has been canceled.");
    }

    @Override
    public String toString() {
        return "ServiceReservation{" +
                "serviceType='" + serviceType + '\'' +
                ", timeSlot='" + timeSlot + '\'' +
                ", ownerId='" + ownerId + '\'' +
                ", isActive=" + isActive +
                '}';
    }

    public ServiceReservationStatus getStatus() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getStatus'");
    }
}
