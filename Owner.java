import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Owner extends User implements Reservable, Payable, Mappable {
    private List<ServiceReservation> reservations;
    private Map<String, Double> fees;
    private List<String> notifications;

    public Owner(String id, String username, String password) {
        super(id, username, password);
        this.reservations = new ArrayList<>();
        this.fees = new HashMap<>();
        this.notifications = new ArrayList<>();
    }

    @Override
    public void login() {
        System.out.println("业主登录");
        // Add login logic here
    }

    @Override
    public void reserveService(String serviceType, String timeSlot) {
        // Example of input validation
        if (serviceType == null || timeSlot == null) {
            System.out.println("服务类型或时间段不能为空");
            return;
        }
        System.out.println("预定服务: " + serviceType + " 时间段: " + timeSlot);
        reservations.add(new ServiceReservation(serviceType, timeSlot, this.getId()));
    }

    @Override
    public void cancelService(String serviceType, String timeSlot) {
        // Implement cancel logic here, considering matching serviceType and timeSlot
        System.out.println("取消服务: " + serviceType + " 时间段: " + timeSlot);
        // Example: reservations.removeIf(r -> r.getServiceType().equals(serviceType) &&
        // r.getTimeSlot().equals(timeSlot));
    }

    @Override
    public void submitFee(String feeType, double amount) {
        // Input validation example
        if (amount <= 0) {
            System.out.println("提交的费用必须大于0");
            return;
        }
        System.out.println("提交费用: " + feeType + " 金额: " + amount);
        fees.put(feeType, fees.getOrDefault(feeType, 0.0) + amount);
    }

    @Override
    public void viewPaymentHistory() {
        System.out.println("查看支付历史");
        // Logic to retrieve and display the payment history
    }

    @Override
    public void generatePaymentReminder(String feeType) {
        System.out.println("生成支付提醒: " + feeType);
        // Logic to generate and send a payment reminder for the specified fee type
    }

    @Override
    public void useMap() {
        System.out.println("业主使用地图");
        // Implement map usage logic here
    }

    public void viewFeeHistory() {
        System.out.println("查看费用历史");
        fees.forEach((feeType, amount) -> System.out.println(feeType + ": " + amount));
    }

    public void viewReservationHistory() {
        System.out.println("查看服务预定历史");
        reservations.forEach(reservation -> System.out.println(reservation));
    }

    @Override
    public void viewNotifications() {
        System.out.println("业主查看通知");
        notifications.forEach(System.out::println);
    }

    public void receiveNotification(String message) {
        if (message == null || message.isEmpty()) {
            System.out.println("通知内容不能为空");
            return;
        }
        notifications.add(message);
    }

    @Override
    public void getDirections(String destination) {
        // 示例实现，实际应用中应根据需要进行完善
        System.out.println("显示前往" + destination + "的路线。");
    }

    @Override
    public void findNearbyServices(String serviceType) {
        // 示例实现，实际应用中应根据需要进行完善
        System.out.println("查找附近的" + serviceType + "服务。");
    }

    @Override
    public boolean updateReservation(String reservationId, String newTimeSlot) {
        for (ServiceReservation reservation : reservations) {
            if (reservation.getReservationId().equals(reservationId)) {
                reservation.setTimeSlot(newTimeSlot);
                System.out.println("Reservation updated: " + reservationId);
                return true;
            }
        }
        System.out.println("Reservation not found: " + reservationId);
        return false;
    }

    @Override
    public ServiceReservationStatus getReservationStatus(String reservationId) {
        for (ServiceReservation reservation : reservations) {
            if (reservation.getReservationId().equals(reservationId)) {
                return reservation.getStatus();
            }
        }
        System.out.println("未找到预约: " + reservationId);
        return ServiceReservationStatus.NOT_FOUND; // 假设ServiceReservationStatus是一个枚举
    }

    @Override
    public List<ServiceReservation> getCurrentReservations(String userId) {
        // 返回属于该用户的所有预约
        List<ServiceReservation> userReservations = new ArrayList<>();
        for (ServiceReservation reservation : reservations) {
            if (reservation.getOwnerId().equals(userId) && reservation.isActive()) {
                userReservations.add(reservation);
            }
        }
        return userReservations;
    }

    // 方法来提交开锁服务请求
    public void requestLocksmithService(String building, String apartment) {
        // 构造服务请求
        ServiceRequest request = new ServiceRequest(this.getId(), "Locksmith", building, apartment);
        // 发送请求到服务管理系统（假设ServiceRequestManager是处理所有服务请求的类）
        ServiceRequestManager.submitRequest(request);
        System.out.println("Submitted locksmith service request for " + building + " " + apartment);
    }

    // 方法来提交家电维修服务请求
    public void requestApplianceRepairService(String applianceType, String building, String apartment) {
        // 构造服务请求
        ServiceRequest request = new ServiceRequest(this.getId(), "ApplianceRepair", applianceType, building,
                apartment);
        // 发送请求到服务管理系统
        ServiceRequestManager.submitRequest(request);
        System.out.println("Submitted appliance repair service request for " + applianceType + " in " + building + " "
                + apartment);
    }
    // Additional methods like participateInDiscussion could be added here, ensuring
    // input validation and appropriate logic.
}
