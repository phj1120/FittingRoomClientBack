package org.plateer.fittingroomclient.common.util.image;


import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;


@Log4j2
@Component(value = "productImageUtil")
public class ImageUtil {
    @Value("${basePath}")
    private static String basePath;

    private static final String product = basePath + "/product/";
    private static final String room = basePath + "/room/";

    // 이미지 경로에 해당하는 이미지 조회
    public Resource readProductImage(String storedName) {
        String imagePath = product + storedName;
        try {
            FileSystemResource file = new FileSystemResource(imagePath);
            log.info("[Read] : {}", storedName);

            return file;
        } catch (NullPointerException npe) {
            throw new IllegalArgumentException("[존재하지 않는 파일]: " + imagePath);
        }
    }

    public Resource readRoomImage(String storedName) {
        String imagePath = room + storedName;
        try {
            FileSystemResource file = new FileSystemResource(imagePath);
            log.info("[Read] : {}", storedName);

            return file;
        } catch (NullPointerException npe) {
            throw new IllegalArgumentException("[존재하지 않는 파일]: " + imagePath);
        }
    }
}
