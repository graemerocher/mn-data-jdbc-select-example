package mn.data.example;

import io.micronaut.context.event.StartupEvent;
import io.micronaut.runtime.Micronaut;
import io.micronaut.runtime.event.annotation.EventListener;

import javax.inject.Singleton;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Singleton
public class Application {

    private final OwnerRepository ownerRepository;
    private final ProductRepository productRepository;

    public Application(OwnerRepository ownerRepository, ProductRepository productRepository) {
        this.ownerRepository = ownerRepository;
        this.productRepository = productRepository;
    }

    public static void main(String[] args) {
        Micronaut.run(Application.class, args);
    }


    @Transactional
    @EventListener
    void init(StartupEvent event) {
        List<Owner> owners = new ArrayList<>(30);

        for (int i = 1; i <= 5; i++) {
            owners.addAll(
                    Arrays.asList(
                            new Owner("XXX " + i, "Japan"),
                            new Owner("YYY" + i, "Brazil"),
                            new Owner("ZZZ" + i, "USA")
                    )
            );
        }
        ownerRepository.saveAll(owners);

        List<Product> products = new ArrayList<>(30);
        for (Owner owner : owners) {
            for (int i = 1; i <= 10; i++) {
                 products.add(new Product(owner, "Product " + i));
            }
        }
        productRepository.saveAll(products);
    }
}
