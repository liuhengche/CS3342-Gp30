public class ServiceRequest {
    private String ownerId;
    private String serviceType;
    private String applianceType; // 仅对家电维修服务适用
    private String building;
    private String apartment;

    // 完整的构造方法
    public ServiceRequest(String ownerId, String serviceType, String building, String apartment, String applianceType) {
        this.ownerId = ownerId;
        this.serviceType = serviceType;
        this.building = building;
        this.apartment = apartment;
        this.applianceType = applianceType; // 这里允许为null
    }

    public ServiceRequest(String id, String string, String building2, String apartment2) {
        //TODO Auto-generated constructor stub
    }

    // Getter方法
    public String getOwnerId() {
        return ownerId;
    }

    public String getServiceType() {
        return serviceType;
    }

    public String getApplianceType() {
        return applianceType;
    }

    public String getBuilding() {
        return building;
    }

    public String getApartment() {
        return apartment;
    }
}
