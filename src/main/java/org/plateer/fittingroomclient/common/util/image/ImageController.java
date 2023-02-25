package org.plateer.fittingroomclient.common.util.image;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping
@RequiredArgsConstructor
public class ImageController {

    private final ImageUtil imageUtil;

    // 이미지 조회
    @GetMapping(value = "/image/product/{imagePath}", produces = {MediaType.IMAGE_JPEG_VALUE})
    public Resource getProductImage(@PathVariable("imagePath") String imagePath) {
        Resource file = imageUtil.readProductImage(imagePath);

        return file;
    }

    @GetMapping(value = "/image/room/{imagePath}", produces = {MediaType.IMAGE_JPEG_VALUE})
    public Resource getRoomImage(@PathVariable("imagePath") String imagePath) {
        Resource file = imageUtil.readRoomImage(imagePath);

        return file;
    }
}
