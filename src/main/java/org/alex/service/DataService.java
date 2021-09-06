package org.alex.service;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class DataService {

    public String getContent() {
        try {
            URL url = new URL("https://www.willhaben.at/iad/gebrauchtwagen/auto/gebrauchtwagenboerse?sfId=4b60eaf0-e475-470a-908e-1b5a19a81ecc&rows=25&isNavigation=true&areaId=2&MOTOR_CONDITION=20&page=1&PRICE_TO=5000");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            InputStream content = (InputStream) con.getContent();
            BufferedInputStream in = new BufferedInputStream(content);
            return mapReaderToString(in);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    private String mapReaderToString(BufferedInputStream in) throws IOException {
        String contentStr = "";
        byte[] contents = new byte[1024];
        int bytesRead = 0;
        while ((bytesRead = in.read(contents)) != -1) {
            contentStr += new String(contents, 0, bytesRead);
        }
        return contentStr;
    }
}
