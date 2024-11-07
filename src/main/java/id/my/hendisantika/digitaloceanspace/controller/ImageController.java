package id.my.hendisantika.digitaloceanspace.controller;

import id.my.hendisantika.digitaloceanspace.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-digital-ocean-space
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 07/11/24
 * Time: 08.07
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/upload")
public class ImageController {
    private final ImageService imageService;
}
