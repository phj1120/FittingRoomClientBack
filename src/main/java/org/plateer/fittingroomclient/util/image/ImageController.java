package org.plateer.fittingroomclient.util.image;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 이미지 조회를 위한 Controller
 * 작성자: 박현준
 * 일시: 2023-02-17
 * 버전: v1
 **/
@RestController
@RequestMapping
@RequiredArgsConstructor
@Log4j2
public class ImageController {

    private final ImageUtil imageUtil;

    // 이미지 조회
    @GetMapping(value = "/image/{imagePath}", produces = {MediaType.IMAGE_JPEG_VALUE})
    public Resource getImage(@PathVariable("imagePath") String imagePath) {
        Resource file = imageUtil.readImage(imagePath);

        return file;
    }
}
