package bd.edu.seu.studentmanagement.dependentOnSemester;

public class StudentCourseInfo {
    private String name;
    private String id;
    private Double cgpa;
    private String courseCode;
    private String semester;
    private Double marks = 0.0;
    private Double grade=0.0;
    private String imageURL;

    public StudentCourseInfo(String name, String id, Double cgpa, String courseCode, String semester, Double marks, Double grade, String imageURL) {
        this.name = name;
        this.id = id;
        this.cgpa = cgpa;
        this.courseCode = courseCode;
        this.semester = semester;

        this.marks = marks;
        this.grade = grade;
        this.imageURL = imageURL;
    }

    public String getImageURL() {
        return imageURL;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public Double getCgpa() {
        return cgpa;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getSemester() {
        return semester;
    }

    public Double getMarks() {
        return marks;
    }

    public Double getGrade() {
        return grade;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCgpa(Double cgpa) {
        this.cgpa = cgpa;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public void setMarks(Double marks) {
        this.marks = marks;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
