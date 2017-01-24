package by.kutsko.domain;

/**
 * Created by Vasili on 023 23.01.17.
 */
public class Category extends NamedEntity {

    private short red;

    private short green;

    private short blue;

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
