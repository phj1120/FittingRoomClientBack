package org.plateer.fittingroomclient.room.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.plateer.fittingroomclient.room.dto.RoomDTO;

import java.util.List;


@Mapper
public interface RoomMapper {
    // 장소, 판매자 전체 리스트 ( 입어볼래 메인 페이지 )
    List<RoomDTO> getRoomList();
}
