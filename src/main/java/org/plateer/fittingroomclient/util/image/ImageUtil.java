package org.plateer.fittingroomclient.util.image;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

/**
 * 이미지 처리 공통 기능
 * 작성자: 이수영
 * 일시: 2023-02-17
 * 버전: v1
 **/
@Log4j2
@Component(value = "productImageUtil")
public class ImageUtil {

    @Value("${basePath}")
    private String basePath;

    // 이미지 경로에 해당하는 이미지 조회
    public Resource readImage(String storedName) {
        String imagePath = basePath + "/" + storedName;
        try {
            FileSystemResource file = new FileSystemResource(imagePath);
            log.info("[Read] : {}", storedName);

            return file;
        } catch (NullPointerException npe) {
            throw new IllegalArgumentException("[존재하지 않는 파일]: " + imagePath);
        }
    }
}
