package utils.api;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.jsoup.HttpStatusException;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HttpClientManager {
    private HttpClientManager(){
        throw new IllegalStateException("HttpClientManager class cannot be instantiated");
    }

    private static CloseableHttpClient initiateClient() {
        return HttpClientBuilder.create().build();
    }


    public static String post(String url, StringEntity param){
        String responseString = null;
        try (CloseableHttpClient httpClient = HttpClientManager.initiateClient()) {

            HttpPost httpPost = new HttpPost(url);
            if (param != null) {
                httpPost.addHeader("content-type", "application/json");
                httpPost.setEntity(param);
            }

            CloseableHttpResponse response = httpClient.execute(httpPost);

            if (response.getStatusLine().getStatusCode() == 200) {
                HttpEntity entity = response.getEntity();
                responseString = EntityUtils.toString(entity, "UTF-8");
            } else {
                throw new HttpStatusException("Status code exception", response.getStatusLine().getStatusCode(), url);
            }
        } catch (IOException e){
            Logger.getAnonymousLogger().log(Level.SEVERE, "Couldn't post to api");
        }
        return responseString;
    }
}
