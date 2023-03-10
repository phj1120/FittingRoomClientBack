package org.plateer.fittingroomclient.room.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoomDTO {
    // 장소제공자, 장소, 판매자 번호
    private Long pmNo;
    private Long roNo;
    private Long seNo;

    // 장소제공자, 판매자 상태
    private String pmStatus;
    private String seStatus;

    // 장소정보 ( 지점명, 주소 )
    private String roName;
    private String roAddress;
    private String roDetailAddress;
    private String roPostCode;
    private String roThumbnail;

    // 판매자정보 ( 상호명, 담당자, 연락처, 주소 )
    private String seName;
    private String seManager;
    private String sePhone;
    private String seAddress;

    // 입점 브랜드 체크
    private Boolean brandCheck = false;
}