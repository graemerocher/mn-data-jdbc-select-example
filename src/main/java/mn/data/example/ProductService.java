package mn.data.example;

import javax.inject.Singleton;
import javax.transaction.Transactional;
import java.util.List;

@Singleton
public class ProductService {
    private final OwnerRepository ownerRepository;
    private final ProductRepository productRepository;

    public ProductService(OwnerRepository ownerRepository, ProductRepository productRepository) {
        this.ownerRepository = ownerRepository;
        this.productRepository = productRepository;
    }

    @Transactional
    List<Owner> getOwnersAndProducts(String country) {
        List<Owner> owners = ownerRepository.findByCountry(country);
        for (Owner owner : owners) {
            List<Product> products = productRepository.findByOwner(owner);
            owner.getProducts().addAll(products);
        }
        return owners;
    }
}
