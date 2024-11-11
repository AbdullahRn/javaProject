package bd.edu.seu.studentmanagement.otherClasses;

public class Log {
    private String adminName;
    private String task;
    private String time;

    public Log(String adminName, String task, String time) {
        this.adminName = adminName;
        this.task = task;
        this.time = time;
    }

    public String getAdminName() {
        return adminName;
    }

    public String getTask() {
        return task;
    }

    public String getTime() {
        return time;
    }
}
