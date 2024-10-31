package bd.edu.seu.studentmanagement.otherClasses;

public class Course {
    private String code;
    private final int credit =3;
    private int slot;
    private String name;
    private String faculty;


    public Course(String code, int slot, String name) {
        this.code = code;
        this.slot = slot;
        this.name = name;
    }



    public String getCode() {
        return code;
    }

    public int getCredit() {
        return credit;
    }

    public int getSlot() {
        return slot;
    }

    public String getName() {
        return name;
    }

    public String getFaculty() {
        return faculty;
    }
}
