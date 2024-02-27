
public class Visitor extends User implements Registrable, Mappable {
    public Visitor(String id, String username, String password) {
        super(id, username, password);
    }

    @Override
    public void login() {
        SystemLog.getInstance().info("访客登录: " + this.username); // Changed to use info level logging
    }

    @Override
    public void registerVisit(String time, String ownerId) {
        // Basic input validation
        if (time == null || time.isEmpty() || ownerId == null || ownerId.isEmpty()) {
            SystemLog.getInstance().warning("访客登记失败: 输入无效"); // Use warning level for potential issues
        } else {
            SystemLog.getInstance().info("访客登记: 时间 " + time + ", 访问业主ID: " + ownerId); // Info level for standard
                                                                                       // operations
        }
    }

    @Override
    public void listPendingVisits() {
        // Implementation to list pending visits
        SystemLog.getInstance().info("列出待审批的访问请求");
        // This method could fetch and display pending visit registrations.
        // For simplicity, we're just logging an action here.
    }

    @Override
    public void approveVisit(String visitorId, boolean isApproved) {
        // Implementation to approve or reject a visit
        if (isApproved) {
            SystemLog.getInstance().info("访问请求已批准: " + visitorId);
        } else {
            SystemLog.getInstance().info("访问请求已拒绝: " + visitorId);
        }
    }

    @Override
    public void cancelVisit(String visitorId) {
        // Implementation to cancel a visit
        SystemLog.getInstance().info("取消访问: " + visitorId);
    }

    @Override
    public void useMap() {
        SystemLog.getInstance().info("访客使用地图");
    }

    public void viewVisitStatus() {
        SystemLog.getInstance().info("查看访问状态");
    }

    @Override
    public void viewNotifications() {
        SystemLog.getInstance().info("访客查看通知");
    }

    @Override
    public void getDirections(String destination) {
        // 示例实现，你可以根据实际情况调整这个方法
        SystemLog.getInstance().info("获取到 " + destination + " 的方向。");
        // 实际应用中，这里可以是调用某个地图服务API来获取方向
    }

    @Override
    public void findNearbyServices(String serviceType) {
        // 示例实现，你可以根据实际情况调整这个方法
        SystemLog.getInstance().info("寻找附近的 " + serviceType + " 服务。");
        // 实际应用中，这里可以是调用某个服务查找API来寻找附近的服务，例如餐厅、加油站等
    }

}
