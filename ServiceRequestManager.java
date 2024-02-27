import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class ServiceRequestManager {
    private static List<ServiceRequest> requests = new ArrayList<>();

    // 提交服务请求
    public static void submitRequest(ServiceRequest request) {
        requests.add(request);
        // 这里可以添加逻辑来通知管理员有新的服务请求
        SystemLog.getInstance().info("New service request submitted: " + request.getServiceType());
    }

    // 获取所有服务请求
    public static List<ServiceRequest> getAllRequests() {
        return new ArrayList<>(requests);
    }

    // 根据服务类型获取服务请求
    public static List<ServiceRequest> getRequestsByType(String serviceType) {
        return requests.stream()
                .filter(request -> request.getServiceType().equals(serviceType))
                .collect(Collectors.toList());
    }

    // 示例方法：通知管理员处理新的服务请求
    public static void notifyAdminForNewRequest() {
        // 假设有一个方法来获取管理员对象
        Admin admin = getAdmin(); // 这个方法需要你根据实际情况来实现
        List<ServiceRequest> newRequests = getRequestsByType("Locksmith"); // 示例：获取所有开锁服务请求
        for (ServiceRequest request : newRequests) {
            admin.handleLocksmithServiceRequest(request);
        }
    }

    // 请根据实际情况实现此方法
    private static Admin getAdmin() {
        // 返回管理员对象的实例
        return new Admin(/* 参数根据实际情况 */);
    }
}
