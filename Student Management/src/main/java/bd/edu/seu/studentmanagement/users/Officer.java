package bd.edu.seu.studentmanagement.users;

public class Officer {
    private String name;
    private String id;
    private String password;
    private String image;
    private String reference;


    public Officer(String name, String id, String password, String image, String reference) {
        this.name = name;
        this.id = id;
        this.password = password;
        this.image = image;
        this.reference = reference;
    }

    public String getReference() {
        return reference;
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

    public String getImage() {
        return image;
    }
}
