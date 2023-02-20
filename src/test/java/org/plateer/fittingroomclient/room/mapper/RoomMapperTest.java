package org.plateer.fittingroomclient.room.mapper;


import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.plateer.fittingroomclient.room.dto.RoomDTO;
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
        List<RoomDTO> dtoList = roomMapper.getRoomList();
        log.info(dtoList);
    }
}
