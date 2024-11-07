package id.my.hendisantika.digitaloceanspace;

import id.my.hendisantika.digitaloceanspace.repository.ImageRepository;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@Testcontainers
@SpringBootTest(
        properties = {
                "management.endpoint.health.show-details=always",
                "spring.datasource.url=jdbc:tc:postgresql:17-alpine3.20:///imageDB"
        },
        webEnvironment = RANDOM_PORT
)
class SpringBootDigitalOceanSpaceApplicationTests {

    @Autowired
    private ImageRepository imageRepository;

    @BeforeEach
    void deleteAll() {
        imageRepository.deleteAll();
    }

}
