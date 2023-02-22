package org.plateer.fittingroomclient.room.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.plateer.fittingroomclient.common.dto.PageResultDTO;
import org.plateer.fittingroomclient.room.dto.RoomDTO;
import org.plateer.fittingroomclient.room.dto.RoomPageRequestDTO;
import org.plateer.fittingroomclient.room.mapper.RoomMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@RequiredArgsConstructor
@Log4j2
@Service
@Transactional
public class RoomServiceImpl implements RoomService {
    private final RoomMapper roomMapper;


    @Override
    public PageResultDTO<RoomDTO> getRoomList(RoomPageRequestDTO roomPageRequestDTO) {
        List<RoomDTO> dtoList = roomMapper.getRoomList(roomPageRequestDTO);
        int total = roomMapper.getRoomCount(roomPageRequestDTO);

        PageResultDTO<RoomDTO> pageResultDTO = PageResultDTO.<RoomDTO>withAll().dtoList(dtoList).total(total).pageRequestDTO(roomPageRequestDTO).build();
        return pageResultDTO;
    }

    @Override
    public List<RoomDTO> getRoomSellerList(RoomDTO roomDTO) {
        return roomMapper.getRoomSellerList(roomDTO);
    }
}
