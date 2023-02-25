package org.plateer.fittingroomclient.room.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.plateer.fittingroomclient.common.dto.PageRequestDTO;


@Data
@NoArgsConstructor
public class RoomPageRequestDTO extends PageRequestDTO {
    RoomSearchType[] type;
    String keyword;

    public RoomPageRequestDTO( int page, int size ) { super( page, size ); }

    public RoomPageRequestDTO( int page, int size, RoomSearchType[] type, String keyword ) {
        super( page, size );
        this.type = type;
        this.keyword = keyword;
    }

    public RoomPageRequestDTO( RoomSearchType[] type, String keyword ) {
        this.type = type;
        this.keyword = keyword;
    }
}
