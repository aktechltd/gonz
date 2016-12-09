package com.bskyb.nebula.steps;

import com.bskyb.nebula.helpers.Common;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

@Slf4j
@ContextConfiguration("classpath:cucumber.xml")
public class BaseStep {

    private static final ObjectMapper JSON_MAPPER = new ObjectMapper();
    private static URL url;

    static {
        JSON_MAPPER.getFactory().enable(JsonParser.Feature.AUTO_CLOSE_SOURCE);
    }

    @Value("${api.server.base}")
    protected String serverBaseUri;

    public boolean checkEnvironment() throws IOException {

        System.out.println("----------"+serverBaseUri);

        url = new URL(serverBaseUri);
        if(Common.httpGetRequest(url)==200){
            return true;
        }else{
            return false;
        }
    }

    @Test
    public void dummyTest() throws IOException {
        System.out.println(checkEnvironment());
    }

}
