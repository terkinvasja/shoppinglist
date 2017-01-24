package by.kutsko.domain;

import java.util.Date;

/**
 * Created by Vasili on 023 23.01.17.
 */
public class Product extends NamedEntity {

    private Date created = new Date();

    private Integer quantity;

    private Dimension dimension;

    private Integer price;

    private String description;

    private Category category;

    private User user;

    public Product() {
    }

    public Product(Integer id, String name, Integer quantity, Dimension dimension, Integer price, String description, Category category, User user) {
        super(id, name);
        this.quantity = quantity;
        this.dimension = dimension;
        this.price = price;
        this.description = description;
        this.category = category;
        this.user = user;
    }

    public Product(Integer id, String name, Integer quantity, Dimension dimension, Category category, User user) {
        super(id, name);
        this.quantity = quantity;
        this.dimension = dimension;
        this.price = null;
        this.description = null;
        this.category = category;
        this.user = user;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Dimension getDimension() {
        return dimension;
    }

    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name=" + name +
                ", created=" + created +
                ", quantity=" + quantity +
                ", dimension=" + dimension +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", category=" + category +
                ", user=" + user +
                '}';
    }
}
