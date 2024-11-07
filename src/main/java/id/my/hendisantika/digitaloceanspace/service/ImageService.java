package id.my.hendisantika.digitaloceanspace.service;

import com.amazonaws.services.s3.AmazonS3;
import id.my.hendisantika.digitaloceanspace.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

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
}
