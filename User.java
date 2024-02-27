public abstract class User {
    protected String id;
    protected String username;
    protected String password; // Consider using secure storage for passwords

    public User(String id, String username, String password) {
        this.id = id;
        this.username = username;
        // TODO: Encrypt password before storing
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return this.username;
    }

    // Ensure all users can login but the details might vary
    public abstract void login();

    // Method to change password with basic validation
    public boolean changePassword(String oldPassword, String newPassword) {
        if (!this.password.equals(oldPassword)) {
            System.out.println("旧密码不正确");
            return false;
        }
        if (newPassword == null || newPassword.isEmpty()) {
            System.out.println("新密码不可为空");
            return false;
        }
        // TODO: Encrypt newPassword before storing
        this.password = newPassword;
        System.out.println("密码修改成功");
        return true;
    }

    // Define a method to view notifications; specifics will be implemented in
    // subclasses
    public abstract void viewNotifications();
}
