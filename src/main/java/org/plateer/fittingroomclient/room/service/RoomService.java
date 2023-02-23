package org.plateer.fittingroomclient.room.service;

import org.plateer.fittingroomclient.common.dto.PageResultDTO;
import org.plateer.fittingroomclient.room.dto.RoomDTO;
import org.plateer.fittingroomclient.room.dto.RoomPageRequestDTO;

import java.util.List;

public interface RoomService {
    RoomDTO getRoom(Long roNo);
    
    PageResultDTO<RoomDTO> getRoomList(RoomPageRequestDTO roomPageRequestDTO);

    List<RoomDTO> getRoomSellerList(RoomDTO roomDTO);
}
