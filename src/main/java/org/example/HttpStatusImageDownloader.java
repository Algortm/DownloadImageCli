package org.example;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

public class HttpStatusImageDownloader {
    public void downloadStatusImage(int code) throws Exception {
        HttpStatusChecker connecting = new HttpStatusChecker();
        String url  = connecting.getStatusImage(code);
        Request request = new Request.Builder()
                .url(url)
                .build();
        try (InputStream inputStream = new OkHttpClient().newCall(request).execute().body().byteStream()){
            File file = new File("Image"+String.valueOf(code)+".jpg");
            BufferedImage img = ImageIO.read(inputStream);
            ImageIO.write(img, "jpg", file);
        } catch (Exception e) {
            throw e;
        }
    }
}
