package org.plateer.fittingroomclient.room.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.plateer.fittingroomclient.common.dto.PageResultDTO;
import org.plateer.fittingroomclient.common.dto.ResultDTO;
import org.plateer.fittingroomclient.room.dto.RoomDTO;
import org.plateer.fittingroomclient.room.dto.RoomPageRequestDTO;
import org.plateer.fittingroomclient.room.service.RoomService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@Log4j2
@RequiredArgsConstructor
@RequestMapping("api/room")
public class RoomController {
    private final RoomService roomService;


    @GetMapping("list")
    public PageResultDTO<RoomDTO> getRoomList(RoomPageRequestDTO roomPageRequestDTO) {
        return roomService.getRoomList(roomPageRequestDTO);
    }

    @GetMapping("list/{pmNo}")
    public List<RoomDTO> getRoomSellerList(RoomDTO roomDTO) {
        return roomService.getRoomSellerList(roomDTO);
    }
}
