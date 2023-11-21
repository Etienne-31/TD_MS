package Models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table("User")
public class User {

    private String name;

    private String role;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public User(String name, String role) {
        this.name = name;
        this.role = role;
    }

    @Id
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    @Id
    @Column(name = "role")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

