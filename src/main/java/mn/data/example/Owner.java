package mn.data.example;

import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.Transient;

import java.util.HashSet;
import java.util.Set;

@MappedEntity
public class Owner {
    @GeneratedValue
    @Id
    private Long id;

    private final String name;
    private final String country;
    private final Set<Product> products = new HashSet<>();

    public Owner(String name, String country) {
        this.name = name;
        this.country = country;
    }

    @Transient
    public Set<Product> getProducts() {
        return products;
    }

    public String getCountry() {
        return country;
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
