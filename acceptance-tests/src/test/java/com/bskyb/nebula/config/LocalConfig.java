package com.bskyb.nebula.config;

import com.amazonaws.services.s3.AmazonS3;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Slf4j
@Configuration
@Profile({"default"})
public class LocalConfig extends DatasourceConfig {

    @Value("${mysqlBackup.clientClass}")
    private String s3ClientClass;

    @Value("${mysqlBackup.accessKey}")
    private String s3AccessKey;

    @Value("${mysqlBackup.secretKey}")
    private String s3SecretKey;


}
