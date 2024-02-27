public class Complaint {
    private String complaintId;
    private String content;
    private boolean isAccepted;
    private boolean isResolved;

    // Constructor
    public Complaint(String complaintId, String content) {
        this.complaintId = complaintId;
        this.content = content;
        this.isAccepted = false; // Initially, complaints are neither accepted nor resolved
        this.isResolved = false;
    }

    // Getters and Setters
    public String getComplaintId() {
        return complaintId;
    }

    public String getContent() {
        return content;
    }

    public boolean isAccepted() {
        return isAccepted;
    }

    public void setAccepted(boolean accepted) {
        isAccepted = accepted;
    }

    public boolean isResolved() {
        return isResolved;
    }

    public void setResolved(boolean resolved) {
        isResolved = resolved;
    }

    // Additional methods can be added for further functionality
}
