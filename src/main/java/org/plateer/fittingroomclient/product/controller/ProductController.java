package org.plateer.fittingroomclient.product.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.plateer.fittingroomclient.common.dto.PageResultDTO;
import org.plateer.fittingroomclient.common.dto.ResultDTO;
import org.plateer.fittingroomclient.product.dto.ProductDTO;
import org.plateer.fittingroomclient.product.dto.ProductDetailDTO;
import org.plateer.fittingroomclient.product.dto.ProductPageRequestDTO;
import org.plateer.fittingroomclient.product.service.ProductService;
import org.plateer.fittingroomclient.room.dto.RoomDTO;
import org.plateer.fittingroomclient.room.dto.RoomPageRequestDTO;
import org.plateer.fittingroomclient.room.service.RoomService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@Log4j2
@RequiredArgsConstructor
@RequestMapping("api/product")
public class ProductController {
    private final ProductService productService;


    @GetMapping("list/{seNo}")
    public PageResultDTO<ProductDTO> getSellerProductList(ProductPageRequestDTO productPageRequestDTO) {
        return productService.getSellerProductList(productPageRequestDTO);
    }

    @GetMapping("detail/{prNo}")
    public List<ProductDetailDTO> getProduct(ProductDetailDTO productDetailDTO) {
        return productService.getProduct(productDetailDTO);
    }

    @GetMapping("option/{prNo}")
    public List<ProductDetailDTO> getProductOption(ProductDetailDTO productDetailDTO) {
        return productService.getProductOption(productDetailDTO);
    }
}
