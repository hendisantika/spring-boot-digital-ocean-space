package id.my.hendisantika.digitaloceanspace.repository;

import id.my.hendisantika.digitaloceanspace.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-digital-ocean-space
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 07/11/24
 * Time: 08.04
 * To change this template use File | Settings | File Templates.
 */
public interface ImageRepository extends JpaRepository<Image, Long> {

    Optional<Image> findImageByName(String imageName);
}
