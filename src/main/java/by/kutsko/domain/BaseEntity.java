package by.kutsko.domain;

/**
 * Created by Vasili on 020 20.01.17.
 */
public class BaseEntity {

    protected Integer id;

    public BaseEntity() {
    }

    public BaseEntity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isNew() {
        return (getId() == null);
    }

    @Override
    public int hashCode() {
        return (getId() == null) ? 0 : getId();
    }
}
