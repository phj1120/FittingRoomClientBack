package org.plateer.fittingroomclient.room.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.plateer.fittingroomclient.room.dto.RoomDTO;
import org.plateer.fittingroomclient.room.mapper.RoomMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Log4j2
@Transactional
public class RoomServiceImpl implements RoomService {

    private final RoomMapper roomMapper;

    @Override
    public RoomDTO getRoom(Long roNo) {
        RoomDTO room = roomMapper.getRoom(roNo);
        if (room == null) {
            throw new IllegalArgumentException("존재 하지 않는 장소");
        }

        return room;
    }
}
