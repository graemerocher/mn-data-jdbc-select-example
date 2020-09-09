package mn.data.example;

import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.util.List;

@MicronautTest
public class ProductServiceTest {
    @Inject ProductService productService;

    @Test
    void testGetOwnersAndProducts() {
        List<Owner> owners = productService.getOwnersAndProducts("Japan");

        Owner first = owners.iterator().next();

        Assertions.assertEquals(
                10,
                first.getProducts().size()
        );
    }
}
