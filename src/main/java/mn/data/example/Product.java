package mn.data.example;

import edu.umd.cs.findbugs.annotations.Nullable;
import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;

@MappedEntity
public class Product {
    @GeneratedValue
    @Id
    private Long id;

    private final Owner owner;
    private final String name;

    public Product(@Nullable Owner owner, String name) {
        this.owner = owner;
        this.name = name;
    }

    public Owner getOwner() {
        return owner;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
