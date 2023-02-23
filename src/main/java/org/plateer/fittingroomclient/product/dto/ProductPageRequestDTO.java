package org.plateer.fittingroomclient.product.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.plateer.fittingroomclient.common.dto.PageRequestDTO;



@Data
@NoArgsConstructor
public class ProductPageRequestDTO extends PageRequestDTO {
    Long seNo;
    ProductSearchType[] type;
    String keyword;

    public ProductPageRequestDTO(int page, int size ) { super( page, size ); }

    public ProductPageRequestDTO(int page, int size, ProductSearchType[] type, String keyword ) {
        super( page, size );
        this.type = type;
        this.keyword = keyword;
    }

    public ProductPageRequestDTO(ProductSearchType[] type, String keyword ) {
        this.type = type;
        this.keyword = keyword;
    }

    public ProductPageRequestDTO(Long seNo) {
        this.seNo = seNo;
    }
}
