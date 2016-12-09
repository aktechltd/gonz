package com.bskyb.nebula.helpers;


import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.*;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.net.URL;

public class Common {

    private static CloseableHttpClient closeableHttpClient = null;

    public static int httpGetRequest(URL url) throws IOException {

        closeableHttpClient = HttpClients.createDefault();

        HttpGet get = new HttpGet("");

        CloseableHttpResponse closeableHttpResponse = closeableHttpClient.execute(get);

        return closeableHttpResponse.getStatusLine().getStatusCode();
    }




}
