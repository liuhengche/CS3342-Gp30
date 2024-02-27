import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Admin extends User implements Notifiable, Mappable {

    private ComplaintHandler complaintHandler;
    private ServiceReservationManager serviceReservationManager;
    private HashMap<String, List<String>> userNotifications;

    public Admin(String id, String username, String password, ComplaintHandler complaintHandler,
            ServiceReservationManager serviceReservationManager) {
        super(id, username, password);
        this.complaintHandler = complaintHandler;
        this.serviceReservationManager = serviceReservationManager;
        this.userNotifications = new HashMap<>();
    }

    @Override
    public void login() {
        // 使用SystemLog记录管理员登录信息
        SystemLog.getInstance().info("管理员登录: " + getUsername());
    }

    @Override
    public void sendNotification(String userId, String message) {
        List<String> notifications = userNotifications.getOrDefault(userId, new ArrayList<>());
        notifications.add(message);
        userNotifications.put(userId, notifications);
        // 使用SystemLog记录发送通知操作
        SystemLog.getInstance().info("Notification sent to user ID " + userId + ": " + message);
    }

    public void viewAllNotifications() {
        // 修改方法名，避免与重载方法冲突
        SystemLog.getInstance().info("管理员查看所有用户通知");
        userNotifications.forEach((userId, notifications) -> {
            if (notifications.isEmpty()) {
                SystemLog.getInstance().info("No notifications for user ID " + userId);
            } else {
                SystemLog.getInstance().info("Notifications for user ID " + userId + ": " + notifications);
            }
        });
    }

    @Override
    public void viewNotifications(String userId) {
        List<String> notifications = userNotifications.getOrDefault(userId, new ArrayList<>());
        if (notifications.isEmpty()) {
            SystemLog.getInstance().info("No notifications for user ID " + userId);
        } else {
            SystemLog.getInstance().info("Notifications for user ID " + userId + ":");
            notifications.forEach(SystemLog.getInstance()::info);
        }
    }

    @Override
    public void viewNotifications() {
        // 无参数版本的通知查看方法
        SystemLog.getInstance().info("管理员查看所有通知");
        // 实现可以是遍历所有用户的通知并打印，或者是其他逻辑
    }

    @Override
    public void useMap() {
        // 使用SystemLog记录管理员使用地图操作
        SystemLog.getInstance().info("管理员使用地图");
    }

    @Override
    public void getDirections(String destination) {
        // 示例实现
        SystemLog.getInstance().info("获取前往 " + destination + " 的路线");
    }

    @Override
    public void findNearbyServices(String serviceType) {
        // 示例实现
        SystemLog.getInstance().info("查找附近的服务: " + serviceType);
    }

    public void manageServiceReservation(String reservationId, boolean approve) {
        try {
            if (approve) {
                serviceReservationManager.confirmReservation(reservationId);
                SystemLog.getInstance().info("服务预定审核通过: " + reservationId);
            } else {
                SystemLog.getInstance().info("服务预定审核拒绝: " + reservationId);
                // Additional logic for handling rejection
            }
        } catch (Exception e) {
            SystemLog.getInstance().error("管理服务预定时发生错误: " + e.getMessage());
        }
    }

    public void manageComplaint(String complaintId, boolean isResolved) {
        try {
            complaintHandler.updateComplaintStatus(complaintId, isResolved);
            SystemLog.getInstance().info(isResolved ? "投诉已解决: " + complaintId : "继续处理投诉: " + complaintId);
        } catch (Exception e) {
            SystemLog.getInstance().error("管理投诉时发生错误: " + e.getMessage());
        }
    }

    public void sendMassNotification(String message) {
        userNotifications.keySet().forEach(userId -> sendNotification(userId, message));
        SystemLog.getInstance().info("已发送群体通知: " + message);
    }

    // 方法来处理开锁服务请求
    public void handleLocksmithServiceRequest(ServiceRequest request) {
        // 处理请求，如分配师傅等
        System.out.println(
                "Handling locksmith service request for " + request.getBuilding() + " " + request.getApartment());
        // 此处添加逻辑来派发开锁师傅
    }

    // 方法来处理家电维修服务请求
    public void handleApplianceRepairServiceRequest(ServiceRequest request) {
        // 处理请求
        System.out.println("Handling appliance repair service request for " + request.getApplianceType() + " in "
                + request.getBuilding() + " " + request.getApartment());
        // 此处添加逻辑来派发家电维修师傅
    }

    // 其他方法根据需要添加错误处理和日志记录
}
