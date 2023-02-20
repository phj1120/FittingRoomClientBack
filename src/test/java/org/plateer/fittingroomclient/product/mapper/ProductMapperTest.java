package org.plateer.fittingroomclient.product.mapper;


import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.plateer.fittingroomclient.product.dto.ProductDTO;
import org.plateer.fittingroomclient.room.dto.RoomDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Log4j2
public class ProductMapperTest {
    @Autowired
    ProductMapper productMapper;

    @Test
    void getRoomList() {
        ProductDTO productDTO = ProductDTO.builder()
                .pmNo(1L)
                .build();
        List<ProductDTO> dtoList = productMapper.getRoomProductList(productDTO);
        log.info(dtoList);
    }
}
