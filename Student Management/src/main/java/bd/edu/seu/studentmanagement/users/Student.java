package bd.edu.seu.studentmanagement.users;

public class Student {
    private String name;
    private String id;
    private String password;
    private Double hscGpa;
    private Double waiver;
    private Double cgpa;
    private String imageURL;


    public Student(String name, String id, String password) {
        this.name = name;
        this.id = id;
        this.password = password;
    }

    public Student() {
    }

    public Student(String name, String id, String password, Double hscGpa, Double waiver, Double cgpa, String imageURL) {
        this.name = name;
        this.id = id;
        this.password = password;
        this.hscGpa = hscGpa;
        this.waiver = waiver;
        this.cgpa = cgpa;
        this.imageURL = imageURL;
    }


    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public Double getHscGpa() {
        return hscGpa;
    }

    public String getImageURL() {
        return imageURL;
    }

    public Double getWaiver() {
        return waiver;
    }

    public Double getCgpa() {
        return cgpa;
    }
}
