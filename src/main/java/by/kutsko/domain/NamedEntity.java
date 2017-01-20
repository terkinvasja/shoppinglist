package by.kutsko.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * Created by Vasili on 020 20.01.17.
 */
@MappedSuperclass
public class NamedEntity extends BaseEntity {

    @Column(name = "name", nullable = false)
    @NotEmpty
    protected String name;

    public NamedEntity() {
    }

    public NamedEntity(Integer id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
