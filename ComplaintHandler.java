import java.util.Map;
import java.util.HashMap;

public class ComplaintHandler {
    private final Map<String, Complaint> complaints = new HashMap<>();

    public void fileComplaint(String complaintId, String content) {
        Complaint complaint = new Complaint(complaintId, content);
        complaints.put(complaintId, complaint);
        System.out.println("Complaint filed: " + content);
    }

    public void updateComplaintStatus(String complaintId, boolean isResolved) {
        Complaint complaint = complaints.get(complaintId);
        if (complaint != null) {
            complaint.setResolved(isResolved);
            String status = isResolved ? "resolved" : "pending";
            System.out.println("Complaint " + complaintId + " status updated to: " + status);
        } else {
            System.out.println("Complaint with ID " + complaintId + " not found.");
        }
    }

    // Method to accept a complaint
    public void acceptComplaint(String complaintId) {
        Complaint complaint = complaints.get(complaintId);
        if (complaint != null && !complaint.isAccepted()) {
            complaint.setAccepted(true);
            System.out.println("Complaint " + complaintId + " has been accepted.");
        } else if (complaint == null) {
            System.out.println("Complaint with ID " + complaintId + " not found.");
        } else {
            System.out.println("Complaint " + complaintId + " is already accepted.");
        }
    }

    // You might want to add more methods for handling complaints, like listing all
    // unresolved complaints, etc.
}
