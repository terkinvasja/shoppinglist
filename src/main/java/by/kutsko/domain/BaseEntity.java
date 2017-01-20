package by.kutsko.domain;

import javax.persistence.*;

/**
 * Created by Vasili on 020 20.01.17.
 */
@MappedSuperclass
public class BaseEntity {
    public static final int START_SEQ = 100000;

    @Id
    @SequenceGenerator(name = "global_seq", sequenceName = "global_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_seq")
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
