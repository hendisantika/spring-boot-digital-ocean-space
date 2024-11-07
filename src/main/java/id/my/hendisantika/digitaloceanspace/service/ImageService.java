package id.my.hendisantika.digitaloceanspace.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import id.my.hendisantika.digitaloceanspace.model.Image;
import id.my.hendisantika.digitaloceanspace.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-digital-ocean-space
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 07/11/24
 * Time: 08.05
 * To change this template use File | Settings | File Templates.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ImageService {
    private static final String FOLDER = "develop/testing/images/";

    private final ImageRepository imageRepository;

    private final AmazonS3 s3Client;

    @Value("${do.spaces.bucket}")
    private String doSpaceBucket;

    @Value("${do.spaces.endpoint}")
    private String doSpaceEndpointForData;

    public Image saveFile(MultipartFile file) throws IOException {
        var extension = FilenameUtils.getExtension(file.getOriginalFilename());
        var imgName = FilenameUtils.removeExtension(file.getOriginalFilename());
        var key = FOLDER + file.getOriginalFilename();
        saveImageToServer(file, key);
        var image = Image.builder()
                .name(imgName)
                .createdTime(new Timestamp(new Date().getTime()))
                .ext(extension)
                .link(doSpaceEndpointForData + File.separator + key)
                .build();
        log.info("Saving image {}", image);
        return imageRepository.save(image);
    }

    public String deleteFile(String filename) {
        try {
            var imagName = filename.substring(filename.lastIndexOf("/") + 1, filename.lastIndexOf("."));
            var data = imageRepository.findImageByName(imagName);
            if (data.isPresent()) {
                var image = data.get();
                var key = FOLDER + image.getName() + "." + image.getExtension();
                s3Client.deleteObject(new DeleteObjectRequest(doSpaceBucket, key));
                imageRepository.delete(image);
                log.info("Deleted image {}", image);
            }
            return "Deleted.";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

}
