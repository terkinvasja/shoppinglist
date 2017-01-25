package by.kutsko.domain;

import javax.persistence.*;

/**
 * Created by Vasili on 023 23.01.17.
 */
@Entity
@Table(name = "user_category")
public class Category extends NamedEntity {

    @Column(name = "red")
    private short red;

    @Column(name = "green")
    private short green;

    @Column(name = "blue")
    private short blue;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Category() {
    }


    public Category(Integer id, String name, short red, short green, short blue, User user) {
        super(id, name);
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.user = user;
    }

    public Category(Integer id, String name, User user) {
        super(id, name);
        this.user = user;
        // gray color default
        this.red = 128;
        this.blue = 128;
        this.blue = 128;
    }
}
