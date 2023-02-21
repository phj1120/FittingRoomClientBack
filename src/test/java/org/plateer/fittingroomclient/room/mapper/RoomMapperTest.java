package org.plateer.fittingroomclient.room.mapper;


import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.plateer.fittingroomclient.common.dto.PageResultDTO;
import org.plateer.fittingroomclient.room.dto.RoomDTO;
import org.plateer.fittingroomclient.room.dto.RoomPageRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Log4j2
public class RoomMapperTest {
    @Autowired
    RoomMapper roomMapper;

    @Test
    void getRoomList() {
        RoomPageRequestDTO roomPageRequestDTO = new RoomPageRequestDTO(1, 10);
        List<RoomDTO> dtoList = roomMapper.getRoomList(roomPageRequestDTO);
        int total = roomMapper.getRoomCount(roomPageRequestDTO);

        PageResultDTO<RoomDTO> list = PageResultDTO.<RoomDTO>withAll().dtoList(dtoList).total(total).pageRequestDTO(roomPageRequestDTO).build();
        log.info(list);
    }

    @Test
    void getRoomSellerList() {
        RoomDTO roomDTO = RoomDTO.builder()
                .pmNo(1L)
                .build();

        List<RoomDTO> dtoList = roomMapper.getRoomSellerList(roomDTO);
        log.info(dtoList);
    }
}
