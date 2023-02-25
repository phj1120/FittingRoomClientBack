package org.plateer.fittingroomclient.product.mapper;


import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.plateer.fittingroomclient.common.dto.PageResultDTO;
import org.plateer.fittingroomclient.product.dto.ProductDTO;
import org.plateer.fittingroomclient.product.dto.ProductPageRequestDTO;
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
    void getSellerProductList() {
        ProductPageRequestDTO productPageRequestDTO = new ProductPageRequestDTO(1L);

        List<ProductDTO> dtoList = productMapper.getSellerProductList( productPageRequestDTO );
        int total = productMapper.getSellerProductCount( productPageRequestDTO );

        PageResultDTO pageResultDTO = PageResultDTO.<ProductDTO>withAll().dtoList(dtoList).total(total).pageRequestDTO(productPageRequestDTO).build();
        log.info(pageResultDTO);
    }
}
