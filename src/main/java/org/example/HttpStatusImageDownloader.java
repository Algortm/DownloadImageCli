package org.example;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

public class HttpStatusImageDownloader {
    public void downloadStatusImage (int code) throws Exception {
        HttpStatusChecker connecting = new HttpStatusChecker();
        try {
            String url  = connecting.getStatusImage(code);
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(url)
                    .build();
            Response response = client.newCall(request).execute();
            InputStream inputStream = response.body().byteStream();
            File file = new File("Image"+String.valueOf(code)+".jpg");
            BufferedImage img = ImageIO.read(inputStream);
            ImageIO.write(img, "jpg", file);
        } catch (Exception e) {
            throw e;
        }

    }
}
