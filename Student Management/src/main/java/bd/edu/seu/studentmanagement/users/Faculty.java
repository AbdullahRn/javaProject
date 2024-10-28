package bd.edu.seu.studentmanagement.users;


public class Faculty {
    private String name;
    private String initial;
    private String password;
    private int credits;
    private String semester;
    private String image;

    public Faculty(String name, String initial, String password, int credits, String semester, String image) {
        this.name = name;
        this.initial = initial;
        this.password = password;
        this.credits = credits;
        this.semester = semester;
        this.image = image;
    }

    public Faculty() {
    }

    public String getName() {
        return name;
    }

    public String getInitial() {
        return initial;
    }

    public String getPassword() {
        return password;
    }

    public int getCredits() {
        return credits;
    }

    public String getSemester() {
        return semester;
    }

    public String getImage() {
        return image;
    }
}
