package id.my.hendisantika.digitaloceanspace.controller;

import id.my.hendisantika.digitaloceanspace.model.Image;
import id.my.hendisantika.digitaloceanspace.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;

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

    @PostMapping(value = "/new",
            consumes = MULTIPART_FORM_DATA_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Image> uploadFile(@RequestParam("file") final MultipartFile file) throws IOException {
        var response = imageService.saveFile(file);
        return ResponseEntity.ok(response);

    }
}
