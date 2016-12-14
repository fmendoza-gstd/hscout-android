package objects;

/**
 * Created by Gabriel on 08/12/2016.
 */
public class User {
    private String name;
    private String lastName;
    private String imgProfile;

    public User(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public User() {    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
