package bd.edu.seu.studentmanagement.dependentOnSemester;

public class StudentSemesterInfo {
    private String id;
    private String semester;
    private Double gpa;
    private Double payment;
    private int totalCredits;
    private Double sumOfGrades;

    public StudentSemesterInfo(String id, String semester, Double gpa, Double payment, int totalCredits, Double sumOfGrades) {
        this.id = id;
        this.semester = semester;
        this.gpa = gpa;
        this.payment = payment;
        this.totalCredits = totalCredits;
        this.sumOfGrades = sumOfGrades;
    }

    public Double getGpa() {
        return gpa;
    }

    public Double getPayment() {
        return payment;
    }

    public int getTotalCredits() {
        return totalCredits;
    }

    public Double getSumOfGrades() {
        return sumOfGrades;
    }

    public String getId() {
        return id;
    }

    public String getSemester() {
        return semester;
    }

}
