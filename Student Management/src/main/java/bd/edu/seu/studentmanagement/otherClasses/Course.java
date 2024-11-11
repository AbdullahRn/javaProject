package bd.edu.seu.studentmanagement.otherClasses;

public class Course {
    private String code;
    private final int credit =3;
    private int slot=0;
    private String name;
    private String faculty;
    private int totalStudent=0;
    private String semester;
    private int totalSeat=0;

    public Course(String code, int slot, String name, String faculty, int totalStudent, String semester) {
        this.code = code;
        this.slot = slot;
        this.name = name;
        this.faculty = faculty;
        this.totalStudent = totalStudent;
        this.semester = semester;
    }

    public Course() {
    }

    public Course(String code, int slot, String name, String faculty, int totalStudent, String semester, int totalSeat) {
        this.code = code;
        this.slot = slot;
        this.name = name;
        this.faculty = faculty;
        this.totalStudent = totalStudent;
        this.semester = semester;
        this.totalSeat = totalSeat;
    }

    public int getTotalSeat() {
        return totalSeat;
    }

    public Course(String name, int slot, String code) {
        this.code = code;
        this.slot = slot;
        this.name = name;
    }

    public Course(String name, String code, int totalSeat) {
        this.name = name;
        this.code = code;
        this.totalSeat = totalSeat;
    }

    public Course(String code, String faculty, int slot ,int differentiate) {
        this.code = code;
        this.faculty = faculty;
        this.slot = slot;
        differentiate = differentiate;
    }




    public Course(String name, int slot, String code, String faculty) {
        this.code = code;
        this.slot = slot;
        this.name = name;
        this.faculty = faculty;
    }



    public Course(String code, int slot, String name, String faculty, int totalStudent) {
        this.code = code;
        this.slot = slot;
        this.name = name;
        this.faculty = faculty;
        this.totalStudent = totalStudent;
    }

    public Course(String code, int slot) {
        this.code = code;
        this.slot = slot;
    }

    //    public Course(String code, int slot, String faculty) {
//        this.faculty = faculty;
//        this.code = code;
//        this.slot = slot;
//    }

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

    public String getSemester() {
        return semester;
    }

    public int getTotalStudent() {
        return totalStudent;
    }
}
