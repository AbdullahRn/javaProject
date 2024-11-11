package bd.edu.seu.studentmanagement.otherClasses;

public class Marks {
    private String id;
    private double quiz;
    private double attendance;
    private double mid;
    private double assignment;
    private double finale;
    private String semester;

    public Marks(String id, double quiz, double attendance, double mid, double assignment, double finale, String semester) {
        this.id = id;
        this.quiz = quiz;
        this.attendance = attendance;
        this.mid = mid;
        this.assignment = assignment;
        this.finale = finale;
        this.semester = semester;
    }

    public String getId() {
        return id;
    }

    public double getQuiz() {
        return quiz;
    }

    public double getAttendance() {
        return attendance;
    }

    public double getMid() {
        return mid;
    }

    public double getAssignment() {
        return assignment;
    }

    public double getFinale() {
        return finale;
    }

    public String getSemester() {
        return semester;
    }
}
