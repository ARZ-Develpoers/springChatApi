package com.project.springchatapi2.domain;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Builder
public class attachFile {

    private int fileKey;

    private String fileUpType;

    private int fileRefKey;

    private String fileOrgnNm;

    private String fileSaveNm;

    private int fileSize;

    private String fileExt;

    private String fileType;

    private int fileImgWdt;

    private int fileImgHgt;

    private Date regDt;

    private String regUsrKey;

    private Date modDt;

    private String modUsrKey;

    private String state;

    private int ver;

}
