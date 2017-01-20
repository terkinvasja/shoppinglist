package by.kutsko.domain;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by Vasili on 020 20.01.17.
 */
@Entity
@Table(name = "users")
public class User extends NamedEntity {

    @Column(name = "email", nullable = false, unique = true)
    @Email
    @NotEmpty
    private String email;

    @Column(name = "password", nullable = false)
    @NotEmpty
    @Length(min = 5)
    private String password;

    @Column(name = "registered", columnDefinition = "timestamp default now()")
    private Date registered = new Date();

    public User() {
    }

    public User(User u) {
        this(u.getId(), u.getName(), u.getEmail(), u.getPassword());
    }

    public User(Integer id, String name, String email, String password) {
        super(id, name);
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getRegistered() {
        return registered;
    }

    public void setRegistered(Date registered) {
        this.registered = registered;
    }

    @Override
    public String toString() {
        return "User(" +
                "id=" + id +
                ", name=" + name +
                ", email=" + email +
                ", password=" + password +
                ", registered=" + registered +
                ')';
    }
}
