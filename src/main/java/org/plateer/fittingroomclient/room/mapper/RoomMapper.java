package org.plateer.fittingroomclient.room.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.plateer.fittingroomclient.room.dto.RoomDTO;
import org.plateer.fittingroomclient.room.dto.RoomPageRequestDTO;

import java.util.List;


@Mapper
public interface RoomMapper {
    // 장소 전체 리스트 총 개수 ( 입어볼래 메인 페이지 )
    int getRoomCount(RoomPageRequestDTO roomPageRequestDTO);

    // 장소 전체 리스트 ( 입어볼래 메인 페이지 )
    List<RoomDTO> getRoomList(RoomPageRequestDTO roomPageRequestDTO);

    // 장소 정보를 통해 판매자 리스트 가져오기 ( 입어볼래 메인 페이지 - 입점 브랜드 보기 클릭 시 )
    List<RoomDTO> getRoomSellerList(RoomDTO roomDTO);

    // 장소 정보 가져오기
    RoomDTO getRoom(Long roNo);
}
