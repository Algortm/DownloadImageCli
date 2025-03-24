package org.example;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
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
        try (Response response = new OkHttpClient().newCall(request).execute()){
            InputStream inputStream = response.body().byteStream();
            File file = new File("Image"+String.valueOf(code)+".jpg");
            BufferedImage img = ImageIO.read(inputStream);
            ImageIO.write(img, "jpg", file);
            inputStream.close();
        } catch (Exception e) {
            throw e;
        }
    }
}
