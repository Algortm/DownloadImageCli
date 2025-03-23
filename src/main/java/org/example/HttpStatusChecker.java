package org.example;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;

public class HttpStatusChecker {
    public String getStatusImage (int code) throws Exception {
        String url ="https://http.cat/" + String.valueOf(code) + ".jpg";
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();
        try {
            Response response = client.newCall(request).execute();
            int codeStatus = response.code();
            if (codeStatus == 200){
                return  url;
            } else {
                throw new Exception("Url not found. Code status - " + codeStatus);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
