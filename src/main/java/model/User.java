package model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;


    public User() {
    }

    public User(long id, String firstName) {
        this.id = id;
        this.firstName = firstName;
    }

    public User(String firstName, String password) {
        this.firstName = firstName;
        this.password = password;
    }
    public User(long id, String firstName, String password) {
        this.id = id;
        this.firstName = firstName;
        this.password = password;
    }

    public User(String firstName, String password, String role) {
        this.firstName = firstName;
        this.password = password;
        this.role = role;
    }

    public User(long id, String firstName, String password, String role) {
        this.id = id;
        this.firstName = firstName;
        this.password = password;
        this.role = role;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Имя = " + firstName + "; " + " Пароль =" + password;
    }
}
