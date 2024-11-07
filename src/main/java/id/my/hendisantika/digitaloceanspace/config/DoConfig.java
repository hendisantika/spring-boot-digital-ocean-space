package id.my.hendisantika.digitaloceanspace.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-digital-ocean-space
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 07/11/24
 * Time: 08.02
 * To change this template use File | Settings | File Templates.
 */
@Configuration
public class DoConfig {
    @Value("${do.spaces.key}")
    private String doSpaceKey;

    @Value("${do.spaces.secret}")
    private String doSpaceSecret;

    @Value("${do.spaces.endpoint}")
    private String doSpaceEndpoint;

    @Value("${do.spaces.region}")
    private String doSpaceRegion;


    @Bean
    public AmazonS3 getS3() {
        BasicAWSCredentials creds = new BasicAWSCredentials(doSpaceKey, doSpaceSecret);
        return AmazonS3ClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(doSpaceEndpoint, doSpaceRegion))
                .withCredentials(new AWSStaticCredentialsProvider(creds)).build();
    }
}
